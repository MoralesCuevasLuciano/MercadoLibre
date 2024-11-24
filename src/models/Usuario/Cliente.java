package models.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.Genero;
import enums.TalleRemera;
import models.ArrayList.CartMap;
import models.HistorialCompras;
import models.Ropa.Buzo;

import static mocks.MockCliente.*;
import static models.Herramienta.HerramientaElectrica.herramientaElectricaRandom;
import static models.Herramienta.HerramientaManual.herramientaManualRandom;
import static models.Herramienta.Insumo.insumoRandom;
import static models.Hogar.Bazar.bazarRandom;
import static models.Hogar.Escritorio.escritorioRandom;
import static models.Hogar.Sillon.sillonRandom;
import static models.Juguete.JuegoDeMesa.juegoDeMesaRandom;
import static models.Juguete.JugueteElectrico.jugueteElectricoRandom;
import static models.Juguete.JugueteManual.jugueteManualRandom;
import static models.Ropa.Buzo.buzoRandom;
import static models.Ropa.Calzado.calzadoRandom;
import static models.Ropa.Pantalon.pantalonRandom;
import static models.Ropa.Remera.remeraRandom;
import static models.Tecnologia.Celular.celularRandom;
import static models.Tecnologia.PC_Escritorio.PC_EscritorioRandom;
import static models.Tecnologia.Portatil.portatilRandom;
import static models.Tecnologia.Televisor.televisorRandom;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar campos desconocidos
public class Cliente extends Persona {

    private double saldo;
    @JsonIgnore
    private CartMap carrito;
    private HistorialCompras historialCompras; // Asegúrate de tener esta clase

    /** Constructores */

    public Cliente(String nombre,String apellido, String dni, Character sexo, String telefono, Direccion direccion, double saldo) {
        super(nombre,apellido, dni, sexo, telefono, direccion);
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


