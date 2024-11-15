package models.Herramienta;

import models.Producto;

public abstract class Herramienta extends Producto {

    /**Constructores*/
    public Herramienta(String nombre, String cdp, int stock, double precio, String marca, String modelo) {
        super(nombre, cdp, stock, precio, marca, modelo);
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
