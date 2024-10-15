package models;

import java.util.UUID;

public abstract class Producto {
    private String id;
    private String nombre;
    private int stock;
    private double precio;
    private String marca;

    public Producto(String nombre, String marca, String modelo, double precio, int stock) {
        this.id = UUID.randomUUID().toString();
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto() {
    }


    private String modelo;

    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public Producto Marca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Producto Modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto Nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public double getPrecio() {
        return precio;
    }

    public Producto Precio(double precio) {
        this.precio = precio;
        return this;
    }

    public int getStock() {
        return stock;
    }

    public Producto Stock(int stock) {
        this.stock = stock;
        return this;
    }

    public abstract void imprimir();

    //IMPRIMIR SIN ID Y SIN STOCK YA QUE SON DATOS NO NECESARIOS PARA LOS CLIENTES

    public abstract void imprimirCliente();

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
