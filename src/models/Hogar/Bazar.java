package models.Hogar;

import enums.CategoriasHogar;
import enums.TamañoBazar;
import enums.UsoHogar;

public class Bazar extends Hogar{

    private TamañoBazar tamanio;
    private boolean resistenteAlCalor;

    /**CONSTRUCTORES*/

    public Bazar(String nombre, String marca, String modelo, double precio, int stock, float peso, CategoriasHogar categoria, UsoHogar uso, String material, boolean resistenteAlCalor, TamañoBazar tamanio) {
        super(nombre, marca, modelo, precio, stock, peso, categoria, uso, material);
        this.resistenteAlCalor = resistenteAlCalor;
        this.tamanio = tamanio;
    }

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
        System.out.println("Tamaño:.................." + getTamanio());
        String mensaje = isResistenteAlCalor() ? "Es resistente al calor" : "No es resistente al calor";
        System.out.println(mensaje);
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Tamaño:................." + getTamanio());
        String mensaje = isResistenteAlCalor() ? "Es resistente al calor" : "No es resistente al calor";
        System.out.println(mensaje);
    }
}
