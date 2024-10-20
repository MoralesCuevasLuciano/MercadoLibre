package models.Usuario;

import enums.Genero;
import models.ArrayList.CarritoList;

public class Cliente extends Persona{

    private double saldo;
    private CarritoList carrito;
    private HistorialCompras historialCompras;

    /**Constructores*/

    public Cliente(String id, String nombre, String dni, Genero sexo, String telefono, Direccion direccion, CarritoList carrito, double saldo) {
        super(id, nombre, dni, sexo, telefono, direccion);
        this.carrito = carrito;
        this.saldo = saldo;
    }

    public Cliente() {
    }

    /**GETTERS AND SETTERS*/
    public double getSaldo() {
        return saldo;
    }

    public Cliente saldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public CarritoList getCarrito() {
        return carrito;
    }

    public Cliente carrito(CarritoList carrito) {
        this.carrito = carrito;
        return this;
    }


    /**IMPRIMIR*/

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
