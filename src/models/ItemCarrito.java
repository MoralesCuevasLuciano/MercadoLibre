package models;

public class ItemCarrito {
    private Producto producto;
    private Integer cantidad;

    /** CONSTRUCTOR */
    public ItemCarrito(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /** METODOS*/

    public void vender(){
        if (cantidad <= producto.getStock()){
            this.producto.stock(producto.getStock()-cantidad);
        }else {
            System.out.println("El producto no tiene suficiente cantidad");
        }
    }

    @Override
    public String toString() {
        return "ItemCarrito{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }

    /** GETTERS AND SETTERS*/

    public Producto getProducto() {
        return producto;
    }

    public ItemCarrito setProducto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public ItemCarrito setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }


}
