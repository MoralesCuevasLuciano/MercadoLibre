package models.ArrayList;

import models.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdministradorList {
    List<Producto> productosList;

    /**Constructores*/
    public AdministradorList(){
        this.productosList = new ArrayList<>();
    }

    public AdministradorList(int dim){
        this.productosList = new ArrayList<>(dim);
    }


    /**Agregar producto*/
    public void add(Producto p){
        productosList.add(p);
    }

    /**Agregar producto modificando stock*/
    public void add(Producto p, int stock){
        int newStock = p.getStock() + stock;
        p.stock(newStock);
        productosList.add(p);
    }

    /**Eliminar producto*/
    public void remove(Producto p){
        productosList.remove(p);
    }

    /**Eliminar producto modificando stock*/
    public void remove(Producto p, int stock){
        if(p.getStock() - stock >= 0){
            int newStock = p.getStock() - stock;
            p.stock(newStock);
        }else{
            System.out.println("No hay el suficiente stock disponible para eliminar el producto");
        }
    }

    public void removeTernario(Producto p, int stock){
        String mensaje = (p.getStock() - stock >= 0) ? "Stock actualizado" : "No hay stock suficiente disponible para eliminar el producto";
        System.out.println(mensaje);
    }

    /**Mostrar producto segun nombre*/
    public void show(String nombre){
        for(Producto producto : productosList){
            if(producto.getNombre().equals(nombre)){
                System.out.println(producto);
            }
        }
    }

    /**Mostrar producto segun marca*/
    public void showMarca(String marca){
        for(Producto producto : productosList){
            if(producto.getMarca().equals(marca)){
                System.out.println(producto);
            }
        }
    }

    /**Mostrar producto segun id*/
    public Producto search(String id){
        Producto p = null;
        for(Producto producto : productosList){
            if(producto.getId().equals(id)){
                p = producto;
                return p;
            }
        }
        return p;
    }

    /**Buscar producto por marca y nombre*/
    public Producto search(String marca, String nombre){
        Producto p = null;
        for(Producto producto : productosList){
            if(producto.getMarca().equals(marca) && producto.getNombre().equals(nombre)){
                p = producto;
                return p;
            }
        }
        return p;
    }

    /**Editar los atributos de un producto y que se guarde el nuevo producto*/
    public void edit(Producto p, String nombre, String marca, String modelo, double precio, int stock){
        p.nombre(nombre);
        p.marca(marca);
        p.modelo(modelo);
        p.precio(precio);
        p.stock(stock);
    }




    /**Comparar segun el comparable de Producto*/
    public void sort(){
        Collections.sort(productosList);
    }
}

