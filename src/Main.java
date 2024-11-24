import Menus.*;
import enums.*;
import models.ArrayList.AdministradorList;
import models.Excepciones.NoHayStock;
import models.Herramienta.HerramientaElectrica;
import models.Herramienta.HerramientaManual;
import models.Herramienta.Insumo;
import models.Hogar.Bazar;
import models.Hogar.Escritorio;
import models.Hogar.Mueble;
import models.Hogar.Sillon;
import models.Juguete.JuegoDeMesa;
import models.Juguete.JugueteElectrico;
import models.Juguete.JugueteManual;
import models.Producto;
import models.Ropa.Buzo;
import models.Ropa.Calzado;
import models.Ropa.Pantalon;
import models.Ropa.Remera;
import models.Tecnologia.*;
import models.Usuario.Cliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

import static json.JsonCliente.deserializarCliente;
import static json.JsonCliente.serializarCliente;

import static json.JsonProductos.serializarProductos;
import static json.JsonProductos.deserializarProductos;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int opcion;
    public static void main(String[] args) {

        // Inicializar el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            AdministradorList<Producto> productos = new AdministradorList<>();
            productos = deserializarProductos();
            Cliente cliente = Cliente.clienteRandom();
            MenuPpal menuPpal = new MenuPpal(productos, cliente);

            cliente.imprimirCliente();



        });
    }

}