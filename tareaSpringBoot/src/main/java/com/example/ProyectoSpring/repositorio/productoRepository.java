package com.example.ProyectoSpring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoSpring.entidad.Producto;

public interface productoRepository extends JpaRepository<Producto, Long> {
    
}
