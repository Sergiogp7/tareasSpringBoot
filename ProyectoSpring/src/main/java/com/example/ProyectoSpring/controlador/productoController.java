package com.example.ProyectoSpring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProyectoSpring.entidad.Producto;
import com.example.ProyectoSpring.servicio.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
    private ProductoService productoService;

	@GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
		return "productos/lista";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model m) {
		Producto p = new Producto();
		m.addAttribute("producto", p);
		return "productos/formulario";
	}

	@PostMapping
	public String guardar(@ModelAttribute("producto") Producto p) {
		productoService.guardar(p);
		return "redirect:/productos";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model m) {
		Producto p = productoService.obtenerPorId(id);
		m.addAttribute("producto", p);
		return "productos/formulario";
	}

	@PostMapping("/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto) {
        Producto productoExistente = productoService.obtenerPorId(id);
        productoExistente.setId(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
		
        productoService.guardar(productoExistente);
		return "redirect:/productos";
	}

	@GetMapping("/eliminar/{id}")
	public String borrar(@PathVariable Long id) {
		productoService.eliminar(id);
		return "redirect:/productos";
	}
}
