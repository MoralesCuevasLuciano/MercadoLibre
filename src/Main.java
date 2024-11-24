import Menus.*;
import models.ArrayList.AdministradorList;
import models.Producto;
import models.Usuario.Cliente;
import models.Usuario.ClientesList;

import javax.swing.*;
import java.util.Scanner;

import static json.JsonClientes.serializarClientes;
import static json.JsonProductos.deserializarProductos;
import static json.JsonProductos.serializarProductos;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int opcion;
    public static void main(String[] args) {

        ClientesList<Cliente> clientes = new ClientesList<>();
        clientes.cargarClientesRandom(10);
        serializarClientes(clientes);
        // Inicializar el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            AdministradorList<Producto> productos = deserializarProductos();
            Cliente cliente = Cliente.clienteRandom();
            MenuPpal menuPpal = new MenuPpal(productos, cliente);

            cliente.imprimirCliente();



        });
    }

}