package models.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.ArrayList.CartMap;
import models.HistorialCompras;


import static mocks.MockCliente.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente extends Persona {

    private double saldo;
    @JsonIgnore
    private CartMap carrito;
    private HistorialCompras historialCompras;

    /** Constructores */

    public Cliente(String nombre,String apellido, String dni, Character sexo, String telefono, Direccion direccion, double saldo) {
        super(nombre,apellido, dni, sexo, telefono, direccion);
        this.carrito = new CartMap();
        this.saldo = saldo;
        this.historialCompras = new HistorialCompras();
    }

    public Cliente() {
        super();
        this.carrito = new CartMap();
        this.saldo = saldo;
        this.historialCompras = new HistorialCompras();
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


    public static Cliente clienteRandom(){
        Cliente cliente = (Cliente) new Cliente();
        cliente.nombre(getNombreClientes());
        cliente.apellido(getApellidoCliente());
        cliente.dni(getNumeroDocumento());
        cliente.sexo(getSexoRandom());
        cliente.telefono(getTelefonoRandom());
        Direccion direccion = (Direccion)new Direccion();
        cliente.direccion(direccion);
        return cliente;
    }

    public String getNameClient(){
        String nombre = getNombre();
        return nombre;
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

    @Override
    public String toString() {
        return super.toString() +
                "\nSaldo...........................: $" + saldo +
                "\n==============================================\n\n";
    }
}


