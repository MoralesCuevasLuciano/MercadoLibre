package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;
import models.Producto;

public abstract class Juguete extends Producto {
    private int edad;
    private CategoriaJuguete categoria;
    private MaterialJuguete material;

    public Juguete(String nombre, String marca, String modelo, double precio, int stock, CategoriaJuguete categoria, int edad, MaterialJuguete material) {
        super(nombre, marca, modelo, precio, stock);
        this.categoria = categoria;
        this.edad = edad;
        this.material = material;
    }

    public CategoriaJuguete getCategoria() {
        return categoria;
    }

    public Juguete Categoria(CategoriaJuguete categoria) {
        this.categoria = categoria;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Juguete Edad(int edad) {
        this.edad = edad;
        return this;
    }

    public MaterialJuguete getMaterial() {
        return material;
    }

    public Juguete Material(MaterialJuguete material) {
        this.material = material;
        return this;
    }

    @Override
    public void imprimir() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Marca " + getMarca());
        System.out.println("Modelo " + getModelo());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Stock: " + getStock());
        System.out.println("Edad: " + getEdad());
        System.out.println("Categoria " + getCategoria());
        System.out.println("Material: " + getMaterial());

    }

    @Override
    public void imprimirCliente() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Marca " + getMarca());
        System.out.println("Modelo " + getModelo());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Edad: " + getEdad());
        System.out.println("Categoria " + getCategoria());
        System.out.println("Material: " + getMaterial());
    }
}
