package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;
import models.Producto;

public class JugueteElectrico extends Juguete{
    int cantidadDePilas;
    float voltaje;


    /**Constructores*/
    public JugueteElectrico(String nombre, String marca, String modelo, double precio, int stock, CategoriaJuguete categoria, int edad, MaterialJuguete material, int cantidadDePilas, float voltaje) {
        super(nombre, marca, modelo, precio, stock, categoria, edad, material);
        this.cantidadDePilas = cantidadDePilas;
        this.voltaje = voltaje;
    }

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

    @Override
    public int compareTo(Producto o) {
        return 0;
    }
}
