package models.Hogar;

import enums.CategoriasHogar;
import enums.EstiloMueble;
import enums.UsoHogar;
import mocks.Mock;

import java.util.Random;

public class Escritorio extends Mueble {

    private int numeroDePuertas;
    private boolean tieneCajones;

    public Escritorio(String nombre, String cdp, int stock, double precio, String marca, String modelo, CategoriasHogar categoria, UsoHogar uso, String material, int capacidad, EstiloMueble estilo, int numeroDePuertas, boolean tieneCajones) {
        super(nombre, cdp, stock, precio, marca, modelo, categoria, uso, material, capacidad, estilo);
        this.numeroDePuertas = numeroDePuertas;
        this.tieneCajones = tieneCajones;
    }

    /***CONSTRUCTORES*/


    public Escritorio() {
    }

    /***Getters and setters*/

    public int getNumeroDePuertas() {
        return numeroDePuertas;
    }

    public Escritorio numeroDePuertas(int numeroDePuertas) {
        this.numeroDePuertas = numeroDePuertas;
        return this;
    }

    public boolean isTieneCajones() {
        return tieneCajones;
    }

    public Escritorio tieneCajones(boolean tieneCajones) {
        this.tieneCajones = tieneCajones;
        return this;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Numero de Puertas..........:" + numeroDePuertas);
        String mensaje = isTieneCajones() ? "Tiene cajones" : "No tiene cajones";
        System.out.println(mensaje);
        System.out.println("==============================================");

    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Numero de Puertas..........:" + numeroDePuertas);
        String mensaje = isTieneCajones() ? "Tiene cajones" : "No tiene cajones";
        System.out.println(mensaje);
        System.out.println("==============================================");
    }

    public static Escritorio escritorioRandom(){
        Escritorio escritorio = (Escritorio) new Escritorio()
                .numeroDePuertas((int) (Math.random() * 4))
                .tieneCajones(new Random().nextBoolean())
                .stock(Mock.getStock())
                .precio(Mock.getPrecio())
                /*.marca(Mock.getMarcaMuebles())
                .modelo(Mock.getModeloMuebles())*/
                .nombre("Escritorio");
        escritorio.categoria(CategoriasHogar.MUEBLES);
        escritorio.uso(UsoHogar.ORGANIZAR);
        /*escritorio.material(Mock.getMaterialMuebles());*/
        return escritorio;
        /*Lo comentado falta agregar*/
    }
}
