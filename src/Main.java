import enums.*;
import enums.UsoCalzadoPantalon;
import models.Hogar.Bazar;
import models.Hogar.Escritorio;
import models.Hogar.Mueble;
import models.Hogar.Sillon;
import models.Ropa.Calzado;

public class Main {
    public static void main(String[] args) {

        Escritorio a = new Escritorio();
        Sillon e = new Sillon();
        Mueble i = new Mueble();
        Bazar o = new Bazar();
        Calzado zapatillas = new Calzado(
                "Zapatillas Deportivas",  // nombre
                "Nike",                   // marca
                "Air Max",                // modelo
                150.99,                   // precio
                20,                       // stock
                "Negro",                  // color
                Genero.UNISEX,            // genero
                TalleRemera.M,      // talle
                "Sintético",              // material
                TipoCalzado.BORCEGO,    // tipo
                UsoCalzadoPantalon.CASUAL // uso
        );
        zapatillas.imprimir();
        a.imprimir();
        e.imprimir();
        i.imprimir();

    }
}