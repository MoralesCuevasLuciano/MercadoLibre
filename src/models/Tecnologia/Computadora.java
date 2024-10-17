package models.Tecnologia;

import enums.SOComputadora;

public class Computadora extends Tecnologia{
    private SOComputadora SO;

    private String procesador;

    private int ram;
    private int capacidad;

    /**Constructores*/

    public Computadora(String nombre, String marca, String modelo, double precio, int stock, float peso, String color, int anio, SOComputadora SO, String procesador, int ram, int capacidad) {
        super(nombre, marca, modelo, precio, stock, peso, color, anio);
        this.SO = SO;
        this.procesador = procesador;
        this.ram = ram;
        this.capacidad = capacidad;
    }

    public Computadora() {
    }

    /**Getters y Setters*/

    public SOComputadora getSO() {
        return SO;
    }

    public Computadora SO(SOComputadora SO) {
        this.SO = SO;
        return this;
    }

    public String getProcesador() {
        return procesador;
    }

    public Computadora procesador(String procesador) {
        this.procesador = procesador;
        return this;
    }

    public int getRam() {
        return ram;
    }

    public Computadora ram(int ram) {
        this.ram = ram;
        return this;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Computadora capacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    /**Imprimir*/

    public void imprimir() {
        super.imprimir();
        System.out.println("Sistema Operativo:......................: " + getSO());
        System.out.println("Procesador......................: " + getProcesador());
        System.out.println("RAM.......................: " + getRam());
        System.out.println("Capacidad......................: " + getCapacidad());


    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Sistema Operativo:......................: " + getSO());
        System.out.println("Procesador......................: " + getProcesador());
        System.out.println("RAM.......................: " + getRam());
        System.out.println("Capacidad......................: " + getCapacidad());

    }
}
