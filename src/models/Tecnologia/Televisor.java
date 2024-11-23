package models.Tecnologia;

import enums.TipoTelevisor;

import static mocks.Mock.*;

public class Televisor extends Tecnologia{
    private boolean esSmart;
    private TipoTelevisor tipoTV;
    private int tamanio;


    public Televisor(String nombre, String cdp, int stock, double precio, String marca, String modelo, float peso, String color, int anio, boolean esSmart, TipoTelevisor tipoTV, int tamanio) {
        super(nombre, cdp, stock, precio, marca, modelo, peso, color, anio);
        this.esSmart = esSmart;
        this.tipoTV = tipoTV;
        this.tamanio = tamanio;
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


    /**Imprimir*/
    public void imprimir() {
        super.imprimir();
        String mensaje = isEsSmart() ? "Es SMART" : "No es SMART";
        System.out.println("Tipo de TV.................: " + tipoTV);
        System.out.println("Tamanio pantalla:..........: " + tamanio);
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
        System.out.println("==============================================");
        System.out.println("");

    }



    @Override
    public String toString() {
        return super.toString() +
                "\nSmart::.........................: " + esSmart +
                "\nTipo de TV:.....................: " + tipoTV +
                "\nTamanio:........................: " + tamanio +
                "\n==============================================\n\n";
    }



    public static Televisor televisorRandom(){
        Televisor televisor = (Televisor) new Televisor();
        televisor.esSmart = random.nextBoolean();
        televisor.tipoTV = TipoTelevisor.values()[(int) (Math.random() * TipoTelevisor.values().length)];
        televisor.tamanio = (int) (Math.random() * 80);
        televisor.peso((float) (Math.random() * 100));
        televisor.color(getColores());
        televisor.anio((int) (Math.random() * (2024-2018 + 1) + 2018));
        televisor.marca(getMarcaTecnologia());
        televisor.modelo(televisor.getTipoTV().toString());
        televisor.nombre(televisor.getMarca() + " " + televisor.getModelo());
        televisor.stock((int) (Math.random() * 100));
        televisor.precio((Math.random() * 2000000));
        return televisor;
    }
}
