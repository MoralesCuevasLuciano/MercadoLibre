package Menus;

import models.ArrayList.AdministradorList;
import models.Excepciones.NoHayStock;
import models.Producto;
import models.Ropa.Remera;
import models.Usuario.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCliente extends JFrame {
    private Cliente cliente;
    private AdministradorList<Producto> productos;

    public MenuCliente(Cliente c, AdministradorList<Producto> l) {
        this.cliente = c;
        this.productos = l;

        // Configuración de la ventana principal
        setTitle("Menú Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1)); // Crear un diseño de cuadrícula de 4 filas

        // Crear los botones para cada opción del menú
        JButton btnVerProductos = new JButton("Ver productos");
        JButton btnVerCarrito = new JButton("Ver carrito");
        JButton btnComprar = new JButton("Comprar");
        JButton btnSalir = new JButton("Salir");
        JButton btnVerProducto = new JButton("Escoger producto");

        // Añadir botones a la ventana
        add(btnVerProductos);
        add(btnVerCarrito);
        add(btnVerProducto);
        add(btnComprar);
        add(btnSalir);


        // Acción para el botón "Ver productos"
        btnVerProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verProductos2(); // Llamar al método de mostrar productos
            }
        });

        btnVerProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarProducto();
            }
        });



        // Acción para el botón "Ver carrito"
        btnVerCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente.getCarrito().mostrarCarrito(); // Llamar al método de mostrar el carrito del cliente
            }
        });

        // Acción para el botón "Comprar"
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente.getCarrito().comprarCarrito(cliente); // Llamar al método de comprar
            }
        });

        // Acción para el botón "Salir"
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias por tu compra");
                dispose(); // Cerrar la ventana
            }
        });
    }

    // Método para mostrar el menú
    public void mostrar() {
        setVisible(true);
    }

    private void verProductos2() {
        // Suponiendo que tienes un arreglo de nombres de clases
        String[] nombresClases = productos.obtenerNombresClases();
        JComboBox<String> comboBox = new JComboBox<>(nombresClases);

        int result = JOptionPane.showConfirmDialog(this, comboBox, "Seleccionar clase", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String claseSeleccionada = (String) comboBox.getSelectedItem();
            String[] arreglo = productos.mostrarProductosClases2(claseSeleccionada);

            // Crear un JTextArea para mostrar los productos
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);  // Hacer que el área de texto no sea editable

            // Agregar los productos al JTextArea
            for (String producto : arreglo) {
                textArea.append(producto + "\n");  // Añadir cada producto en una nueva línea
            }

            // Crear un JScrollPane que envuelve el JTextArea
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Configurar el JScrollPane para que sea visible cuando el contenido sea más grande
            scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

            // Mostrar el mensaje con JScrollPane en un JOptionPane
            JOptionPane.showMessageDialog(this, scrollPane, "Productos de la clase " + claseSeleccionada, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void seleccionarProducto() {
        if (productos.size() == 0) {
            JOptionPane.showMessageDialog(this, "No hay productos disponibles.");
            return;
        }

        // Crear un JComboBox con los nombres de los productos
        String[] nombresProductos = productos.getNombresProductos();
        JComboBox<String> comboBox = new JComboBox<>(nombresProductos);

        // Mostrar el diálogo para seleccionar un producto
        int result = JOptionPane.showConfirmDialog(this, comboBox, "Seleccionar producto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String productoSeleccionado = (String) comboBox.getSelectedItem();
            Producto producto = productos.buscarProductoPorNombre(productoSeleccionado);

            if (producto != null) {
                // Solicitar cantidad al usuario
                String cantidadStr = JOptionPane.showInputDialog(this, "Ingresa la cantidad:");
                try {
                    int cantidad = Integer.parseInt(cantidadStr);
                    cliente.getCarrito().agregarAlCarrito(producto,cantidad);
                    JOptionPane.showMessageDialog(this, "Producto añadido al carrito.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Cantidad no válida.");
                } catch (NoHayStock e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
        }
    }
}

