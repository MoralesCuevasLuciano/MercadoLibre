package models.ArrayList;

import models.Excepciones.NoHayStock;
import models.Producto;
import models.Usuario.Cliente;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CartMap {

    private Map<Producto, Integer> carrito = new HashMap<>();

    /** CONSTRUCTOR */
    public CartMap() {
        this.carrito = new HashMap<>();
    }

    /** MÉTODOS */

    // Agregar un producto al carrito
    public void agregarAlCarrito(Producto p, int cantidad) throws NoHayStock {
        if (p.getStock() < cantidad) {
            throw new NoHayStock("La cantidad de productos que deseas no están disponibles.");
        } else {
            carrito.put(p, cantidad);
            System.out.println("Has agregado al carrito " + p.getNombre());
        }
    }

    // Eliminar todos los productos del carrito
    public void eliminarCarrito() {
        this.carrito.clear();
    }

    // Comprar el carrito
    public void comprarCarrito(Cliente c) {
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
            c.saldo(c.getSaldo() - total);  // Descontar saldo
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

            JOptionPane.showMessageDialog(null, "Tu compra ha sido realizada con éxito. Muchas gracias por tu compra.");
            System.out.println("Tu compra ha sido realizada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente. No se puede completar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Calcular el total del precio de los productos en el carrito
    public double totalPrecioCarrito() {
        double total = 0;

        for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
            Producto p = entry.getKey();
            int cantidades = entry.getValue();
            total += (p.getPrecio() * cantidades);
        }

        return total;
    }

    // Mostrar los productos en el carrito
    public void mostrarCarrito() {
        double total = totalPrecioCarrito();
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

    // Método que devuelve un valor predeterminado si el producto no está en el carrito
    public Integer getOrDefault(Producto p, Integer i) {
        return this.carrito.getOrDefault(p, i);
    }

    // Verificar si el carrito está vacío
    public boolean isEmpty() {
        return this.carrito.isEmpty();
    }

    // Obtener el conjunto de entradas del carrito
    public Set<Map.Entry<Producto, Integer>> entrySet() {
        return carrito.entrySet();
    }
}

