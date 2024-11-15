package models.Herramienta;

import models.Producto;

public class HerramientaElectrica extends Herramienta{

    private float voltaje;
    private boolean Inalambrico;


    /**Constructores*/

    public HerramientaElectrica(String nombre, String cdp, int stock, double precio, String marca, String modelo, float voltaje, boolean inalambrico) {
        super(nombre, cdp, stock, precio, marca, modelo);
        this.voltaje = voltaje;
        Inalambrico = inalambrico;
    }

    public HerramientaElectrica() {
    }

    /**Getters y Setters*/
    public float getVoltaje() {
        return voltaje;
    }
    public HerramientaElectrica voltaje(float voltaje) {
        this.voltaje = voltaje;
        return this;
    }
    public boolean isInalambrico() {
        return Inalambrico;
    }
    public HerramientaElectrica inalambrico(boolean inalambrico) {
        Inalambrico = inalambrico;
        return this;
    }




    /**Imprimir*/
    @Override
    public void imprimir() {
      super.imprimir();
        System.out.println("Voltaje:...................: " + getVoltaje());System.out.println("==============================================");
        String mensaje = isInalambrico() ?  "El producto es inalambrico" : "El producto es cableado";
        System.out.println(mensaje);
        System.out.println("==============================================");
        System.out.println("");

    }
    public void imprimirCliente(){
        super.imprimirCliente();
        System.out.println("Voltaje:...................: " + getVoltaje());
        String mensaje = isInalambrico() ?  "El producto es inalambrico" : "El producto es cableado";
        System.out.println(mensaje);
        System.out.println("==============================================");

        System.out.println("");
    }

    //IMPRIMIR SIN ID Y SIN STOCK YA QUE SON DATOS NO NECESARIOS PARA LOS CLIENTES


    @Override
    public String toString() {
        return "HerramientaElectrica{" +
                "voltaje=" + voltaje +
                ", Inalambrico=" + Inalambrico +
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


}
