package models.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

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
import static models.Usuario.Cliente.clienteRandom;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ClientesList <T extends Cliente>{
    List<T> clientesList;

    /**Constructores*/
    public ClientesList(){
        this.clientesList = new ArrayList<>();
    }

    public void get(int i){
        this.clientesList.get(i);
    }

    public List<T> getClientes() {
        return this.clientesList;
    }

    /**Agregar cliente*/
    public void add(T c){
        clientesList.add(c);
    }

    /**Eliminar cliente*/
    public void remove(T c){
        clientesList.remove(c);
    }

    public int size(){
        return this.clientesList.size();
    }

    public void showAllClients(){
        for(Cliente c : clientesList){
            c.imprimir();
        }
    }

    /**Muestra cliente segun nombre y apellido*/

    public void mostrarClientePorNombre(String nombre, String apellido){
        for(Cliente cliente : clientesList){
            if(cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellido)){
                System.out.println(cliente);
            }
        }
    }


    public Cliente buscarClientePorNombre(String nombre, String apellido) {
        for(Cliente cliente : clientesList){
            if(cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellido)){
                return cliente;
            }
        }
        return null;
    }


    /**Editar los atributos de un cliente y que se guarde el nuevo producto*/
    public void edit(Cliente c, String nombre, String apellido, String dni, Double saldo, String telefono, String calle, String numero){
        c.nombre(nombre);
        c.apellido(apellido);
        c.dni(dni);
        c.saldo(saldo);
        c.telefono(telefono);
        Direccion direccion = new Direccion();
        direccion.calle(calle);
        direccion.numero(numero);
        c.direccion(direccion);
    }

    public void cargarClientesRandom(int cantidad) {
        for (int i = 1; i <= cantidad; i++) {
            clientesList.add((T)clienteRandom());
        }
    }

}
