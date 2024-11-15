package models.Tecnologia;

import enums.AhorroEnergia;
import enums.TipoTelevisor;

public class Televisor extends Tecnologia{
    private boolean esSmart;
    private TipoTelevisor tipoTV;
    private int tamanio;
    private AhorroEnergia ahorroEnergia;


    public Televisor(String nombre, String cdp, int stock, double precio, String marca, String modelo, float peso, String color, int anio, boolean esSmart, TipoTelevisor tipoTV, int tamanio, AhorroEnergia ahorroEnergia) {
        super(nombre, cdp, stock, precio, marca, modelo, peso, color, anio);
        this.esSmart = esSmart;
        this.tipoTV = tipoTV;
        this.tamanio = tamanio;
        this.ahorroEnergia = ahorroEnergia;
    }

    /**Constructores*/


    public Televisor() {
    }


    /**Getters y Setters*/
    public boolean isEsSmart() {
        return esSmart;
    }
    public Televisor esSmart(boolean esSmart) {
        this.esSmart = esSmart;
        return this;
    }
    public TipoTelevisor getTipoTV() {
        return tipoTV;
    }
    public Televisor tipoTV(TipoTelevisor tipoTV) {
        this.tipoTV = tipoTV;
        return this;
    }
    public int getTamanio() {
        return tamanio;
    }
    public Televisor tamanio(int tamanio) {
        this.tamanio = tamanio;
        return this;
    }
    public AhorroEnergia getAhorroEnergia() {
        return ahorroEnergia;
    }
    public Televisor ahorroEnergia(AhorroEnergia ahorroEnergia) {
        this.ahorroEnergia = ahorroEnergia;
        return this;
    }


    /**Imprimir*/
    public void imprimir() {
        super.imprimir();
        String mensaje = isEsSmart() ? "Es SMART" : "No es SMART";
        System.out.println("Tipo de TV.................: " + tipoTV);
        System.out.println("Tamanio pantalla:..........: " + tamanio);
        System.out.println("Procesador.................: " + ahorroEnergia);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        super.imprimir();
        String mensaje = isEsSmart() ? "Es SMART" : "No es SMART";
        System.out.println("Tipo de TV.................: " + tipoTV);
        System.out.println("Tamaño pantalla:...........: " + tamanio);
        System.out.println("Procesador.................: " + ahorroEnergia);
        System.out.println("==============================================");
        System.out.println("");

    }


    @Override
    public String toString() {
        return "Televisor{" +
                "esSmart=" + esSmart +
                ", tipoTV=" + tipoTV +
                ", tamanio=" + tamanio +
                ", ahorroEnergia=" + ahorroEnergia +
                '}';
    }
}
