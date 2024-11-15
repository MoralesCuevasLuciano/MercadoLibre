package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;
import models.Producto;

public class JugueteElectrico extends Juguete{
    int cantidadDePilas;
    float voltaje;


    public JugueteElectrico(String nombre, String cdp, int stock, double precio, String marca, String modelo, int edad, CategoriaJuguete categoria, MaterialJuguete material, int cantidadDePilas, float voltaje) {
        super(nombre, cdp, stock, precio, marca, modelo, edad, categoria, material);
        this.cantidadDePilas = cantidadDePilas;
        this.voltaje = voltaje;
    }

    /**Constructores*/

    public JugueteElectrico() {
    }

    /**Getters y Setters*/
    public int getCantidadDePilas() {
        return cantidadDePilas;
    }
    public JugueteElectrico cantidadDePilas(int cantidadDePilas) {
        this.cantidadDePilas = cantidadDePilas;
        return this;
    }
    public float getVoltaje() {
        return voltaje;
    }
    public JugueteElectrico voltaje(float voltaje) {
        this.voltaje = voltaje;
        return this;
    }
    public JugueteElectrico voltaje(int voltaje) {
        this.voltaje = (float) voltaje;
        return this;
    }



    /**Imprimir*/
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Cantidad de baterias.......: " + getCantidadDePilas());
        System.out.println("Voltaje....................: " + getVoltaje());
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Cantidad de baterias.......: " + getCantidadDePilas());
        System.out.println("Voltaje....................: " + getVoltaje());
    }

    @Override
    public String toString() {
        return "JugueteElectrico{" +
                "cantidadDePilas=" + cantidadDePilas +
                ", voltaje=" + voltaje +
                '}';
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
