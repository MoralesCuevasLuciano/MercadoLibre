package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;
import models.Producto;

public abstract class Juguete extends Producto {
    private int edad;
    private CategoriaJuguete categoria;
    private MaterialJuguete material;


    /**Constructores*/
    public Juguete(String nombre, String marca, String modelo, double precio, int stock, CategoriaJuguete categoria, int edad, MaterialJuguete material) {
        super(nombre, marca, modelo, precio, stock);
        this.categoria = categoria;
        this.edad = edad;
        this.material = material;
    }

    public Juguete() {
    }

    /**Getters y Setters*/
    public CategoriaJuguete getCategoria() {
        return categoria;
    }
    public Juguete categoria(CategoriaJuguete categoria) {
        this.categoria = categoria;
        return this;
    }
    public int getEdad() {
        return edad;
    }
    public Juguete edad(int edad) {
        this.edad = edad;
        return this;
    }
    public MaterialJuguete getMaterial() {
        return material;
    }
    public Juguete material(MaterialJuguete material) {
        this.material = material;
        return this;
    }



    /**Imprimir*/
    public void imprimir() {
        super.imprimir();
        System.out.println("Edad.......................: " + getEdad());
        System.out.println("Categoria..................: " + getCategoria());
        System.out.println("Material...................: " + getMaterial());
    }

    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Edad.......................: " + getEdad());
        System.out.println("Categoria..................: " + getCategoria());
        System.out.println("Material...................: " + getMaterial());
    }


    /**Equals y HashCode*/
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
