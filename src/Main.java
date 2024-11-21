import Menus.*;
import enums.*;
import models.ArrayList.AdministradorList;
import models.Excepciones.NoHayStock;
import models.Herramienta.HerramientaElectrica;
import models.Producto;
import models.Ropa.Remera;
import models.Usuario.Cliente;
import models.Usuario.Direccion;

import javax.swing.*;
import java.util.Scanner;

import static json.JsonCliente.deserializarCliente;
import static json.JsonCliente.serializarCliente;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int opcion;
    public static void main(String[] args) {

        // Inicializar el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            AdministradorList<Producto> t = new AdministradorList<>();
            //Direccion s = new Direccion();
            Cliente r = new Cliente("Richard", "w323232", Genero.MASCULINO, "23232323", "s", 3000000);


            HerramientaElectrica taladro = new HerramientaElectrica("Taladro", "CDP001", 10, 1500.0, "Bosch", "X200", 18.0f, true);
            HerramientaElectrica sierraCircular = new HerramientaElectrica("Sierra Circular", "CDP002", 5, 3200.0, "Makita", "CS600", 20.0f, false);
            HerramientaElectrica amoladora = new HerramientaElectrica("Amoladora", "CDP003", 7, 2100.0, "DeWalt", "DWE402", 12.0f, true);
            HerramientaElectrica destornillador = new HerramientaElectrica("Destornillador Eléctrico", "CDP004", 15, 850.0, "Black & Decker", "BDX01", 4.8f, true);
            HerramientaElectrica lijadora = new HerramientaElectrica("Lijadora Orbital", "CDP005", 12, 1800.0, "Ryobi", "RS300", 6.0f, false);
            Remera e = new Remera("asda", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera d = new Remera("asda", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera n = new Remera("asda", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera b = new Remera("asda", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera u = new Remera("asda", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera q = new Remera("asda", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);

            t.add(sierraCircular);
            t.add(amoladora);
            t.add(lijadora);
            t.add(destornillador);
            t.add(e);
            t.add(d);
            t.add(n);
            t.add(b);
            t.add(u);
            t.add(q);

            //MenuCliente2 j = new MenuCliente2(t,r);
            MenuPpal menuPpal = new MenuPpal(t, r);

            e.imprimirCliente();


            System.out.println("La opcion es " + menuPpal.getOpcion());

            //menuPpal.mostrar();
            //j.mostrar();

        });
    }

}