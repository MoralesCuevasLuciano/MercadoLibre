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


    /** Comprar carrito*/

    public String comprarCarrito() {
        if (carrito.precioCarrito() < this.saldo) {
            //historialCompras.add(carrito);
            carrito.comprarCarrito();
            return "Compra exitosa!";
        }else {
            return "Error, saldo insuficiente";
        }
    }

    /**IMPRIMIR*/

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Saldo:.....................: " + saldo);
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Saldo:.....................: " + saldo);
    }
}
