package com.example.ProyectoSpring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.example.ProyectoSpring.servicio.productoService;

@Controller
@RequestMapping("/producto")
public class productoController {
    @Autowired
    private productoService productoService;

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        return "productos/lista";
    }
}
