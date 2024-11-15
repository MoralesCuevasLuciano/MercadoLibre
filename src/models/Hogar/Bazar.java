package models.Hogar;

import enums.CategoriasHogar;
import enums.TamañoBazar;
import enums.UsoHogar;

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
}
