package com.example.ProyectoSpring.configuracion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ProyectoSpring.entidad.Pedido;
import com.example.ProyectoSpring.entidad.Producto;
import com.example.ProyectoSpring.repositorio.pedidoRepository;
import com.example.ProyectoSpring.repositorio.productoRepository;
import com.github.javafaker.Faker;

@Component
public class InicializadorDatos implements CommandLineRunner  {
	 @Autowired
	    private pedidoRepository pedidoRepository;

	    @Autowired
	    private productoRepository productoRepository;

	@Override
	public void run(String... args) throws Exception {

		 Faker faker = new Faker();
	        List<Pedido> pedidos = new ArrayList<>();

	        // Crear 10 autores
	        for (int i = 0; i < 10; i++) {
	            Pedido pedido = new Pedido();
pedido.setFecha(faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toString());
	            pedidos.add(pedido);

	            // Para cada autor, crear de 1 a 3 libros
	            int numLibros = faker.number().numberBetween(1, 4);
	            for (int j = 0; j < numLibros; j++) {
	                Producto producto = new Producto();
	                producto.setNombre(faker.book().title());
	                producto.setPedido(pedido);
	                pedido.getProductos().add(producto);
	            }
	        }

	        pedidoRepository.saveAll(pedidos);
	}

}
