package models.Tecnologia;

import enums.SOCelular;

public class Celular extends Tecnologia{
    private SOCelular so;
    private int duracionBateria;
    private float tamanioPantalla;
    private String procesador;
    private int ram;
    private int capacidad;


    public Celular(String nombre, String cdp, int stock, double precio, String marca, String modelo, float peso, String color, int anio, SOCelular so, int duracionBateria, float tamanioPantalla, String procesador, int ram, int capacidad) {
        super(nombre, cdp, stock, precio, marca, modelo, peso, color, anio);
        this.so = so;
        this.duracionBateria = duracionBateria;
        this.tamanioPantalla = tamanioPantalla;
        this.procesador = procesador;
        this.ram = ram;
        this.capacidad = capacidad;
    }

    /**Constructores*/


    public Celular() {
    }


    /**Getters y Setters*/
    public SOCelular getSO() {
        return so;
    }
    public int getDuracionBateria() {
        return duracionBateria;
    }
    public Celular duracionBateria(int duracionBateria) {
        this.duracionBateria = duracionBateria;
        return this;
    }
    public float getTamanioPantalla() {
        return tamanioPantalla;
    }
    public Celular tamanioPantalla(float tamanioPantalla) {
        this.tamanioPantalla = tamanioPantalla;
        return this;
    }
    public String getProcesador() {
        return procesador;
    }
    public Celular procesador(String procesador) {
        this.procesador = procesador;
        return this;
    }
    public int getRam() {
        return ram;
    }
    public Celular ram(int ram) {
        this.ram = ram;
        return this;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public Celular capacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }



    /**Imprimir*/
    public void imprimir() {
        super.imprimir();
        System.out.println("Sistema Operativo:.........: " + so);
        System.out.println("Duracion de la Bateria.....: " + duracionBateria);
        System.out.println("Tamaño pantalla:...........: " + tamanioPantalla);
        System.out.println("Procesador.................: " + procesador);
        System.out.println("Ram........................: " + ram);
        System.out.println("Capacidad..................: " + capacidad);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Sistema Operativo:.........: " + so);
        System.out.println("Duracion de la Bateria.....: " + duracionBateria);
        System.out.println("Tamaño pantalla:...........: " + tamanioPantalla);
        System.out.println("Procesador.................: " + procesador);
        System.out.println("Ram........................: " + ram);
        System.out.println("Capacidad..................: " + capacidad);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Celular{" +
                "so=" + so +
                ", duracionBateria=" + duracionBateria +
                ", tamanioPantalla=" + tamanioPantalla +
                ", procesador='" + procesador + '\'' +
                ", ram=" + ram +
                ", capacidad=" + capacidad +
                '}';
    }
}
