package models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS, // Usa la clase completa como identificador
        include = JsonTypeInfo.As.PROPERTY, // Se agrega como propiedad del JSON
        property = "@class" // Nombre de la propiedad que contendrá el tipo
)

public abstract class Producto implements Comparable<Producto> {
    private String id;
    private String cdp; //CODIGO DE PRODUCTO
    private String nombre;
    private int stock;
    private double precio;
    private String marca;
    private String modelo;


    /**Constructores*/

    public Producto(String nombre,String cdp, int stock, double precio, String marca, String modelo) {
        this.id = UUID.randomUUID().toString();
        this.cdp = cdp;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Producto(String nombre,String cdp, int stock, double precio, String marca, String modelo, String id) {
        this.id = id;
        this.cdp = cdp;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Producto() {
        this.id = UUID.randomUUID().toString();
    }

    /**Metodos*/

    public void addStock (int cantidad){
        this.stock += cantidad;
    }

    public void sellStock (int cantidad){
        this.stock -= cantidad;
    }


    /**Getters y Setters*/
    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public Producto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Producto stock(int stock) {
        this.stock = stock;
        return this;
    }

    public Producto precio(double precio) {
        this.precio = precio;
        return this;
    }

    public Producto marca(String marca) {
        this.marca = marca;
        return this;
    }

    public Producto modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public String getCdp() {
        return cdp;
    }

    public void cdp(String cdp) {
        this.cdp = cdp;
    }

    /**Imprimir*/
    public void imprimir() {
        System.out.println("ID:........................: " + getId());
        System.out.println("Nombre:....................: " + getNombre());
        System.out.println("Marca:.....................: " + getMarca());
        System.out.println("Modelo:....................: " + getModelo());
        System.out.println("Precio:....................: " + getPrecio());
        System.out.println("Stock:.....................: " + getStock());

    }


    /**IMPRIMIR SIN ID YA QUE SON DATOS NO NECESARIOS PARA LOS CLIENTES*/
    public void imprimirCliente() {
        System.out.println("Nombre:....................: " + getNombre());
        System.out.println("Marca:.....................: " + getMarca());
        System.out.println("Modelo:....................: " + getModelo());
        System.out.println("Precio:....................: " + getPrecio());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }


    /**Equals y HashCode*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return stock == producto.stock && Double.compare(precio, producto.precio) == 0 && Objects.equals(id, producto.id) && Objects.equals(nombre, producto.nombre) && Objects.equals(marca, producto.marca) && Objects.equals(modelo, producto.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, stock, precio, marca, modelo);
    }

    @Override
    public int compareTo(Producto o) {
        return Double.compare(this.precio,o.precio);
    }
}
