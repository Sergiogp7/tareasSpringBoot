package com.example.ProyectoSpring.entidad;

public class Pedido {
    private Long id;
    private String fecha;
    private double total;
    private Producto producto;


public Pedido() {
}

public Pedido(Long id, String fecha, double total, Producto producto) {
    this.id = id;
    this.fecha = fecha;
    this.total = total;
    this.producto = producto;
}


public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getFecha() {
    return fecha;
}

public void setFecha(String fecha) {
    this.fecha = fecha;
}

public double getTotal() {
    return total;
}

public void setTotal(double total) {
    this.total = total;
}

public Producto getProducto() {
    return producto;
}

public void setProducto(Producto producto) {
    this.producto = producto;
}

}