package com.example.ProyectoSpring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProyectoSpring.entidad.Producto;
import com.example.ProyectoSpring.servicio.productoService;

@Controller
@RequestMapping("/productos")
public class productoController {
    @Autowired
    private productoService productoService;

    @GetMapping
    public String listarProductos(@RequestParam(defaultValue = "0") int page, 
                                  @RequestParam(defaultValue = "5") int size, 
                                  Model model) {
        Page<Producto> productosPage = productoService.listarPagina(PageRequest.of(page, size));
        model.addAttribute("productos", productosPage);
        return "productos/lista";
    }

    @GetMapping("/{id}")
    public String verProducto(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.obtenerPorId(id));
        return "productos/ver";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.obtenerPorId(id));
        return "productos/form";
    }

    @PostMapping("/{id}/editar")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto) {
        Producto productoExistente = productoService.obtenerPorId(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        productoService.guardar(productoExistente);
        return "redirect:/productos";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }
}
