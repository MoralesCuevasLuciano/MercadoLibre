package models.ArrayList;

import models.Excepciones.NoHayStock;
import models.Producto;
import models.Usuario.Cliente;

import java.util.ArrayList;
import java.util.List;

public class CartList <T extends Producto> {
    private List<Producto> carrito = new ArrayList<>();
    private List<Integer> cantidad = new ArrayList<>();

    /**CONSTRUCTORES*/

    public CartList() {
        this.carrito = new ArrayList<>();
        this.cantidad = new ArrayList<>();
    }

    /**METODOS: FALTAN VALIDACIONES PERSO*/

    /**AGREGA AL CARRITO*/
    public void addToCart(T p, int cantidad) throws NoHayStock{
        if(p.getStock()>=cantidad){
            this.carrito.add(p);
            this.cantidad.add(cantidad);
        }else{
            throw new NoHayStock("La cantidad de productos que deseas no estan disponibles");
        }
    }
    /**ELIMINA EL CARRITO*/
    public void eliminarTodoDelCarrito(){
     this.carrito.clear();
     this.cantidad.clear();
    }

    /**COMPRA EL CARRITO*/

    public void comprarCart(Cliente c){
        //CALCULA EL PRECIO TOTAL DEL CARRITO Y LO RETONA
        double total = calucarPrecioTotal();

        // VALIDAMOS QUE TENGA UN MANGO PRIMERO
        if(c.getSaldo()>=total){
            for(int i=0; i<this.carrito.size();i++){
                //COMO NATURALMENTE LAS LISTAS TENDRAN EL MISMO TAMAÑO, SE USA UN FOR PARA SACAR SU INFO
                Producto p = this.carrito.get(i); //RECORREMOS PRODUCTO I
                int cantidades = this.cantidad.get(i); //RECORREMOS LA CANTIDAD DELE PRODUCTO I

                //ACTUALIZAMOS EL STOCK
                p.stock((p.getStock()-cantidades));
        }
            //RESTAMOS LOS MANGOS
            c.saldo(c.getSaldo()-total);
            eliminarTodoDelCarrito();
            System.out.println("Compra realizada con exito");
        }else{
            System.out.println("No es posible comprar el carrito");
        }
    }

    public void mostrarCarrito() {
        double total = calucarPrecioTotal();
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Contenido del carrito:");
            for (int i = 0; i < carrito.size(); i++) {
                Producto p = carrito.get(i);
                int cantidadProducto = cantidad.get(i);
                System.out.println("Producto: " + p.getNombre() +
                        ", Precio: $" + p.getPrecio() +
                        ", Cantidad: " + cantidadProducto +
                        ", Subtotal: $" + (p.getPrecio() * cantidadProducto));
            }
            System.out.println("Total a pagar: $" + total);
        }
    }

    /**CUANTO VALE EL CARRITO*/

    public double calucarPrecioTotal(){
        double total = 0;
        for(int i=0; i<this.carrito.size();i++){
            Producto p = this.carrito.get(i);
            int cantidades = this.cantidad.get(i);

            total= total+ (p.getPrecio() * cantidades);
        }
        return total;
    }
}


