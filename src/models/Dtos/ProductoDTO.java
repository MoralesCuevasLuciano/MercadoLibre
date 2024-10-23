package models.Dtos;

import models.Producto;

public class ProductoDTO {
    private String nombre;
    private String marca;
    private String modelo;
    private int cantidad;
    private double precio;

    public ProductoDTO(Producto p, int cantidad) {
        this.nombre = p.getNombre();
        this.marca = p.getMarca();
        this.modelo = p.getModelo();
        this.cantidad = cantidad;

    }

    /** GETTERS AND SETTERS*/

    public String getNombre() {
        return nombre;
    }

    public ProductoDTO setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public ProductoDTO setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public ProductoDTO setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ProductoDTO setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public double getPrecio() {
        return precio;
    }

    public ProductoDTO setPrecio(double precio) {
        this.precio = precio;
        return this;
    }
}
