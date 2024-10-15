package models.Herramienta;

import enums.CategoriasHerramientas;

public class HerramientaManual extends Herramienta{

    private CategoriasHerramientas categorias;

    public CategoriasHerramientas getCategorias() {
        return categorias;
    }

    public HerramientaManual Categorias(CategoriasHerramientas categorias) {
        this.categorias = categorias;
        return this;
    }

    public HerramientaManual(String nombre, String marca, String modelo, double precio, int stock, CategoriasHerramientas categorias) {
        super(nombre, marca, modelo, precio, stock);
        this.categorias = categorias;
    }

    @Override
    public void imprimir() {
      super.imprimir();
      System.out.println("Precio: " + getPrecio());
        System.out.println("------------------------------------------");

    }

    //IMPRIMIR SIN ID Y SIN STOCK YA QUE SON DATOS NO NECESARIOS PARA LOS CLIENTES

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Precio: " + getPrecio());
        System.out.println("------------------------------------------");
    }
}
