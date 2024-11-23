package models.Ropa;

import enums.Genero;
import enums.TalleRemera;
import enums.TipoCalzado;
import enums.UsoCalzadoPantalon;

import static mocks.Mock.*;

public class Calzado extends Ropa {
    private TipoCalzado tipo;
    private UsoCalzadoPantalon uso;

    /**Constructores*/
    public Calzado(String nombre, String cdp, int stock, double precio, String marca, String modelo, String color, Genero genero, TalleRemera talle, String material, TipoCalzado tipo, UsoCalzadoPantalon uso) {
        super(nombre, cdp, stock, precio, marca, modelo, color, genero, talle, material);
        this.tipo = tipo;
        this.uso = uso;
    }

    public Calzado() {
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
        return super.toString() +
                "\nTipo:..........................: " + tipo +
                "\nUso:............................: " + uso +
                "\n==============================================\n\n";
    }

    public static Calzado calzadoRandom(){
        Calzado calzado = (Calzado) new Calzado();
        calzado.tipo = TipoCalzado.values()[(int) (Math.random() * TipoCalzado.values().length)];
        calzado.uso = UsoCalzadoPantalon.values()[(int) (Math.random() * UsoCalzadoPantalon.values().length)];
        calzado.color(getColores());
        calzado.genero(Genero.values()[(int) (Math.random() * Genero.values().length)]);
        calzado.talle(TalleRemera.values()[(int) (Math.random() * TalleRemera.values().length)]);
        calzado.material(getMaterialRopa());
        calzado.modelo(getModeloCalzado());
        calzado.marca(getMarcaRopa());
        calzado.nombre(calzado.getMarca() + " " + getNombreCalzado() +" " + calzado.getModelo());
        calzado.stock((int) (Math.random() * 100));
        calzado.precio(Math.random() * 300000);
        return calzado;
    }
}
