import com.fasterxml.jackson.databind.ObjectMapper;
import enums.*;
import enums.UsoCalzadoPantalon;
import models.ArrayList.AdministradorList;
import models.ArrayList.CartList;
import models.ArrayList.CartMap;
import models.Excepciones.NoHayStock;
import models.Herramienta.HerramientaElectrica;
import models.Hogar.Bazar;
import models.Hogar.Escritorio;
import models.Hogar.Mueble;
import models.Hogar.Sillon;
import models.Producto;
import models.Ropa.Calzado;
import models.ArrayList.CarritoList;
import models.Usuario.Cliente;
import models.Usuario.Direccion;
import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static json.JsonCliente.deserializarCliente;
import static json.JsonCliente.serializarCliente;
import static json.JsonProductos.deserializarProductos;
import static json.JsonProductos.serializarProductos;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int opcion;
    public static void main(String[] args) {
            AdministradorList<Producto> t = new AdministradorList<>();
            Direccion s = new Direccion();
            Cliente r = new Cliente("Richard","w323232",Genero.MASCULINO,"23232323", "Calle luro 2",3000000);
            Menu a = new Menu(t,r);

        HerramientaElectrica taladro = new HerramientaElectrica("Taladro", "CDP001", 10, 1500.0, "Bosch", "X200", 18.0f, true);
        HerramientaElectrica sierraCircular = new HerramientaElectrica("Sierra Circular", "CDP002", 5, 3200.0, "Makita", "CS600", 20.0f, false);
        HerramientaElectrica amoladora = new HerramientaElectrica("Amoladora", "CDP003", 7, 2100.0, "DeWalt", "DWE402", 12.0f, true);
        HerramientaElectrica destornillador = new HerramientaElectrica("Destornillador Eléctrico", "CDP004", 15, 850.0, "Black & Decker", "BDX01", 4.8f, true);
        HerramientaElectrica lijadora = new HerramientaElectrica("Lijadora Orbital", "CDP005", 12, 1800.0, "Ryobi", "RS300", 6.0f, false);

        t.add(taladro);
        t.add(sierraCircular);
        t.add(amoladora);
        t.add(lijadora);
        t.add(destornillador);

        /*serializarProductos(t);
        AdministradorList<Producto> productos = deserializarProductos();
        productos.show1();*/

        serializarCliente(r);
        Cliente c1 = deserializarCliente();
        c1.imprimirCliente();
    }

}