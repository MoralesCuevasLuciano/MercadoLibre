package models.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.Producto;
import models.Tecnologia.Portatil;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static json.JsonProductos.serializarProductos;
import static models.Herramienta.HerramientaElectrica.herramientaElectricaRandom;
import static models.Herramienta.HerramientaManual.herramientaManualRandom;
import static models.Herramienta.Insumo.insumoRandom;
import static models.Hogar.Bazar.bazarRandom;
import static models.Hogar.Escritorio.escritorioRandom;
import static models.Hogar.Sillon.sillonRandom;
import static models.Juguete.JuegoDeMesa.juegoDeMesaRandom;
import static models.Juguete.JugueteElectrico.jugueteElectricoRandom;
import static models.Juguete.JugueteManual.jugueteManualRandom;
import static models.Ropa.Buzo.buzoRandom;
import static models.Ropa.Calzado.calzadoRandom;
import static models.Ropa.Pantalon.pantalonRandom;
import static models.Ropa.Remera.remeraRandom;
import static models.Tecnologia.Celular.celularRandom;
import static models.Tecnologia.PC_Escritorio.PC_EscritorioRandom;
import static models.Tecnologia.Portatil.portatilRandom;
import static models.Tecnologia.Televisor.televisorRandom;
@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar campos desconocidos
public class AdministradorList <T extends Producto> {
    List<T> productosList;

    /**Constructores*/
    public AdministradorList(){
        this.productosList = new ArrayList<>();
    }

    public void get(int i){
        this.productosList.get(i);
    }

    public List<T> getProductos() {
        return this.productosList;
    }

    public AdministradorList(int dim){
        this.productosList = new ArrayList<>(dim);
    }


    /**Agregar producto*/
    public void add(T p){
        productosList.add(p);
    }

    /**Agregar producto modificando stock*/
    public void add(T p, int stock){
        int newStock = p.getStock() + stock;
        p.stock(newStock);
        productosList.add(p);
    }


