package models.Hogar;

import enums.CategoriasHogar;
import enums.EstiloMueble;
import enums.UsoHogar;

import static mocks.Mock.*;

public class Sillon extends Mueble{

    private float ancho;
    private float alto;
    private String color;


    public Sillon(String nombre, String cdp, int stock, double precio, String marca, String modelo, CategoriasHogar categoria, UsoHogar uso, String material, int capacidad, EstiloMueble estilo, float ancho, float alto, String color) {
        super(nombre, cdp, stock, precio, marca, modelo, categoria, uso, material, capacidad, estilo);
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    /***CONSTRUCTORES*/


    public Sillon() {
    }

    /***IMPRIMIR*/

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Alto:................: " + alto);
        System.out.println("Ancho:...............: " + ancho);
        System.out.println("Colo:................: " + color);
        System.out.println("==============================================");
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("==============================================");

    }

    public static Sillon sillonRandom(){
        Sillon sillon =(Sillon) new Sillon();
        sillon.alto = random.nextFloat(0.5f, 1.5f);
        sillon.ancho = random.nextFloat(0.5f, 1.5f);
        sillon.color = getColores();
        sillon.categoria(CategoriasHogar.MUEBLES);
        sillon.uso(UsoHogar.CUIDADO_PERSONAL);
        sillon.material("Madera");
        sillon.capacidad(random.nextInt(1, 5));
        sillon.estilo(EstiloMueble.values()[random.nextInt(EstiloMueble.values().length)]);
        sillon.capacidad(random.nextInt(10));
        sillon.nombre(getNombresSillones());
        sillon.marca(getMarcaMuebles());
        sillon.modelo(getModeloMueble());
        sillon.stock(random.nextInt(1, 50));
        sillon.precio(random.nextDouble(5000, 100000));
        return sillon;
    }
}
