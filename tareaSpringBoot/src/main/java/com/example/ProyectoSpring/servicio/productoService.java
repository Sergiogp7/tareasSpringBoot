package com.example.ProyectoSpring.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoSpring.entidad.Producto;
import com.example.ProyectoSpring.repositorio.productoRepository;

@Service
public class productoService {

@Autowired
private productoRepository productoRepository;
	
	public List<Producto> listarTodos() {
		return productoRepository.findAll();
	}

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}