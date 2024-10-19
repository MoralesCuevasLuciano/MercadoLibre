package models.Tecnologia;
import models.Producto;

public abstract class Tecnologia extends Producto{
    private float peso;
    private String color;
    private int anio;

    /**Constructores*/
    public Tecnologia(String nombre, String marca, String modelo, double precio, int stock, float peso, String color, int anio) {
        super(nombre, marca, modelo, precio, stock);
        this.peso = peso;
        this.color = color;
        this.anio = anio;
    }

    public Tecnologia() {
    }

    /**Getters y Setters*/

    public float getPeso() {
        return peso;
    }

    public Tecnologia peso(float peso) {
        this.peso = peso;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Tecnologia color(String color) {
        this.color = color;
        return this;
    }

    public int getAnio() {
        return anio;
    }

    public Tecnologia anio(int anio) {
        this.anio = anio;
        return this;
    }

    /**Imprimir*/
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Peso:......................: " + peso);
        System.out.println("Color......................: " + color);
        System.out.println("Año:.......................: " + anio);

    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Peso:......................: " + peso);
        System.out.println("Color......................: " + color);
        System.out.println("Año:.......................: " + anio);

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

    @Override
    public String toString() {
        return "Tecnologia{" +
                "peso=" + peso +
                ", color='" + color + '\'' +
                ", anio=" + anio +
                "} " + super.toString();
    }
}