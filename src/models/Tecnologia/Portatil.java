package models.Tecnologia;

import enums.SOComputadora;

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
        return "Portatil{" +
                "tamanio=" + tamanio +
                ", duracionBateria=" + duracionBateria +
                '}';
    }
}
