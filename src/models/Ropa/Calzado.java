package models.Ropa;

import enums.GeneroRopa;
import enums.TalleRemera;
import enums.TipoCalzado;
import enums.UsoCalzadoPantalon;

public class Calzado extends Ropa {
    private TipoCalzado tipo;
    private UsoCalzadoPantalon uso;

    /**Constructores*/
    public Calzado(String nombre, String marca, String modelo, double precio, int stock, String color, GeneroRopa genero, TalleRemera talle, String material, TipoCalzado tipo, UsoCalzadoPantalon uso) {
        super(nombre, marca, modelo, precio, stock, color, genero, talle, material);
        this.tipo = tipo;
        this.uso = uso;
    }

    /**Getters y Setters*/
    public TipoCalzado getTipo() {
        return tipo;
    }
    public Calzado tipo(TipoCalzado tipo) {
        this.tipo = tipo;
        return this;
    }
    public UsoCalzadoPantalon getUso() {
        return uso;
    }
    public Calzado uso(UsoCalzadoPantalon uso) {
        this.uso = uso;
        return this;
    }


    /**Imprimir*/
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Tipo de calzado:...........: " + tipo);
        System.out.println("Tipo de uso:...............: " + uso);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Tipo de calzado:...........: " + tipo);
        System.out.println("Tipo de uso:...............: " + uso);
        System.out.println("==============================================");
        System.out.println("");
    }


    @Override
    public String toString() {
        return "Calzado{" +
                "tipo=" + tipo +
                ", uso=" + uso +
                '}';
    }
}
