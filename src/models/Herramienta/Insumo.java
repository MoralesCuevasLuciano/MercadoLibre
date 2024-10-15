package models.Herramienta;

import enums.MaterialInsumo;

public class Insumo extends Herramienta {

    private MaterialInsumo tipoDeMaterial;
    private float largo;
    private float ancho;
    private float diametro;


    public Insumo(String nombre, String marca, String modelo, double precio, int stock, float ancho, float diametro, float largo, MaterialInsumo tipoDeMaterial) {
        super(nombre, marca, modelo, precio, stock);
        this.ancho = ancho;
        this.diametro = diametro;
        this.largo = largo;
        this.tipoDeMaterial = tipoDeMaterial;
    }

    public MaterialInsumo getTipoDeMaterial() {
        return tipoDeMaterial;
    }

    public Insumo TipoDeMaterial(MaterialInsumo tipoDeMaterial) {
        this.tipoDeMaterial = tipoDeMaterial;
        return this;
    }

    public float getLargo() {
        return largo;
    }

    public Insumo Largo(float largo) {
        this.largo = largo;
        return this;
    }

    public float getDiametro() {
        return diametro;
    }

    public Insumo Diametro(float diametro) {
        this.diametro = diametro;
        return this;
    }

    public float getAncho() {
        return ancho;
    }

    public Insumo Ancho(float ancho) {
        this.ancho = ancho;
        return this;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Largo" + getLargo());
        System.out.println("Ancho" + getAncho());
        System.out.println("------------------------------------");
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Largo" + getLargo());
        System.out.println("Ancho" + getAncho());
        System.out.println("------------------------------------");
    }
}
