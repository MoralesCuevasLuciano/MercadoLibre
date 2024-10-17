package models.Ropa;

import enums.GeneroRopa;
import enums.TalleRemera;

public class Buzo extends Ropa {
    private boolean tieneCapucha;
    private boolean tieneCierre;
    private boolean tieneBolsillos;
    private boolean tieneEstampado;
    private boolean impermeable;

    /**Constructores*/
    public Buzo(String nombre, String marca, String modelo, double precio, int stock, String color, GeneroRopa genero, TalleRemera talle, String material, boolean tieneCapucha, boolean impermeable, boolean tieneEstampado, boolean tieneBolsillos, boolean tieneCierre) {
        super(nombre, marca, modelo, precio, stock, color, genero, talle, material);
        this.tieneCapucha = tieneCapucha;
        this.impermeable = impermeable;
        this.tieneEstampado = tieneEstampado;
        this.tieneBolsillos = tieneBolsillos;
        this.tieneCierre = tieneCierre;
    }

    /**Getters y Setters*/

    public boolean isTieneCapucha() {
        return tieneCapucha;
    }
    public Buzo tieneCapucha(boolean tieneCapucha) {
        this.tieneCapucha = tieneCapucha;
        return this;
    }
    public boolean isTieneCierre() {
        return tieneCierre;
    }
    public Buzo tieneCierre(boolean tieneCierre) {
        this.tieneCierre = tieneCierre;
        return this;
    }
    public boolean isTieneBolsillos() {
        return tieneBolsillos;
    }
    public Buzo tieneBolsillos(boolean tieneBolsillos) {
        this.tieneBolsillos = tieneBolsillos;
        return this;
    }
    public boolean isTieneEstampado() {
        return tieneEstampado;
    }
    public Buzo tieneEstampado(boolean tieneEstampado) {
        this.tieneEstampado = tieneEstampado;
        return this;
    }
    public boolean isImpermeable() {
        return impermeable;
    }
    public Buzo impermeable(boolean impermeable) {
        this.impermeable = impermeable;
        return this;
    }


    /**Imprimir*/
    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Capucha:...................: " + tieneCapucha);
        System.out.println("Cierre:....................: " + tieneCierre);
        System.out.println("Bolsillos:.................: " + tieneBolsillos);
        System.out.println("Estampado:.................: " + tieneEstampado);
        System.out.println("Impermeable:...............: " + impermeable);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Capucha:...................: " + tieneCapucha);
        System.out.println("Cierre:....................: " + tieneCierre);
        System.out.println("Bolsillos:.................: " + tieneBolsillos);
        System.out.println("Estampado:.................: " + tieneEstampado);
        System.out.println("Impermeable:...............: " + impermeable);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Buzo{" +
                "tieneCapucha=" + tieneCapucha +
                ", tieneCierre=" + tieneCierre +
                ", tieneBolsillos=" + tieneBolsillos +
                ", tieneEstampado=" + tieneEstampado +
                ", impermeable=" + impermeable +
                '}';
    }
}
