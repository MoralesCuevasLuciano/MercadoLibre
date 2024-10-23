import enums.*;
import enums.UsoCalzadoPantalon;
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

        Bazar a = new Bazar(
                "Bazar Multiusos",
                "MarcaX",
                "ModeloY",
                49.99,
                20,
                1.5f,
                CategoriasHogar.JARDIN,
                UsoHogar.COMER,
                "Plástico",
                true,
                TamañoBazar.MEDIANO
        );

        // Crear un objeto Mueble
        Mueble i = new Mueble(
                "Silla de Comedor",
                "MarcaA",
                "ModeloB",
                1,
                50,
                3.0f,
                CategoriasHogar.JARDIN,
                UsoHogar.COMER,
                "Madera",
                4,
                EstiloMueble.LIVING
        );

        // Crear un objeto Escritorio
        Escritorio o = new Escritorio(
                "Escritorio Ejecutivo",
                "MarcaC",
                "ModeloD",
                1,
                10,
                30.0f,
                CategoriasHogar.JARDIN,
                UsoHogar.DECORACION,
                "Madera",
                2,
                EstiloMueble.LIVING,
                3,
                true
        );
        Direccion q = new Direccion();
        CarritoList t = new CarritoList();
        Sillon e = new Sillon();


        Calzado zapatillas = new Calzado(
                "Zapatillas Deportivas",  // nombre
                "Nike",                   // marca
                "Air Max",                // modelo
                1,                   // precio
                20,                       // stock
                "Negro",                  // color
                Genero.UNISEX,            // genero
                TalleRemera.M,      // talle
                "Sintético",              // material
                TipoCalzado.BORCEGO,    // tipo
                UsoCalzadoPantalon.CASUAL // uso
        );

        Cliente cliente = new Cliente(
                "C001",
                "Ana Gómez",
                "98765432B",
                Genero.FEMENINO,
                "555-9876",
                q,
                t,
                150.75
        );

        cliente.imprimir();

        t.mostrarCarrito();
        System.out.println(t.comprarCarrito1(cliente));
        cliente.imprimir();
        t.mostrarCarrito();

    }
}