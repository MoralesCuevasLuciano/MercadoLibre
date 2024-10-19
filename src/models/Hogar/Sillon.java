package models.Hogar;

import enums.CategoriasHogar;
import enums.EstiloMueble;
import enums.UsoHogar;

public class Sillon extends Mueble{

    private float ancho;
    private float alto;
    private String color;



    /***CONSTRUCTORES*/
    public Sillon(String nombre, String marca, String modelo, double precio, int stock, float peso, CategoriasHogar categoria, UsoHogar uso, String material, int capacidad, EstiloMueble estilo, float alto, float ancho, String color) {
        super(nombre, marca, modelo, precio, stock, peso, categoria, uso, material, capacidad, estilo);
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
    }

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
