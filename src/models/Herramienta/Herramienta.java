package models.Herramienta;

import models.Producto;

public abstract class Herramienta extends Producto {

    public Herramienta(String nombre, String marca, String modelo, double precio, int stock) {
        super(nombre, marca, modelo, precio, stock);
    }

    @Override
    public void imprimir() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Marca " + getMarca());
        System.out.println("Modelo " + getModelo());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Stock: " + getStock());
    }

    @Override
    public void imprimirCliente() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Marca " + getMarca());
        System.out.println("Modelo " + getModelo());
        System.out.println("Precio: " + getPrecio());
    }
}
