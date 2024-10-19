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

    public void mostrarCarrito() {
        System.out.println("Productos en el carrito:");
        for (Producto producto : carrito) {
            System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }
}





