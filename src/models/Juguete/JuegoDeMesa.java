package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;
import models.Producto;

public class JuegoDeMesa extends  Juguete{
    int cantidadJugadores;
    int duracion;


    /**Constructores*/
    public JuegoDeMesa(String nombre, String marca, String modelo, double precio, int stock, CategoriaJuguete categoria, int edad, MaterialJuguete material, int cantidadJugadores, int duracion) {
        super(nombre, marca, modelo, precio, stock, categoria, edad, material);
        this.cantidadJugadores = cantidadJugadores;
        this.duracion = duracion;
    }



    /**Getters y Setters*/
    public int getCantidadJugadores() {
        return cantidadJugadores;
    }
    public JuegoDeMesa cantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
        return this;
    }
    public int getDuracion() {
        return duracion;
    }
    public JuegoDeMesa duracion(int duracion) {
        this.duracion = duracion;
        return this;
    }



    /**Imprimir*/
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Duracion:.................." + getDuracion());
        System.out.println("Cantidad de Jugadores:....." + getCantidadJugadores());
        System.out.println("==============================================");
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Duracion:.................." + getDuracion());
        System.out.println("Cantidad de Jugadores:....." + getCantidadJugadores());
        System.out.println("==============================================");
    }



    /**Equals y HashCode*/
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Producto o) {
        return 0;
    }
}
