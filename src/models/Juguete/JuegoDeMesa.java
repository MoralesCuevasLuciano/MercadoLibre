package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;

public class JuegoDeMesa extends  Juguete{
    int cantidadJugadores;
    int duracion;

    public JuegoDeMesa(String nombre, String marca, String modelo, double precio, int stock, CategoriaJuguete categoria, int edad, MaterialJuguete material, int cantidadJugadores, int duracion) {
        super(nombre, marca, modelo, precio, stock, categoria, edad, material);
        this.cantidadJugadores = cantidadJugadores;
        this.duracion = duracion;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public JuegoDeMesa CantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
        return this;
    }

    public int getDuracion() {
        return duracion;
    }

    public JuegoDeMesa Duracion(int duracion) {
        this.duracion = duracion;
        return this;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Duracion:" + getDuracion());
        System.out.println("Cantidad de Jugadores: " + getCantidadJugadores());
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Duracion:" + getDuracion());
        System.out.println("Cantidad de Jugadores: " + getCantidadJugadores());
    }
}
