package com.example.ProyectoSpring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoSpring.entidad.Pedido;

public interface pedidoRepository extends JpaRepository<Pedido, Long>  {

}
    