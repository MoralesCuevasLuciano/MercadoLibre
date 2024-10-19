package models.Usuario;

import enums.Genero;

public class Cliente extends Persona{

    private double saldo;
    private Carrito carrito;
    private HistorialCompras historialCompras;

    /**Constructores*/

    public Cliente(String id, String nombre, String dni, Genero sexo, String telefono, Direccion direccion, Carrito carrito, double saldo) {
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

    public Carrito getCarrito() {
        return carrito;
    }

    public Cliente carrito(Carrito carrito) {
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
