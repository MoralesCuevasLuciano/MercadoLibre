package models.Tecnologia;

import enums.SOComputadora;

public abstract class Computadora extends Tecnologia{
    private SOComputadora so;
    private String procesador;
    private int ram;
    private int capacidad;


    public Computadora(String nombre, String cdp, int stock, double precio, String marca, String modelo, float peso, String color, int anio, SOComputadora so, String procesador, int ram, int capacidad) {
        super(nombre, cdp, stock, precio, marca, modelo, peso, color, anio);
        this.so = so;
        this.procesador = procesador;
        this.ram = ram;
        this.capacidad = capacidad;
    }

    /**Constructores*/


    public Computadora() {
    }


    /**Getters y Setters*/
    public SOComputadora getSO() {
        return so;
    }
    public Computadora so(SOComputadora so) {
        this.so = so;
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
        System.out.println("Sistema Operativo:.........: " + so);
        System.out.println("Procesador.................: " + procesador);
        System.out.println("RAM........................: " + ram);
        System.out.println("Capacidad..................: " + capacidad);
        System.out.println("==============================================");
        System.out.println("");



    }
    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Sistema Operativo:.........: " + so);
        System.out.println("Procesador.................: " + procesador);
        System.out.println("RAM........................: " + ram);
        System.out.println("Capacidad..................: " + capacidad);
        System.out.println("==============================================");
        System.out.println("");
    }


    @Override
    public String toString() {
        return super.toString() +
                "\nSistema operativo:..............: " + so +
                "\nProcesador:.....................: " + procesador +
                "\nRam:............................: " + ram +
                "\nCapacidad:......................: " + capacidad +
                "\n==============================================\n\n";
    }
}
