package models.Tecnologia;

import enums.SOComputadora;

import static mocks.Mock.*;

public class Portatil extends Computadora {
    private int tamanio;
    private float duracionBateria;


    public Portatil(String nombre, String cdp, int stock, double precio, String marca, String modelo, float peso, String color, int anio, SOComputadora so, String procesador, int ram, int capacidad, int tamanio, float duracionBateria) {
        super(nombre, cdp, stock, precio, marca, modelo, peso, color, anio, so, procesador, ram, capacidad);
        this.tamanio = tamanio;
        this.duracionBateria = duracionBateria;
    }

    /**Constructores*/


    public Portatil() {
    }


    /**Getters y Setters*/
    public int getTamanio() {
        return tamanio;
    }
    public Portatil tamanio(int tamanio) {
        this.tamanio = tamanio;
        return this;
    }
    public float getDuracionBateria() {
        return duracionBateria;
    }
    public Portatil duracionBateria(float duracionBateria) {
        this.duracionBateria = duracionBateria;
        return this;
    }



    /**Imprimir*/
    public void imprimir() {
        super.imprimir();
        System.out.println("Gabinete:..................: " + tamanio);
        System.out.println("Fuente.....................: " + duracionBateria);
        System.out.println("==============================================");
        System.out.println("");

    }

    @Override
    public void imprimirCliente() {
        super.imprimir();
        System.out.println("Gabinete:..................: " + tamanio);
        System.out.println("Fuente.....................: " + duracionBateria);
        System.out.println("==============================================");
        System.out.println("");

    }


    @Override
    public String toString() {
        return super.toString() +
                "\nTamanio:........................: " + tamanio +
                "\nDuracion de bateria:............: " + duracionBateria +
                "\n==============================================\n\n";
    }

    public static Portatil portatilRandom(){
        Portatil portatil = (Portatil) new Portatil();
        portatil.tamanio = (int) (Math.random() * 100);
        portatil.duracionBateria = (float) (Math.random() * 800);
        portatil.so(SOComputadora.values()[(int) Math.random() * SOComputadora.values().length]);
        portatil.procesador(getNombreProcesadorPc());
        portatil.ram((int) (Math.random() * 32));
        portatil.capacidad((int) (Math.random() * 2000));
        portatil.peso((float) (Math.random() * 10));
        portatil.color(getColores());
        portatil.anio((int) (Math.random() * (2024-2018 + 1) + 2018));
        portatil.marca(getMarcaTecnologia());
        portatil.modelo(getModeloComputadoras());
        portatil.nombre(portatil.getMarca() + " " + portatil.getModelo());
        portatil.precio((Math.random() * 2000000));
        portatil.stock((int) (Math.random() * 100));
        return portatil;
    }
}
