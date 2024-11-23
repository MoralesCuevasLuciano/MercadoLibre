package models.Usuario;

import enums.Genero;
import models.ArrayList.CartMap;
import models.HistorialCompras;

public class Cliente extends Persona {

    private double saldo;
    private CartMap carrito;
    private HistorialCompras historialCompras; // Asegúrate de tener esta clase

    /** Constructores */

    public Cliente(String nombre, String dni, Genero sexo, String telefono, String direccion, double saldo) {
        super(nombre, dni, sexo, telefono, direccion);
        this.carrito = new CartMap();
        this.saldo = saldo;
        this.historialCompras = new HistorialCompras(); // Aquí inicializas el historial de compras
    }

    public Cliente() {
        super();
        this.carrito = new CartMap();
        this.saldo = saldo;
        this.historialCompras = new HistorialCompras(); // También debes inicializarlo aquí
    }

    /** GETTERS AND SETTERS */
    public double getSaldo() {
        return saldo;
    }

    public Cliente saldo(double saldo) {
        this.saldo = saldo;
        return this;
    }



    public HistorialCompras getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(HistorialCompras historialCompras) {
        this.historialCompras = historialCompras;
    }

    public CartMap getCarrito() {
        return carrito;
    }

    public void setCarrito(CartMap carrito) {
        this.carrito = carrito;
    }

    /** IMPRIMIR */
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Saldo:.....................: " + saldo);
        System.out.println("");
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Saldo:.....................: " + saldo);
        System.out.println("");
    }
}


