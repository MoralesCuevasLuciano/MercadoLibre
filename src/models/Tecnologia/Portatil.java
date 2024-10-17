package models.Tecnologia;

import enums.SOComputadora;

public class Portatil extends Computadora {
    private int tamanio;
    private float duracionBateria;

    /**
     * Constructores
     */

    public Portatil(String nombre, String marca, String modelo, double precio, int stock, float peso, String color, int anio, SOComputadora SO, String procesador, int ram, int capacidad, int tamanio, float duracionBateria) {
        super(nombre, marca, modelo, precio, stock, peso, color, anio, SO, procesador, ram, capacidad);
        this.tamanio = tamanio;
        this.duracionBateria = duracionBateria;
    }

    public Portatil() {
    }

    /**
     * Getters y Setters
     */

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

    /**
     * Imprimir
     */

    public void imprimir() {
        super.imprimir();
        System.out.println("Gabinete:......................: " + getTamanio());
        System.out.println("Fuente.......................: " + getDuracionBateria());

    }

    @Override
    public void imprimirCliente() {
        super.imprimir();
        System.out.println("Gabinete:......................: " + getTamanio());
        System.out.println("Fuente.......................: " + getDuracionBateria());

    }
}
