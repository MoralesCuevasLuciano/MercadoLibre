package models.ArrayList;

import models.Excepciones.NoHayStock;
import models.Producto;
import models.Usuario.Cliente;

import java.util.HashMap;
import java.util.Map;

public class CartMap <T extends Producto>{

    Map<T,Integer> carrito = new HashMap<>();


    /**CONSTRUCTORES*/
    public CartMap() {
        this.carrito = new HashMap<>();
    }

    /**METODOS*/
    public void agregarAlCarrito(T p, int cantidad) throws NoHayStock {
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
            for(Map.Entry<T,Integer> entry : carrito.entrySet()){
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
            System.out.println("Tu compra ha sido comprada con exito.");
            eliminarCarrito();
        }else{
            System.out.println("Saldo insuficiente. ");
        }


    }

    public double totalPrecioCarrito(){
        double total=0;

        for(Map.Entry<T,Integer> entry: carrito.entrySet()){
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
            for (Map.Entry<T, Integer> entry : carrito.entrySet()) {
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

}
