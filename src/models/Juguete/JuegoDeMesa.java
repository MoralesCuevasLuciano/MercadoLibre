package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialInsumo;
import enums.MaterialJuguete;
import mocks.Mock;
import models.Herramienta.Insumo;
import models.Producto;

public class JuegoDeMesa extends  Juguete{
    int cantidadJugadores;
    int duracion;


    public JuegoDeMesa(String nombre, String cdp, int stock, double precio, String marca, String modelo, int edad, CategoriaJuguete categoria, MaterialJuguete material, int cantidadJugadores, int duracion) {
        super(nombre, cdp, stock, precio, marca, modelo, edad, categoria, material);
        this.cantidadJugadores = cantidadJugadores;
        this.duracion = duracion;
    }

    /**Constructores*/


    public JuegoDeMesa() {
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
        System.out.println("Duracion:..................: " + getDuracion());
        System.out.println("Cantidad de Jugadores:.....: " + getCantidadJugadores());
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Duracion:..................: " + getDuracion());
        System.out.println("Cantidad de Jugadores:.....: " + getCantidadJugadores());
        System.out.println("==============================================");
        System.out.println("");
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

    public static JuegoDeMesa juegoDeMesaRandom() {
        JuegoDeMesa juegoDeMesa = (JuegoDeMesa) new JuegoDeMesa()
                .cantidadJugadores((int) Math.random() *5)
                .duracion((int)Math.random() * 120)
                .stock(Mock.getStock())
                .precio(Mock.getPrecio())
                .nombre(Mock.getNombreJuegosMesa())
                .marca(Mock.getMarcaJuguetes())
                .modelo(Mock.getModeloJuegosDeMesa());
        return juegoDeMesa;
    }


}
