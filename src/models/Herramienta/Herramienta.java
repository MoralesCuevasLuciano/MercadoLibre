package models.Herramienta;

import models.Producto;

public abstract class Herramienta extends Producto {


    /**Constructores*/
    public Herramienta(String nombre, String marca, String modelo, double precio, int stock) {
        super(nombre, marca, modelo, precio, stock);
    }



    /**Imprimir*/
    @Override
    public void imprimir() {
        System.out.println("ID:........................" + getId());
        System.out.println("Nombre:...................." + getNombre());
        System.out.println("Marca:....................." + getMarca());
        System.out.println("Modelo:...................." + getModelo());
        System.out.println("Precio:...................." + getPrecio());
        System.out.println("Stock:....................." + getStock());
        System.out.println("==============================================");
    }

    @Override
    public void imprimirCliente() {
        System.out.println("Nombre:...................." + getNombre());
        System.out.println("Marca:....................." + getMarca());
        System.out.println("Modelo:...................." + getModelo());
        System.out.println("Precio:...................." + getPrecio());
        System.out.println("==============================================");
    }


    @Override
    public String toString() {
        return "Herramienta{}";
    }

    /**Equals y HashCode*/
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