    /**Eliminar producto*/
    public void remove(T p){
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

    public int size(){
        return this.productosList.size();
    }

    public void removeTernario(T p, int stock){
        String mensaje = (p.getStock() - stock >= 0) ? "Stock actualizado" : "No hay stock suficiente disponible para eliminar el producto";
        System.out.println(mensaje);
    }



    public void show1(){
        for(Producto p : productosList){
            p.imprimir();
        }
    }

    /**Mostrar producto segun nombre*/

    public void show(String nombre){
        for(Producto producto : productosList){
            if(producto.getNombre().equals(nombre)){
                System.out.println(producto);
            }
        }
    }

    public Producto show3(Producto p){
        for(Producto producto : productosList){
            if(producto.equals(p)){
                System.out.println(producto);
            }
        }
        return p;
    }

    public String[] getNombresProductos() {
        String[] nombres = new String[this.productosList.size()];
        for (int i = 0; i < this.productosList.size(); i++) {
            nombres[i] = this.productosList.get(i).getNombre(); // Suponiendo que Producto tiene un método getNombre()
        }
        return nombres;
    }

    // Método para buscar un producto por su nombre
    public Producto  buscarProductoPorNombre(String nombre) {
        for (Producto t : this.productosList) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                return t;
            }
        }
        return null; // Retorna null si no encuentra el producto
    }

    public void mostrarProductosClases(String clase){
        for(Producto producto : productosList){
            if(producto.getClass().getSimpleName().equalsIgnoreCase(clase)){
                producto.imprimirCliente();
            }
        }
    }

    public String[] mostrarProductosClases2(String clase) {
        List<String> productosCoincidentes = new ArrayList<>();

        for (int i = 0; i < productosList.size(); i++) {

            if (productosList.get(i).getClass().getSimpleName().equalsIgnoreCase(clase)) {
                productosCoincidentes.add(productosList.get(i).toString());
            }
        }


        return productosCoincidentes.toArray(new String[0]);
    }

    public String[] obtenerNombresClases() {
        Set<String> clases = new HashSet<>();

        // Iterar sobre el arreglo de objetos y obtener el nombre de cada clase
        for (int i = 0; i < productosList.size(); i++) {
            clases.add(this.productosList.get(i).getClass().getSimpleName());  // Almacenar el nombre de la clase
        }

        String[] nombresClases = clases.toArray(new String[0]);
        return nombresClases;
    }

    public String[] crearArregloDeNombres() {
        // Crear un arreglo de nombres
        String[] nombresArray = productosList.stream()
                .map(Producto::getNombre)
                .toArray(String[]::new);

        // Imprimir el nombre de las clases de los elementos
        for (int i = 0; i < productosList.size(); i++) {
            nombresArray[i] = this.productosList.get(i).getClass().getSimpleName();
        }

        return nombresArray;
    }
    /**Mostrar producto segun marca*/
    public void showMarca(String marca){
        for(Producto producto : productosList){
            if(producto.getMarca().equals(marca)){
                System.out.println(producto);
            }
        }
    }

    /**Mostrar producto segun id ESTO TIENE QUE SER POR CODIGO DE PRODUCTO*/
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
            if(producto.getMarca().equalsIgnoreCase(marca) && producto.getNombre().equalsIgnoreCase(nombre)){
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

    public void mostrareFrame (JTextArea textArea){
        for (Producto producto : this.productosList) {
            textArea.append(producto + "\n");
        }
    }

    public void mostrareFrame1 (JTextArea textArea,String clase){
        for (Producto producto : this.productosList) {
            if(producto.getClass().getSimpleName().equalsIgnoreCase(clase))
            textArea.append(producto + "\n");
        }
    }

    public void recorrerAdmin(JPanel panel){
        for (Producto producto : this.productosList) {
            JButton botonProducto = new JButton(producto.getNombre()+ " Stock=" + producto.getStock());
            botonProducto.setSize(20,10);
            botonProducto.addActionListener(e -> editAction(producto));
            panel.add(botonProducto);
        }
    }

    public void editAction(Producto p){
        JFrame editFrame = new JFrame("Editar Producto");
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.setLayout(new GridLayout());
        editFrame.setLocationRelativeTo(null);
        editFrame.setVisible(true);
        editFrame.setSize(400,175);
        editFrame.setResizable(false);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        editFrame.add(panelBotones);


        JButton btnEditarNombre = new JButton("Editar Nombre");
        btnEditarNombre.setSize(20,10);
        btnEditarNombre.addActionListener(e -> editarOpcionFrame(p, "nombre"));
        panelBotones.add(btnEditarNombre);

        JButton btnEditarMarca = new JButton("Editar Marca");
        btnEditarMarca.setSize(20,10);
        btnEditarMarca.addActionListener(e -> editarOpcionFrame(p, "marca"));
        panelBotones.add(btnEditarMarca);

        JButton btnEditarModelo = new JButton("Editar Modelo");
        btnEditarModelo.setSize(20,10);
        btnEditarModelo.addActionListener(e -> editarOpcionFrame(p, "modelo"));
        panelBotones.add(btnEditarModelo);

        JButton btnEditarPrecio = new JButton("Editar Precio");
        btnEditarPrecio.setSize(20,10);
        btnEditarPrecio.addActionListener(e -> editarOpcionFrame(p, "precio"));
        panelBotones.add(btnEditarPrecio);

        JButton btnEditarStock = new JButton("Editar Stock");
        btnEditarStock.setSize(20,10);
        btnEditarStock.addActionListener(e -> editarOpcionFrame(p, "stock"));
        panelBotones.add(btnEditarStock);


    }

    private void editarNombreFrame(Producto p){
        JFrame editNombreFrame = new JFrame("Editar Nombre");
        editNombreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editNombreFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        editNombreFrame.setLocationRelativeTo(null);
        editNombreFrame.setVisible(true);
        editNombreFrame.setSize(400,175);
        editNombreFrame.setResizable(false);

        JPanel panel = new JPanel(new GridLayout(2,1));

        JLabel label = new JLabel("Ingrese nuevo nombre");

        JTextField txtNombre = new JTextField(20);
        txtNombre.addActionListener(e -> {
            p.nombre(txtNombre.getText());
            JOptionPane.showMessageDialog(editNombreFrame, "El nombre fue reemplazado correctamente, los cambios estaran al volver abrir la lista");
            editNombreFrame.setVisible(false);
        });

        panel.add(label);
        panel.add(txtNombre);

        editNombreFrame.add(panel);


    }

    private void editarOpcionFrame(Producto p, String opcion){
        JFrame editOpcionFrame = new JFrame("Editar " + opcion);
        editOpcionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editOpcionFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        editOpcionFrame.setLocationRelativeTo(null);
        editOpcionFrame.setVisible(true);
        editOpcionFrame.setSize(400,175);
        editOpcionFrame.setResizable(false);

        JPanel panel = new JPanel(new GridLayout(2,1));

        JLabel label = new JLabel("Ingrese " + opcion);

        JTextField txtNombre = new JTextField(20);
        txtNombre.addActionListener(e -> {
            String entrada = txtNombre.getText();
            if (entrada.isEmpty()) {
                JOptionPane.showMessageDialog(editOpcionFrame, "El campo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                switch (opcion.toLowerCase()) {
                    case "nombre":
                        p.nombre(entrada);
                        break;
                    case "marca":
                        p.marca(entrada);
                        break;
                    case "stock":
                        int stock = Integer.parseInt(entrada);
                        p.stock(stock);

                        break;
                    case "precio":
                        double precio = Double.parseDouble(entrada);
                        p.precio(precio);
                        break;
                    default:
                        JOptionPane.showMessageDialog(editOpcionFrame, "Opción no válida: " + opcion, "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                JOptionPane.showMessageDialog(editOpcionFrame, "El " + opcion + " fue actualizado correctamente. Actualice para ver cambios");
                editOpcionFrame.dispose(); // Cerrar la ventana
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(editOpcionFrame, "El valor ingresado no es válido para " + opcion + ".", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(label);
        panel.add(txtNombre);

        editOpcionFrame.add(panel);


    }

    public void cargarProductosRandom1(int cantidad) {
        for (int i = 0; i <= cantidad; i++) {
            int random = 0;
            while (random <1 || random>17) {
                random = (int) (Math.random() * 17 - 1 + 1) + 1;
            }
             random= (int) (Math.random() * 17-1 + 1) + 1;
            switch (random) {
                case 1:
                    add((T)herramientaElectricaRandom());
                case 2:
                    add((T)herramientaManualRandom());
                case 3:
                    add((T)insumoRandom());
                case 4:
                    add((T)juegoDeMesaRandom());
                case 5:
                    add((T)jugueteElectricoRandom());
                case 6:
                    add((T)jugueteManualRandom());
                case 7:
                    add((T)buzoRandom());
                case 8:
                    add((T)calzadoRandom());
                case 9:
                    add((T)pantalonRandom());
                case 10:
                    add((T)remeraRandom());
                case 11:
                    add((T)celularRandom());
                case 12:
                    add((T)PC_EscritorioRandom());
                case 13:
                    add((T) portatilRandom());
                case 14:
                    add((T) televisorRandom());
                case 15:
                    add((T) bazarRandom());
                case 16:
                    add((T) escritorioRandom());
                case 17:
                    add((T) sillonRandom());
            }
        }
    }

    public void cargarProductosRandom2(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int random = (int) (Math.random() * 18-1 + 1) + 1;
            switch (random) {
                case 1:
                    add((T)herramientaElectricaRandom());
                    break;
                case 2:
                    add((T)herramientaManualRandom());
                    break;
                case 3:
                    add((T)insumoRandom());
                    break;
                case 4:
                    add((T)juegoDeMesaRandom());
                    break;
                case 5:
                    add((T)jugueteElectricoRandom());
                    break;
                case 6:
                    add((T)jugueteManualRandom());
                    break;
                case 7:
                    add((T)buzoRandom());
                    break;
                case 8:
                    add((T)calzadoRandom());
                    break;
                case 9:
                    add((T)pantalonRandom());
                    break;
                case 10:
                    add((T)remeraRandom());
                    break;
                case 11:
                    add((T)celularRandom());
                    break;
                case 12:
                    add((T)PC_EscritorioRandom());
                    break;
                case 13:
                    add((T) portatilRandom());
                    break;
                case 14:
                    add((T) televisorRandom());
                    break;
                case 15:
                    add((T) bazarRandom());
                    break;
                case 16:
                    add((T) escritorioRandom());
                    break;
                case 17:
                    add((T) sillonRandom());
                    break;
            }
        }
    }
}




