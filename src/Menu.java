import java.util.Scanner;

public class Menu {

    /***MENU PRINCIPAL*/
    public void menuPrincipal(){
        System.out.println("Bienvenido a MercadoLibre");
        System.out.println("1. Cliente");
        System.out.println("2. Administrador");
        System.out.println("3. Salir");
    }

    /**Si es Cliente, desplegar las funciones de la clase cliente*/
    public void menuCliente(){
        System.out.println("1. Ver productos");
        System.out.println("2. Ver carrito");
        System.out.println("3. Comprar");
        System.out.println("4. Salir");
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
        }while (opcion != 3);
    }

    /**REEMPLAZAR LOS SOUTS POR LAS VERDADERAS FUNCIONES*/
    /**inicializar adminlist y carrito list para poder traer las funciones en el menu*/
    public void opcionesCliente(){
        int opcion;
        do {
            menuCliente();
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
