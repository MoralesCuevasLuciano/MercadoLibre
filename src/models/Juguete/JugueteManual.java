package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialJuguete;

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
}
