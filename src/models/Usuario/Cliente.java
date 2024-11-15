package models.Usuario;

import enums.Genero;
import models.ArrayList.CarritoList;
import models.ArrayList.CartMap;
import models.Producto;

public class Cliente extends Persona{

    private double saldo;
    private CartMap carrito;
    private HistorialCompras historialCompras;

    /**Constructores*/

    public Cliente(String nombre, String dni, Genero sexo, String telefono, Direccion direccion, double saldo) {
        super(nombre, dni, sexo, telefono, direccion);
        this.carrito = new CartMap<>();
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
