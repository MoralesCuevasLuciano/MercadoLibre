package models.Ropa;

import enums.Genero;
import enums.TalleRemera;
import enums.UsoCalzadoPantalon;

public class Pantalon extends Ropa{
    private int cantidadBolsillos;
    private String estilo;
    private UsoCalzadoPantalon usoDeCalzado;
    private boolean tieneCierre;


    /**Constructores*/
    public Pantalon(String nombre, String marca, String modelo, double precio, int stock, String color, Genero genero, TalleRemera talle, String material, int cantidadBolsillos, String estilo, UsoCalzadoPantalon usoDeCalzado, boolean tieneCierre) {
        super(nombre, marca, modelo, precio, stock, color, genero, talle, material);
        this.cantidadBolsillos = cantidadBolsillos;
        this.estilo = estilo;
        this.usoDeCalzado = usoDeCalzado;
        this.tieneCierre = tieneCierre;
    }

    /**Getters y Setters*/
    public String getEstilo() {
        return estilo;
    }
    public Pantalon estilo(String estilo) {
        this.estilo = estilo;
        return this;
    }
    public int getCantidadBolsillos() {
        return cantidadBolsillos;
    }
    public Pantalon cantidadBolsillos(int cantidadBolsillos) {
        this.cantidadBolsillos = cantidadBolsillos;
        return this;
    }
    public UsoCalzadoPantalon getUsoDeCalzado() {
        return usoDeCalzado;
    }
    public Pantalon usoDeCalzado(UsoCalzadoPantalon usoDeCalzado) {
        this.usoDeCalzado = usoDeCalzado;
        return this;
    }
    public boolean getTieneCierre() {
        return tieneCierre;
    }
    public Pantalon tieneCierre(boolean tieneCierre) {
        this.tieneCierre = tieneCierre;
        return this;
    }


    /**Imprimir*/
    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Cantidad de Bolsillos:.....: " + cantidadBolsillos);
        System.out.println("Estilo:....................: " + estilo);
        System.out.println("Uso de calzado:............: " + usoDeCalzado);
        System.out.println("Cierre:....................: " + tieneCierre);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Cantidad de Bolsillos:.....: " + cantidadBolsillos);
        System.out.println("Estilo:....................: " + estilo);
        System.out.println("Uso de calzado:............: " + usoDeCalzado);
        System.out.println("Cierre:....................: " + tieneCierre);
        System.out.println("==============================================");
        System.out.println("");
    }


    @Override
    public String toString() {
        return "Calzado{" +
                "cantidadBolsillos=" + cantidadBolsillos +
                ", estilo='" + estilo + '\'' +
                ", usoDeCalzado=" + usoDeCalzado +
                ", tieneCierre=" + tieneCierre +
                '}';
    }
}
