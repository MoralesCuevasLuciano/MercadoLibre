package models.Ropa;

import enums.Genero;
import enums.TalleRemera;
import enums.UsoCalzadoPantalon;

import static mocks.Mock.*;

public class Pantalon extends Ropa{
    private int cantidadBolsillos;
    private String estilo;
    private UsoCalzadoPantalon usoDeCalzado;
    private boolean tieneCierre;


    /**Constructores*/
    public Pantalon(String nombre, String cdp, int stock, double precio, String marca, String modelo, String color, Genero genero, TalleRemera talle, String material, int cantidadBolsillos, String estilo, UsoCalzadoPantalon usoDeCalzado, boolean tieneCierre) {
        super(nombre, cdp, stock, precio, marca, modelo, color, genero, talle, material);
        this.cantidadBolsillos = cantidadBolsillos;
        this.estilo = estilo;
        this.usoDeCalzado = usoDeCalzado;
        this.tieneCierre = tieneCierre;
    }

    public Pantalon() {
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

    public static Pantalon pantalonRandom(){
        Pantalon pantalon = (Pantalon) new Pantalon();
        pantalon.cantidadBolsillos(random.nextInt(6));
        pantalon.tieneCierre(random.nextBoolean());
        pantalon.estilo(getModeloPantalon());
        pantalon.usoDeCalzado(UsoCalzadoPantalon.values()[random.nextInt(UsoCalzadoPantalon.values().length)]);
        pantalon.color(getColores());
        pantalon.genero(Genero.values()[random.nextInt(Genero.values().length)]);
        pantalon.talle(TalleRemera.values()[random.nextInt(TalleRemera.values().length)]);
        pantalon.material(getMaterialRopa());
        pantalon.modelo(getModeloPantalon());
        pantalon.marca(getMarcaRopa());
        pantalon.nombre("Pantalon " + pantalon.getMarca() + " "  +getNombrePantalon() + " "+ pantalon.getModelo());
        return pantalon;
    }
}
