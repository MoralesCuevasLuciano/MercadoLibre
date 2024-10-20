package models.ArrayList;

import models.Producto;
import models.Usuario.Cliente;

import java.util.ArrayList;
import java.util.List;

public class CarritoList {
    private List<Producto> carrito;

    /***CONSTRUCTOR*/
    public CarritoList() {
        this.carrito = new ArrayList<>();
    }

    /**METODOS*/

    public void agregarProducto(Producto producto) {
        carrito.add(producto);
        System.out.println(producto.getNombre() + " ha sido añadido al carrito.");
        System.out.println("");
    }

    public void eliminarProducto(Producto producto) {
        carrito.remove(producto);
        System.out.println(producto.getNombre() + " ha sido eliminado al carrito.");
        System.out.println("");
    }


    public void mostrarCarrito() {
        System.out.println("Productos en el carrito:");
        System.out.println("");
        for (Producto producto : carrito) {
            System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
            System.out.println("");
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

    /**Comprar Carrito*/

    public String comprarCarrito1(Cliente c) {
        if (precioCarrito() < c.getSaldo()) {
            //historialCompras.add(carrito);
            c.saldo(c.getSaldo()-precioCarrito());
           this.comprarCarrito();
           return "Compra exitosa!";

        }else {
            return "Error, saldo insuficiente";
        }
    }

    public String comprarTern(Cliente c) { //FUNCIONA, PERO NO REMUEVE LOS PRODUCTOS DEL CARRITO.
   String mensaje = precioCarrito() < c.getSaldo() ? "Su compra ha sido exitosa" + c.saldo(c.getSaldo()-precioCarrito()) : "Error, saldo insuficiente";
   return mensaje;
    }


    /** Elimina todos los productos del carrito*/

    public void comprarCarrito() {
        this.carrito.removeAll(carrito);
    }


}





