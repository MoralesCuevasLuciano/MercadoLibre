package models.Hogar;

import enums.CategoriasHogar;
import enums.EstiloMueble;
import enums.UsoHogar;

public class Mueble extends Hogar{
    private int capacidad;
    private EstiloMueble estilo;

    public Mueble(String nombre, String marca, String modelo, double precio, int stock, float peso, CategoriasHogar categoria, UsoHogar uso, String material, int capacidad, EstiloMueble estilo) {
        super(nombre, marca, modelo, precio, stock, peso, categoria, uso, material);
        this.capacidad = capacidad;
        this.estilo = estilo;
    }

    public Mueble() {
    }

    /**Getter and setters**/

    public int getCapacidad() {
        return capacidad;
    }

    public Mueble capacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public EstiloMueble getEstilo() {
        return estilo;
    }

    public Mueble estilo(EstiloMueble estilo) {
        this.estilo = estilo;
        return this;
    }

    /***IMPRIMIR*/

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Capacidad:..............." + getCapacidad());
        System.out.println("Estilo:.................." + getEstilo());
    }
}
