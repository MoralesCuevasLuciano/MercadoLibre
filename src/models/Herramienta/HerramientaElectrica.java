package models.Herramienta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import mocks.Mock;
import models.Producto;

import java.util.Random;

import static mocks.Mock.getNombreHerramientasElectricas;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HerramientaElectrica extends Herramienta{

    private float voltaje;
    private boolean inalambrico;


    /**Constructores*/

    public HerramientaElectrica(String nombre, String cdp, int stock, double precio, String marca, String modelo, float voltaje, boolean inalambrico) {
        super(nombre, cdp, stock, precio, marca, modelo);
        this.voltaje = voltaje;
        this.inalambrico = inalambrico;
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
        return inalambrico;
    }

    public HerramientaElectrica inalambrico(boolean inalambrico) {
        this.inalambrico = inalambrico;
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
                ", Inalambrico=" + inalambrico +
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

    public static HerramientaElectrica herramientaElectricaRandom(){
        HerramientaElectrica herramientaElectrica = (HerramientaElectrica) new HerramientaElectrica()
                .voltaje(220)
                .inalambrico(new Random().nextBoolean())
                .nombre(getNombreHerramientasElectricas())
                .stock(Mock.getStock())
                .precio(Mock.getPrecio())
                .marca(Mock.getMarcaHerramientas())
                .modelo(Mock.getModeloHerramientas());
        return herramientaElectrica;
    }


}
