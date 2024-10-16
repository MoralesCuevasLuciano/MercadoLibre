package models.Herramienta;

import models.Producto;

public class HerramientaElectrica extends Herramienta{

    private float voltaje;
    private boolean Inalambrico;


    /**Constructores*/
    public HerramientaElectrica(String nombre, String marca, String modelo, double precio, int stock, float voltaje, boolean esInalambrico) {
        super(nombre, marca, modelo, precio, stock);
        this.voltaje = voltaje;
        this.Inalambrico = esInalambrico;
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
        if(isInalambrico()){
            System.out.println("La herramienta es inalambrica");
        }else{
            System.out.println("La herramienta es cableada ");
        }
        System.out.println("==============================================");
        System.out.println("");

    }
    public void imprimirCliente(){
        super.imprimirCliente();
        System.out.println("Voltaje:...................: " + getVoltaje());
        if(isInalambrico()){
            System.out.println("La herramienta es inalambrica");
        }else{
            System.out.println("La herramienta es cableada ");
        }
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
