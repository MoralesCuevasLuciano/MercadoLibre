package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;

public class JugueteElectrico extends Juguete{
    int cantidadDePilas;
    float voltaje;

    public JugueteElectrico(String nombre, String marca, String modelo, double precio, int stock, CategoriaJuguete categoria, int edad, MaterialJuguete material, int cantidadDePilas, float voltaje) {
        super(nombre, marca, modelo, precio, stock, categoria, edad, material);
        this.cantidadDePilas = cantidadDePilas;
        this.voltaje = voltaje;
    }


    public int getCantidadDePilas() {
        return cantidadDePilas;
    }

    public JugueteElectrico CantidadDePilas(int cantidadDePilas) {
        this.cantidadDePilas = cantidadDePilas;
        return this;
    }

    public float getVoltaje() {
        return voltaje;
    }

    public JugueteElectrico Voltaje(float voltaje) {
        this.voltaje = voltaje;
        return this;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Cantidad de baterias" + getCantidadDePilas());
        System.out.println("Voltaje " + getVoltaje());
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Cantidad de baterias" + getCantidadDePilas());
        System.out.println("Voltaje " + getVoltaje());
    }
}
