package models.ArrayList;

import models.Excepciones.NoHayStock;
import models.Producto;
import models.Usuario.Cliente;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CartMap{

    Map<Producto,Integer> carrito = new HashMap<>();


    /**CONSTRUCTORES*/
    public CartMap() {
        this.carrito = new HashMap<>();
    }

    public Map<Producto, Integer> getCarrito() {
        return carrito;
    }

    /**METODOS*/
    public void agregarAlCarrito(Producto p, int cantidad) throws NoHayStock {
        if(p.getStock()<cantidad){
            throw new NoHayStock("La cantidad de productos que deseas no estan disponibles ");
        }else{
            carrito.put(p,cantidad);
            System.out.println("Has agregado al carrito " + p.getNombre());
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
            total = totalPrecioCarrito();
            c.saldo(c.getSaldo()-total);
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

    public void getOrDefault(Producto p, Integer i){
        this.carrito.getOrDefault(p,i);
    }

    public boolean isEmpty(){
        this.carrito.isEmpty();
        return false;
    }

    public Set<Map.Entry<Producto, Integer>> entrySet() {
        return carrito.entrySet();
    }

    public void vaciarCarrito(){
        this.carrito.clear();
    }

    public void comprarCarrito1(Cliente c) {
        double total = totalPrecioCarrito();

        // Comprobar si el cliente tiene saldo suficiente
        if (c.getSaldo() >= total) {
            // Verificar stock y restar la cantidad del stock
            for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
                Producto p = entry.getKey();
                int cantidades = entry.getValue();

                if (p.getStock() >= cantidades) {
                    // Descontar stock del producto
                    p.stock(p.getStock() - cantidades);
                } else {
                    System.out.println("Se agotó el producto " + p.getNombre() + ". Por favor, busca otro.");
                    carrito.remove(p);  // Eliminar producto agotado
                }
            }

            // Restar el saldo del cliente y agregar la compra al historial
            c.saldo(c.getSaldo() - total);
            String detallesCompra = "Compra realizada:\n";
            for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
                Producto p = entry.getKey();
                detallesCompra += "Producto: " + p.getNombre() +
                        ", Precio: $" + p.getPrecio() +
                        ", Cantidad: " + entry.getValue() + "\n";
            }
            detallesCompra += "Total: $" + total;

            // Agregar al historial de compras del cliente
            c.getHistorialCompras().agregarCompra(detallesCompra);

            // Vaciar el carrito después de la compra
            eliminarCarrito();

        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente. No se puede completar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
