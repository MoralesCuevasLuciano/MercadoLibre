package models.Hogar;

import enums.CategoriasHogar;
import enums.UsoHogar;
import models.Producto;

import java.util.Random;

public abstract class Hogar extends Producto {

    private CategoriasHogar categoria;
    private UsoHogar uso;
    private String material;


    /**CONSTRUCTORES*/

    public Hogar() {
    }

    public Hogar(String nombre, String cdp, int stock, double precio, String marca, String modelo, CategoriasHogar categoria, UsoHogar uso, String material) {
        super(nombre, cdp, stock, precio, marca, modelo);
        this.categoria = categoria;
        this.uso = uso;
        this.material = material;
    }

    /**Getters y Setters*/
    public CategoriasHogar getCategoria() {
        return categoria;
    }
    public void categoria(CategoriasHogar categoria) {
        this.categoria = categoria;
    }
    public UsoHogar getUso() {
        return uso;
    }
    public void uso(UsoHogar uso) {
        this.uso = uso;
    }
    public String getMaterial() {
        return material;
    }
    public void material(String material) {
        this.material = material;
    }



    /**IMPRIMIR*/
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Categoria:.................: " + getCategoria());
        System.out.println("Uso:.......................: " + getUso());


    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Categoria:.................: " + getCategoria());
        System.out.println("Uso:.......................: " + getUso());

    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCategoria:......................: " + categoria +
                "\nUso:............................: " + uso +
                "\nMaterial:.......................: " + material +
                "\n==============================================\n\n";
    }
}