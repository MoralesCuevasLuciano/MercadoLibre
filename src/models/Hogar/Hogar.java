package models.Hogar;

import enums.CategoriasHogar;
import enums.UsoHogar;
import models.Producto;

public abstract class Hogar extends Producto {

    private CategoriasHogar categoria;
    private UsoHogar uso;
    private String material;

    /*CONSTRUCTORES*/

    public Hogar(String nombre, String marca, String modelo, double precio, int stock, float peso, CategoriasHogar categoria, UsoHogar uso, String material) {
        super(nombre, marca, modelo, precio, stock);
        this.categoria = categoria;
        this.uso = uso;
        this.material = material;
    }

    public Hogar() {
    }

    /*GETTERS AND SET BUILDERS*/

    public CategoriasHogar getCategoria() {
        return categoria;
    }

    public void categoria(CategoriasHogar categoria) {
        this.categoria = categoria;
    }

    public UsoHogar getUso() {
        return uso;
    }

    public void Uso(UsoHogar uso) {
        this.uso = uso;
    }

    public String getMaterial() {
        return material;
    }

    public void material(String material) {
        this.material = material;
    }

    /*IMPRIMIR*/

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
}