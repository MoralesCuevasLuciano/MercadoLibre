import enums.*;
import enums.UsoCalzadoPantalon;
import models.ArrayList.AdministradorList;
import models.ArrayList.CartList;
import models.ArrayList.CartMap;
import models.Hogar.Bazar;
import models.Hogar.Escritorio;
import models.Hogar.Mueble;
import models.Hogar.Sillon;
import models.Ropa.Calzado;
import models.ArrayList.CarritoList;
import models.Usuario.Cliente;
import models.Usuario.Direccion;

public class Main {
    public static void main(String[] args) {



        Bazar a = new Bazar("Bazar Multiusos", "MarcaX", "ModeloY", 49.99, 20, 1.5f, CategoriasHogar.JARDIN, UsoHogar.COMER, "Plástico", true, TamañoBazar.MEDIANO);
        Mueble i = new Mueble("Silla de Comedor", "MarcaA", "ModeloB", 1, 50, 3.0f, CategoriasHogar.JARDIN, UsoHogar.COMER, "Madera", 4, EstiloMueble.LIVING);
        Escritorio o = new Escritorio("Escritorio Ejecutivo", "MarcaC", "ModeloD", 1, 10, 30.0f, CategoriasHogar.JARDIN, UsoHogar.DECORACION, "Madera", 2, EstiloMueble.LIVING, 3, true);
        Direccion q = new Direccion();
        CarritoList t = new CarritoList();
        Sillon e = new Sillon();
        AdministradorList admin = new AdministradorList();
        Calzado zapatillas = new Calzado("Zapatillas Deportivas", "Nike", "Air Max", 1, 20, "Negro", Genero.UNISEX, TalleRemera.M, "Sintético", TipoCalzado.BORCEGO, UsoCalzadoPantalon.CASUAL);
        Cliente cliente = new Cliente("C001", "Ana Gómez", "98765432B", Genero.FEMENINO, "555-9876", q, t, 40150.75);
        cliente.imprimir();
        CartList p = new CartList();
        CartMap d = new CartMap();

        d.agregarAlCarrito(o,4);
        d.agregarAlCarrito(i,4);

        d.mostrarCarrito();

        d.comprarCarrito(cliente);
        cliente.imprimir();

        o.imprimir();
        i.imprimir();



        /**Agregar los objetos al repertorio de ventas
        admin.add(zapatillas);
        admin.edit(zapatillas, "zapatinas", "adidas", "modelo entrecasa", 20000, 5);
        zapatillas.imprimir();

        /** Agregar objeto al carrito

        ItemCarrito i1 = new ItemCarrito(zapatillas, 2); //crea un item de 2 zapatillas

        cliente.getCarrito().agregarProducto(i1); //agrega el item de 2 zapatillas
        cliente.getCarrito().mostrarCarrito();
        System.out.println("El stock es " + zapatillas.getStock());
        System.out.println(t.comprarCarrito1(cliente)); //se compran 2 zapatillas si hay saldo suf
        System.out.println("El stock es " + zapatillas.getStock());
        cliente.getCarrito().mostrarCarrito();*/

    }
}