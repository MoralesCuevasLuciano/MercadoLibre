package Menus;

import models.ArrayList.AdministradorList;
import models.Producto;
import models.Usuario.Cliente;

import java.util.Scanner;


public class Menu {
        private static int opcion;
        private static final Scanner ingreso = new Scanner(System.in);
        private AdministradorList<Producto> productos;
        private Cliente cliente;

    public Menu(AdministradorList<Producto> productos, Cliente cliente) {
        this.productos = productos;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public AdministradorList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(AdministradorList<Producto> productos) {
        this.productos = productos;
    }

    /***MENU PRINCIPAL*/
    public void menuPrincipal(){

        do{
            System.out.println("Bienvenido a MercadoLibre");
            System.out.println("1. Cliente");
            System.out.println("2. Administrador");
            System.out.println("3. Salir");
            this.opcion = ingreso.nextInt();
            switch(this.opcion) {
                case 1 -> menuCliente(this.cliente,this.productos);
                case 2 -> menuAdmin();
                case 3 -> System.out.println("Gracias por ingresar");
            }
        }while(this.opcion!=0);
    }

    /**USANDO EL PRINCIPIO DE HACER QUE LAS FUNCIONES SOLO TENGAN UNA FUNCION*/

    public int eligeUnaOpcionPrincipal(){

            System.out.println("Bienvenido a MercadoLibre");
            System.out.println("1. Cliente");
            System.out.println("2. Administrador");
            System.out.println("3. Salir");

            return ingreso.nextInt();
    }

    public void ejecutarOpcionPrincipal(int opcion){
           opcion= eligeUnaOpcionPrincipal();

           switch(opcion) {
            case 1 -> menuCliente(this.cliente,this.productos);
            case 2 -> menuAdmin();
            case 3 -> System.out.println("Gracias por ingresar");
        }

    }

    public int mostrarMenuCliente(Cliente c, AdministradorList<Producto> l){

            System.out.println("1. Ver productos");
            System.out.println("2. Ver carrito");
            System.out.println("3. Comprar");
            System.out.println("4. Buscar por Marca");
            System.out.println("5. Buscador");
            System.out.println("6. Salir");

            return ingreso.nextInt();
    }

    public void ejecutaOpcionCliente(int opcion){
        opcion = mostrarMenuCliente(this.cliente,this.productos);

        switch(opcion){
            case 1 -> this.productos.show1();
            case 2 -> this.cliente.getCarrito().mostrarCarrito();
            case 3 -> this.cliente.getCarrito().comprarCarrito(this.cliente);
            case 4 -> this.productos.showMarca(ingreso.next());
            case 6 -> System.out.println("Gracias por tu compra");
        }

    }

    /**Si es Cliente, desplegar las funciones de la clase cliente*/
    public void menuCliente(Cliente c, AdministradorList<Producto> l){

        do{
            System.out.println("1. Ver productos");
            System.out.println("2. Ver carrito");
            System.out.println("3. Comprar");
            System.out.println("4. Salir");
            this.opcion = this.ingreso.nextInt();

            switch(this.opcion){
                case 1 -> this.productos.show1();
                case 2 -> c.getCarrito().mostrarCarrito();
                case 3 -> c.getCarrito().comprarCarrito(this.cliente);
                case 4 -> System.out.println("Gracias por tu compra");
            }
        }while(this.opcion!=0);
    }

    /**Si es Administrador, desplegar las funciones de la clase administrador*/
    public void menuAdmin(){
        System.out.println("1. Agregar producto");
        System.out.println("2. Editar producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Salir");
    }

    /**SwichCase*/
    private static Scanner scanner = new Scanner(System.in);
    public void menu(){
        int opcion;
        do {
            menuPrincipal();
            opcion = scanner.nextInt();
            /**
            switch (opcion){
                case 1:
                    menuCliente();
                    break;
                case 2:
                    menuAdmin();
                    break;
                case 3:
                    System.out.println("Gracias por usar MercadoLibre");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
             **/
        }while (opcion != 3);
    }

    /**REEMPLAZAR LOS SOUTS POR LAS VERDADERAS FUNCIONES*/
    /**inicializar adminlist y carrito list para poder traer las funciones en el menu*/
    public void opcionesCliente(){
        int opcion;
        do {

            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ver productos");
                    break;
                case 2:
                    System.out.println("Ver carrito");
                    break;
                case 3:
                    System.out.println("Comprar");
                    break;
                case 4:
                    System.out.println("Gracias por usar MercadoLibre");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion != 4);
    }

    /**REEMPLAZAR LOS SOUTS POR LAS VERDADERAS FUNCIONES*/
    /**inicializar adminlist y carrito list para poder traer las funciones en el menu*/
    public void opcionesAdmin(){
        int opcion;
        do {
            menuAdmin();
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Agregar producto");
                    break;
                case 2:
                    System.out.println("Editar producto");
                    break;
                case 3:
                    System.out.println("Eliminar producto");
                    break;
                case 4:
                    System.out.println("Gracias por usar MercadoLibre");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion != 4);
    }




}
