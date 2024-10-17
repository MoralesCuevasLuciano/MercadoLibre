package models.Ropa;

import enums.GeneroRopa;
import enums.TalleRemera;
import enums.TipoDeRemera;

public class Remera extends Ropa {
    private TipoDeRemera tipoDeRemera;
    private TalleRemera talle;


    /**Constructores*/
    public Remera(String nombre, String marca, String modelo, double precio, int stock, String color, GeneroRopa genero, TalleRemera talle, String material) {
        super(nombre, marca, modelo, precio, stock, color, genero, talle, material);
    }


    /**Getters y Setters*/
    public TipoDeRemera getTipoDeRemera() {
        return tipoDeRemera;
    }
    public Remera tipoDeRemera(TipoDeRemera tipoDeRemera) {
        this.tipoDeRemera = tipoDeRemera;
        return this;
    }
    public TalleRemera getTalle() {
        return talle;
    }
    public Remera talle(TalleRemera talle) {
        this.talle = talle;
        return this;
    }

    /**Imprimir*/
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Tipo de remera:...........: " + tipoDeRemera);
        System.out.println("Talle:....................: " + talle);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Tipo de remera:...........: " + tipoDeRemera);
        System.out.println("Talle:....................: " + talle);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Remera{" +
                "tipoDeRemera=" + tipoDeRemera +
                ", talle=" + talle +
                '}';
    }
}
