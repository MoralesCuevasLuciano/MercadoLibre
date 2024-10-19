package models.Usuario;

import models.Producto;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> carrito;

    /***CONSTRUCTOR*/
    public Carrito() {
        this.carrito = new ArrayList<>();
    }

    /**METODOS*/

    public void agregarProducto(Producto producto) {
        carrito.add(producto);
        System.out.println(producto.getNombre() + " ha sido añadido al carrito.");
    }

    public void eliminarProducto(Producto producto) {
        carrito.remove(producto);
        System.out.println(producto.getNombre() + " ha sido eliminado al carrito.");
    }


    public void mostrarCarrito() {
        System.out.println("Productos en el carrito:");
        for (Producto producto : carrito) {
            System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    /** Devuelve precio del carrito*/
    public float precioCarrito(){
        float precio = 0;
        for (Producto producto : carrito) {
            precio += (float) producto.getPrecio();
        }
        return precio;
    }

    /** Elimina todos los productos del carrito*/

    public void comprarCarrito() {
        this.carrito.removeAll(carrito);
    }


}





