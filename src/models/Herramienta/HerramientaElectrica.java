package models.Herramienta;

public class HerramientaElectrica extends Herramienta{

    private float voltaje;
    private boolean Inalambrico;

    public HerramientaElectrica(String nombre, String marca, String modelo, double precio, int stock, float voltaje, boolean esInalambrico) {
        super(nombre, marca, modelo, precio, stock);
        this.voltaje = voltaje;
        this.Inalambrico = esInalambrico;
    }

    public float getVoltaje() {
        return voltaje;
    }

    public HerramientaElectrica setVoltaje(float voltaje) {
        this.voltaje = voltaje;
        return this;
    }

    public boolean isInalambrico() {
        return Inalambrico;
    }

    public HerramientaElectrica setInalambrico(boolean inalambrico) {
        Inalambrico = inalambrico;
        return this;
    }

    @Override
    public void imprimir() {
      super.imprimir();
        System.out.println("Voltaje: " + getVoltaje());
        if(isInalambrico()==true){
            System.out.println("El producto es inalambrico");
        }else{
            System.out.println("Producto cableado");
        }
    }

    //IMPRIMIR SIN ID Y SIN STOCK YA QUE SON DATOS NO NECESARIOS PARA LOS CLIENTES

    @Override
    public void imprimirCliente() {
      super.imprimirCliente();
        System.out.println("Voltaje: " + getVoltaje());
        if(isInalambrico()==true){
            System.out.println("El producto es inalambrico");
        }else{
            System.out.println("Producto cableado");
        }

    }


}
