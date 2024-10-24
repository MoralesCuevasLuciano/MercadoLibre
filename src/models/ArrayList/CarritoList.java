package models.ArrayList;

import models.Usuario.Cliente;
import models.Usuario.ItemCarrito;

import java.util.ArrayList;
import java.util.List;

public class CarritoList {
    private List<ItemCarrito> carrito;

    /***CONSTRUCTOR*/
    public CarritoList() {
        this.carrito = new ArrayList<>();
    }

    /**METODOS*/

    public void agregarProducto(ItemCarrito itemCarrito) {
        this.carrito.add(itemCarrito);
        System.out.println(itemCarrito.getProducto().getNombre() + " ha sido añadido al carrito.\n");
    }

    public void eliminarProducto(ItemCarrito itemCarrito) {
        carrito.remove(itemCarrito);
        System.out.println(itemCarrito.getProducto().getNombre() + " ha sido eliminado al carrito. \n");
    }

    /**Muestra que hay en el carrito*/
    public void mostrarCarrito() {
        System.out.println("Productos en el carrito:");
        System.out.println("");
        for (ItemCarrito itemCarrito : carrito) {
            System.out.println(itemCarrito.getProducto().getNombre() + " - $" + itemCarrito.getProducto().getPrecio() + "\n");
        }
    }



    /** Devuelve precio del carrito*/
    public float precioCarrito(){
        float precio = 0;
        for (ItemCarrito itemCarrito : carrito) {
            precio += (float) itemCarrito.getProducto().getPrecio();
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







