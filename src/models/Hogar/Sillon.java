package models.Hogar;

import enums.CategoriasHogar;
import enums.EstiloMueble;
import enums.UsoHogar;

public class Sillon extends Mueble{

    /**NO SE ME OCURREN ATRIBUTOS PARA SILLON ¿ALGUNA IDEA?*/

    /***CONSTRUCTORES*/

    public Sillon(String nombre, String marca, String modelo, double precio, int stock, float peso, CategoriasHogar categoria, UsoHogar uso, String material, int capacidad, EstiloMueble estilo) {
        super(nombre, marca, modelo, precio, stock, peso, categoria, uso, material, capacidad, estilo);
    }

    public Sillon() {
    }

    /***IMPRIMIR*/

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Capacidad:.................:" + getCapacidad());
        System.out.println("Estilo:....................:" + getEstilo());
        System.out.println("==============================================");
        System.out.println("");
    }
}
