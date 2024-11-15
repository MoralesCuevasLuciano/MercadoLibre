package models.Herramienta;

import enums.CategoriasHerramientas;
import models.Producto;

public class HerramientaManual extends Herramienta {
    private CategoriasHerramientas categorias;

    /**
     * Constructores
     */

    public HerramientaManual(String nombre, String cdp, int stock, double precio, String marca, String modelo, CategoriasHerramientas categorias) {
        super(nombre, cdp, stock, precio, marca, modelo);
        this.categorias = categorias;
    }

    public HerramientaManual() {
    }

    /**
     * Getters y Setters
     */
    public CategoriasHerramientas getCategorias() {
        return categorias;
    }

    public HerramientaManual categorias(CategoriasHerramientas categorias) {
        this.categorias = categorias;
        return this;
    }

    /**
     * Imprimir
     */
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Uso........................" + getCategorias());
        System.out.println("==============================================");
        System.out.println("");

    }

    //IMPRIMIR SIN ID Y SIN STOCK YA QUE SON DATOS NO NECESARIOS PARA LOS CLIENTES
    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Uso........................" + getCategorias());
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public String toString() {
        return "HerramientaManual{" +
                "categorias=" + categorias +
                '}';
    }


    /**
     * Equals y HashCode
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
