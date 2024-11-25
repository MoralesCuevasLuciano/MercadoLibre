package models.Juguete;

import enums.CategoriaJuguete;
import enums.MaterialInsumo;
import enums.MaterialJuguete;
import mocks.Mock;
import models.Producto;

import static mocks.Mock.*;

public class JugueteManual extends Juguete{

    /**Constructores*/
    public JugueteManual(String nombre, String cdp, int stock, double precio, String marca, String modelo, int edad, CategoriaJuguete categoria, MaterialJuguete material) {
        super(nombre, cdp, stock, precio, marca, modelo, edad, categoria, material);
    }

    public JugueteManual() {
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
    public String toString() {
        return super.toString();
    }

    public static JugueteManual jugueteManualRandom(){
        JugueteManual jugueteManual = (JugueteManual) new JugueteManual()
                .edad(random.nextInt(18))
                .material(MaterialJuguete.valueOf(MaterialInsumo.values()[(int) Math.random() * MaterialInsumo.values().length].name()))
                .categoria(CategoriaJuguete.valueOf(CategoriaJuguete.values()[(int) Math.random() * CategoriaJuguete.values().length].name()))
                .nombre(getNombreJuguetesManuales())
                .stock(Mock.getStock())
                .precio(Mock.getPrecio())
                .marca(Mock.getMarcaJuguetes())
                .modelo(Mock.getModeloJuguetes());
        return jugueteManual;
    }



}
