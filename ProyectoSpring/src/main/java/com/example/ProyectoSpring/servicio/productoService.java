package com.example.ProyectoSpring.servicio;

import java.util.List;

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

}