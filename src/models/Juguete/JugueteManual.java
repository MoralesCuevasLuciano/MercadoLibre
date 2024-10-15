package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;
import models.Producto;

public class JugueteManual extends Juguete{


    /**Constructores*/
    public JugueteManual(String nombre, String marca, String modelo, double precio, int stock, CategoriaJuguete categoria, int edad, MaterialJuguete material) {
        super(nombre, marca, modelo, precio, stock, categoria, edad, material);
    }


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

    @Override
    public int compareTo(Producto o) {
        return 0;
    }
}
