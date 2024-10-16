package models.Herramienta;

import enums.MaterialInsumo;
import models.Producto;

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
        return "Insumo{" +
                "tipoDeMaterial=" + tipoDeMaterial +
                ", largo=" + largo +
                ", ancho=" + ancho +
                ", diametro=" + diametro +
                '}';
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


}
