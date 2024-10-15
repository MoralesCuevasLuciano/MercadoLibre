package models.Herramienta;

import enums.CategoriasHerramientas;
import models.Producto;

public class HerramientaManual extends Herramienta{



    /**Constructores*/
    public HerramientaManual(String nombre, String marca, String modelo, double precio, int stock, CategoriasHerramientas categorias) {
        super(nombre, marca, modelo, precio, stock);
        this.categorias = categorias;
    }

    private CategoriasHerramientas categorias;


    /**Getters y Setters*/
    public CategoriasHerramientas getCategorias() {
        return categorias;
    }
    public HerramientaManual categorias(CategoriasHerramientas categorias) {
        this.categorias = categorias;
        return this;
    }




    /**Imprimir*/
    @Override
    public void imprimir() {
      super.imprimir();
      System.out.println("Precio:...................." + getPrecio());
      System.out.println("==============================================");

    }

    //IMPRIMIR SIN ID Y SIN STOCK YA QUE SON DATOS NO NECESARIOS PARA LOS CLIENTES
    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Precio:...................." + getPrecio());
        System.out.println("==============================================");
    }

    @Override
    public String toString() {
        return "HerramientaManual{" +
                "categorias=" + categorias +
                '}';
    }




    /**Equals y HashCode*/
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Producto o) {
        return 0;
    }
}
