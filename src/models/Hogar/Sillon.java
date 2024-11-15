package models.Hogar;

import enums.CategoriasHogar;
import enums.EstiloMueble;
import enums.UsoHogar;

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
}
