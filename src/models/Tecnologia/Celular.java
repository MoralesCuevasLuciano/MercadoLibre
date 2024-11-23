package models.Tecnologia;

import enums.SOCelular;

import static mocks.Mock.*;

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
        return super.toString() +
                "\nSistema operativo:..............: " + so+
                "\nDuracion Bateria:...............: " + duracionBateria +
                "\nTamanio pantalla:...............: " + tamanioPantalla +
                "\nProcesador:.....................: " + procesador +
                "\nRam:............................: " + ram +
                "\nCapacidad:......................: " + capacidad +
                "\n==============================================\n\n";
    }

    public static Celular celularRandom(){
        Celular celular = (Celular) new Celular();
        celular.so = SOCelular.values()[(int) (Math.random() * SOCelular.values().length)];
        celular.duracionBateria = (int) (Math.random() * 600);
        celular.tamanioPantalla = (float) (Math.random() * 10);
        celular.procesador(getNombreProcesadorAndroid());
        celular.ram = (int) (Math.random() * 8);
        celular.capacidad = (int) (Math.random() * 256);
        celular.peso((float) (Math.random() * 200));
        celular.color(getColores());
        celular.anio((int) (Math.random() * (2024-2018 + 1) + 2018));
        celular.marca(getMarcaTecnologia());
        celular.modelo(getModeloCelulares());
        celular.nombre(celular.getMarca() + " " + celular.getModelo());
        celular.precio(random.nextDouble() * 1000000);
        celular.stock((int) (Math.random() * 100));
        return celular;
    }
}
