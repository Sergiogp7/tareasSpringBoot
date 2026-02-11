package com.example.ProyectoSpring.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoSpring.entidad.Producto;
import com.example.ProyectoSpring.repositorio.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
	
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    public Producto obtenerPorId(Long id) {
        Optional<Producto> optional = productoRepository.findById(id);
        return optional.orElse(null);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}