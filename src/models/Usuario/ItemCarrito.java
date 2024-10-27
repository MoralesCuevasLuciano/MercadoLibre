package models.Usuario;

import models.Producto;

public class ItemCarrito {
    private Producto producto;
    private Integer cantidad;

    /** CONSTRUCTOR */
    public ItemCarrito(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /** METODOS*/
    public boolean vender(){
        if (cantidad <= producto.getStock()){
            this.producto.stock(producto.getStock()-cantidad);
            return true;
        }else {
            return false;
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

    public ItemCarrito producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public ItemCarrito cantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }


}
