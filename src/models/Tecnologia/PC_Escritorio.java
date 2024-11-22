package models.Tecnologia;

import enums.SOComputadora;
import static mocks.Mock.*;
import static mocks.Mock.getNombreProcesadorPc;
import static mocks.Mock.random;

public class PC_Escritorio extends Computadora {
    private float fuente;


    public PC_Escritorio(String nombre, String cdp, int stock, double precio, String marca, String modelo, float peso, String color, int anio, SOComputadora so, String procesador, int ram, int capacidad, String gabinete, float fuente) {
        super(nombre, cdp, stock, precio, marca, modelo, peso, color, anio, so, procesador, ram, capacidad);
        this.fuente = fuente;
    }

    /**Constructores*/


    public PC_Escritorio() {
    }



    /**Getters y Setters*/

    public float getFuente() {
        return fuente;
    }
    public PC_Escritorio fuente(float fuente) {
        this.fuente = fuente;
        return this;
    }



    /**Imprimir*/
    public void imprimir() {
        super.imprimir();
        System.out.println("Fuente.....................: " + fuente);
        System.out.println("==============================================");
        System.out.println("");

    }

    @Override
    public void imprimirCliente() {
        super.imprimir();
        System.out.println("Fuente.....................: " + fuente);
        System.out.println("==============================================");
        System.out.println("");

    }

    @Override
    public String toString() {
        return "Escritorio{" +
                ", fuente=" + fuente +
                '}';
    }

    public static PC_Escritorio PC_EscritorioRandom(){
        PC_Escritorio pc = (PC_Escritorio) new PC_Escritorio();
        pc.fuente = (float) (Math.random() * 800);
        pc.so(SOComputadora.values()[(int) Math.random() * SOComputadora.values().length]);
        pc.procesador(getNombreProcesadorPc());
        pc.ram((int) (Math.random() * 32));
        pc.capacidad((int) (Math.random() * 2000));
        pc.anio((int) (Math.random() * (2024-2018 + 1) + 2018));
        pc.color(getColores());
        pc.peso((float) (Math.random() * 100));
        pc.marca(getMarcaTecnologia());
        pc.modelo(getModeloComputadoras());
        pc.nombre(pc.getMarca() + " " + pc.getModelo());
        pc.precio((Math.random() * 2000000));
        pc.stock((int) (Math.random() * 100));
        return pc;
    }
}
