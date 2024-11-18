package models.Hogar;

import enums.CategoriasHogar;
import enums.MaterialInsumo;
import enums.TamañoBazar;
import enums.UsoHogar;
import mocks.Mock;

import java.util.Random;

import static mocks.Mock.*;

public class Bazar extends Hogar{

    private TamañoBazar tamanio;
    private boolean resistenteAlCalor;

    public Bazar(String nombre, String cdp, int stock, double precio, String marca, String modelo, CategoriasHogar categoria, UsoHogar uso, String material, TamañoBazar tamanio, boolean resistenteAlCalor) {
        super(nombre, cdp, stock, precio, marca, modelo, categoria, uso, material);
        this.tamanio = tamanio;
        this.resistenteAlCalor = resistenteAlCalor;
    }

    /**CONSTRUCTORES*/




    public Bazar() {
    }

    /**Getters y Setters*/

    public boolean isResistenteAlCalor() { /*GETTER*/
        return resistenteAlCalor;
    }

    public Bazar resistenteAlCalor(boolean resistenteAlCalor) /*SET BUILDER*/{
        this.resistenteAlCalor = resistenteAlCalor;
        return this;
    }

    public TamañoBazar getTamanio() {
        return tamanio;
    }

    public Bazar tamanio(TamañoBazar tamanio) {
        this.tamanio = tamanio;
        return this;
    }

    /***IMPRIMIR*/

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Tamaño:.................." + tamanio);
        String mensaje = resistenteAlCalor ? "Es resistente al calor" : "No es resistente al calor";
        System.out.println(mensaje);
    }

    @Override
    public void imprimir() {
        super.imprimirCliente();
        System.out.println("Tamaño:.................." + tamanio);
        String mensaje = resistenteAlCalor ? "Es resistente al calor" : "No es resistente al calor";
        System.out.println(mensaje);
        System.out.println("==============================================");
    }

    public static Bazar bazarRandom(){
        Bazar bazar =  (Bazar) new Bazar()
                .tamanio(TamañoBazar.values()[(int) (Math.random() * (TamañoBazar.values().length))])
                .resistenteAlCalor(new Random().nextBoolean())
                .nombre(getNombreBazar())
                .stock(Mock.getStock())
                .precio(Mock.getPrecio())
                .marca(Mock.getMarcaBazar())
                .modelo(Mock.getModeloBazar());

        bazar.categoria(CategoriasHogar.values()[(int) (Math.random() * (CategoriasHogar.values().length))]);
        bazar.uso(UsoHogar.values()[(int) (Math.random() * (UsoHogar.values().length))]);
        bazar.material(Mock.getMaterialBazar());
        return bazar;
    }
}
