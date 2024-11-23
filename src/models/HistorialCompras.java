package models;

import models.ArrayList.CartMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistorialCompras {

    /** Lista que almacena las compras del cliente*/
    private List<String> compras;

    public HistorialCompras() {
        this.compras = new ArrayList<>();
    }

    /** Agregar una compra al historial*/
    public void agregarCompra(String compra) {
        compras.add(compra);
    }

    /** Mostrar el historial de compras*/
    public void mostrarHistorial() {
        if (compras.isEmpty()) {
            System.out.println("No tienes compras en tu historial.");
        } else {
            System.out.println("Historial de compras:");
            for (String compra : compras) {
                System.out.println(compra);
            }
        }
    }

    /**Método para obtener todas las compras*/
    public List<String> getCompras() {
        return compras;
    }


}

