package models.Tecnologia;

import enums.SOComputadora;

public class Escritorio extends Computadora {
    private String gabinete;
    private float fuente;


    public Escritorio(String nombre, String cdp, int stock, double precio, String marca, String modelo, float peso, String color, int anio, SOComputadora so, String procesador, int ram, int capacidad, String gabinete, float fuente) {
        super(nombre, cdp, stock, precio, marca, modelo, peso, color, anio, so, procesador, ram, capacidad);
        this.gabinete = gabinete;
        this.fuente = fuente;
    }

    /**Constructores*/


    public Escritorio() {
    }



    /**Getters y Setters*/
    public String getGabinete() {
        return gabinete;
    }
    public Escritorio gabinete(String gabinete) {
        this.gabinete = gabinete;
        return this;
    }
    public float getFuente() {
        return fuente;
    }
    public Escritorio fuente(float fuente) {
        this.fuente = fuente;
        return this;
    }



    /**Imprimir*/
    public void imprimir() {
        super.imprimir();
        System.out.println("Gabinete:..................: " + gabinete);
        System.out.println("Fuente.....................: " + fuente);
        System.out.println("==============================================");
        System.out.println("");

    }

    @Override
    public void imprimirCliente() {
        super.imprimir();
        System.out.println("Gabinete:..................: " + gabinete);
        System.out.println("Fuente.....................: " + fuente);
        System.out.println("==============================================");
        System.out.println("");

    }

    @Override
    public String toString() {
        return "Escritorio{" +
                "gabinete='" + gabinete + '\'' +
                ", fuente=" + fuente +
                '}';
    }
}
