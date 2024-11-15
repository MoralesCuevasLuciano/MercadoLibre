package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;
import models.Producto;

public class JugueteManual extends Juguete{


    public JugueteManual(String nombre, String cdp, int stock, double precio, String marca, String modelo, int edad, CategoriaJuguete categoria, MaterialJuguete material) {
        super(nombre, cdp, stock, precio, marca, modelo, edad, categoria, material);
    }

    /**Constructores*/



    @Override
    public void imprimir() {
      super.imprimir();
    }

    @Override
    public void imprimirCliente() {
       super.imprimirCliente();
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
