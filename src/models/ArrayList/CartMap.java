package models.ArrayList;

import models.Producto;
import models.Usuario.Cliente;

import java.util.HashMap;
import java.util.Map;

public class CartMap {

    Map<Producto,Integer> carrito = new HashMap<>();

    /**CONSTRUCTORES*/
    public CartMap() {
        this.carrito = new HashMap<>();
    }

    /**METODOS*/
    public void agregarAlCarrito(Producto p, int cantidad){
        if(p.getStock()<cantidad){
            System.out.println("No hay productos disponible, actualmente hay " + p.getStock() + "unidades");
        }else{
            carrito.put(p,cantidad);
            System.out.println("El coso se ha colocado con exito");
        }
    }

    public void eliminarCarrito(){
        this.carrito.clear();
    }

    public void comprarCarrito(Cliente c){
        double total = totalPrecioCarrito();

        if(c.getSaldo()>=total){
            for(Map.Entry<Producto,Integer> entry : carrito.entrySet()){
            Producto p= entry.getKey();
            int cantidades= entry.getValue();

            if(p.getStock()>=cantidades){
                p.stock(p.getStock()-cantidades);
            }else{
                System.out.println("Se agoto este producto" + p.getNombre() + "Por favor buscar otro");
                this.carrito.remove(p);
            }

        }
            c.saldo(c.getSaldo()-total);
            System.out.println("Tu compra ha sido comprada con exito.");
            eliminarCarrito();
        }else{
            System.out.println("Saldo insuficiente. ");
        }


    }

    public double totalPrecioCarrito(){
        double total=0;

        for(Map.Entry<Producto,Integer> entry: carrito.entrySet()){
            Producto p = entry.getKey();
            int cantidades= entry.getValue();
            total = total + (p.getPrecio()*cantidades);
        }
        return total;
    }

    public void mostrarCarrito() {
        double total= totalPrecioCarrito();
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Contenido del carrito:");
            for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
                Producto p = entry.getKey();
                int cantidadProducto = entry.getValue();
                System.out.println("Producto: " + p.getNombre() +
                        ", Precio: $" + p.getPrecio() +
                        ", Cantidad: " + cantidadProducto +
                        ", Subtotal: $" + (p.getPrecio() * cantidadProducto));
            }
            System.out.println("Total a pagar: $" + total);
        }
    }





}
