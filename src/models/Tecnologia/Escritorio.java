package models.Tecnologia;

import enums.SOComputadora;

public class Escritorio extends Computadora {
    private String gabinete;
    private float fuente;



    /**Constructores*/
    public Escritorio(String nombre, String marca, String modelo, double precio, int stock, float peso, String color, int anio, SOComputadora SO, String procesador, int ram, int capacidad, String gabinete, float fuente) {
        super(nombre, marca, modelo, precio, stock, peso, color, anio, SO, procesador, ram, capacidad);
        this.gabinete = gabinete;
        this.fuente = fuente;
    }

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
