package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;
import models.Producto;

public abstract class Juguete extends Producto {
    private int edad;
    private CategoriaJuguete categoria;
    private MaterialJuguete material;


    public Juguete(String nombre, String cdp, int stock, double precio, String marca, String modelo, int edad, CategoriaJuguete categoria, MaterialJuguete material) {
        super(nombre, cdp, stock, precio, marca, modelo);
        this.edad = edad;
        this.categoria = categoria;
        this.material = material;
    }

    /**Constructores*/


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


    @Override
    public String toString() {
        return super.toString() +
                "\nEdad:...........................: " + edad +
                "\nCategoria:......................: " + categoria +
                "\nMaterial:.......................: " + material +
                "\n==============================================\n\n";
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
