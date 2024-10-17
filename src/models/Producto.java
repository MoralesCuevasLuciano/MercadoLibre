package models;

import java.util.Objects;
import java.util.UUID;

public abstract class Producto implements Comparable<Producto> {
    private String id;
    private String nombre;
    private int stock;
    private double precio;
    private String marca;
    private String modelo;

    /**Constructores*/
    public Producto(String nombre, String marca, String modelo, double precio, int stock) {
        this.id = UUID.randomUUID().toString();
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public Producto() {
        this.id = UUID.randomUUID().toString();
    }


    /**Getters y Setters*/
    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public Producto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Producto stock(int stock) {
        this.stock = stock;
        return this;
    }

    public Producto precio(double precio) {
        this.precio = precio;
        return this;
    }

    public Producto marca(String marca) {
        this.marca = marca;
        return this;
    }

    public Producto modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    /**Imprimir*/
    public void imprimir() {
        System.out.println("ID:........................: " + getId());
        System.out.println("Nombre:....................: " + getNombre());
        System.out.println("Marca:.....................: " + getMarca());
        System.out.println("Modelo:....................: " + getModelo());
        System.out.println("Precio:....................: " + getPrecio());
        System.out.println("Stock:.....................: " + getStock());

    }


    /**IMPRIMIR SIN ID YA QUE SON DATOS NO NECESARIOS PARA LOS CLIENTES*/
    public void imprimirCliente() {
        System.out.println("Nombre:....................: " + getNombre());
        System.out.println("Marca:.....................: " + getMarca());
        System.out.println("Modelo:....................: " + getModelo());
        System.out.println("Precio:....................: " + getPrecio());
        System.out.println("Stock......................: " + getStock());
    }

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


    /**Equals y HashCode*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return stock == producto.stock && Double.compare(precio, producto.precio) == 0 && Objects.equals(id, producto.id) && Objects.equals(nombre, producto.nombre) && Objects.equals(marca, producto.marca) && Objects.equals(modelo, producto.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, stock, precio, marca, modelo);
    }

    @Override
    public int compareTo(Producto o) {
        return Double.compare(this.precio,o.precio);
    }
}
