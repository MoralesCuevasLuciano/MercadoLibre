package models.Tecnologia;

import enums.SOCelular;

public class Celular extends Tecnologia{
    private SOCelular so;
    private int duracionBateria;
    private float tamanioPantalla;
    private String procesador;
    private int ram;
    private int capacidad;

    /**Constructores*/

    public Celular(String nombre, String marca, String modelo, double precio, int stock, float peso, String color, int anio, SOCelular SO, int duracionBateria, float tamanioPantalla, String procesador, int ram, int capacidad) {
        super(nombre, marca, modelo, precio, stock, peso, color, anio);
        this.so = so;
        this.duracionBateria = duracionBateria;
        this.tamanioPantalla = tamanioPantalla;
        this.procesador = procesador;
        this.ram = ram;
        this.capacidad = capacidad;
    }

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
        System.out.println("Sistema Operativo:.....................: " + so);
        System.out.println("Duracion de la Bateria.................: " + getDuracionBateria());
        System.out.println("Tamaño pantalla:.......................: " + getTamanioPantalla());
        System.out.println("Procesador......................: " + getProcesador());
        System.out.println("Ram......................: " + getRam());
        System.out.println("Capacidad.......................: " + getCapacidad());

        /**System.out.println("Tipo de uso:...............: " + uso);
        System.out.println("==============================================");
        System.out.println("");*///Editar

    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Sistema Operativo:......................: " + getSO());
        System.out.println("Duracion de la Bateria......................: " + getDuracionBateria());
        System.out.println("Tamaño pantalla:.......................: " + getTamanioPantalla());
        System.out.println("Procesador......................: " + getProcesador());
        System.out.println("Ram......................: " + getRam());
        System.out.println("Capacidad.......................: " + getCapacidad());

    }
}
