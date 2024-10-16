package models.Herramienta;

import models.Producto;

public abstract class Herramienta extends Producto {


    /**Constructores*/
    public Herramienta(String nombre, String marca, String modelo, double precio, int stock) {
        super(nombre, marca, modelo, precio, stock);
    }

    public Herramienta() {
    }

    /**Imprimir*/



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
