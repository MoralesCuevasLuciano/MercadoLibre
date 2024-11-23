package models.Herramienta;

import enums.MaterialInsumo;
import mocks.Mock;
import models.Producto;

import java.util.Random;

public class Insumo extends Herramienta {

    private MaterialInsumo tipoDeMaterial;
    private float largo;
    private float ancho;
    private float diametro;


    public Insumo(String nombre, String cdp, int stock, double precio, String marca, String modelo, MaterialInsumo tipoDeMaterial, float largo, float ancho, float diametro) {
        super(nombre, cdp, stock, precio, marca, modelo);
        this.tipoDeMaterial = tipoDeMaterial;
        this.largo = largo;
        this.ancho = ancho;
        this.diametro = diametro;
    }

    public Insumo() {
    }

    /**Getters y Setters*/
    public MaterialInsumo getTipoDeMaterial() {
        return tipoDeMaterial;
    }
    public Insumo tipoDeMaterial(MaterialInsumo tipoDeMaterial) {
        this.tipoDeMaterial = tipoDeMaterial;
        return this;
    }
    public float getLargo() {
        return largo;
    }
    public Insumo largo(float largo) {
        this.largo = largo;
        return this;
    }
    public float getDiametro() {
        return diametro;
    }
    public Insumo diametro(float diametro) {
        this.diametro = diametro;
        return this;
    }
    public float getAncho() {
        return ancho;
    }
    public Insumo ancho(float ancho) {
        this.ancho = ancho;
        return this;
    }



    /**Imprimir*/
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Largo:....................."+ getLargo());
        System.out.println("Ancho:....................." + getAncho());
        System.out.println("==============================================");
    }
    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Largo:....................." + getLargo());
        System.out.println("Ancho:....................." + getAncho());
        System.out.println("==============================================");
    }


    @Override
    public String toString() {
        return super.toString() +
                "\nTipo Material:..................: " + tipoDeMaterial +
                "\nLargo:..........................: " + largo +
                "\nAncho:..........................: " + ancho +
                "\nDiametro:.......................: " + diametro +
                "\n==============================================\n\n";
    }


    /**Equals y HashCode*/
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }


    public static Insumo insumoRandom() {
        Insumo insumo = (Insumo) new Insumo()
                .ancho((float) Math.random() * 100)
                .largo((float)Math.random() * 100)
                .diametro((float) Math.random() * 100)
                .tipoDeMaterial(MaterialInsumo.values()[(int) (Math.random() * (MaterialInsumo.values().length))])
                .stock(Mock.getStock())
                .precio(Mock.getPrecio())
                .nombre(Mock.getNombreInsumos())
                .marca(Mock.getMarcaInsumos())
                .modelo(Mock.getModeloHerramientas());
        return insumo;
    }

}
