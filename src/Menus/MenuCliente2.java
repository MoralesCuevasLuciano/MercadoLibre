package Menus;

import models.ArrayList.AdministradorList;
import models.Excepciones.NoHayStock;
import models.Producto;
import models.Usuario.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuCliente2 extends JFrame {


    // Simular las listas de productos y carrito
    private AdministradorList productos;
    private Cliente cliente;

    public MenuCliente2(AdministradorList productos, Cliente cliente) {
        this.productos = productos; // Inicializar productos
        this.cliente = cliente;     // Inicializar cliente

        // Resto del código para configurar el JFrame principal...
        JFrame frame = new JFrame("Menu Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Menu Cliente", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 1, 10, 10));

        JButton btnVerProductos = new JButton("Ver Productos");
        btnVerProductos.addActionListener(e -> verProductos());

        JButton btnVerCarrito = new JButton("Ver Carrito");
        btnVerCarrito.addActionListener(e -> verCarrito());

        panelBotones.add(btnVerProductos);
        panelBotones.add(btnVerCarrito);

        frame.add(panelBotones, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Método para mostrar los productos y permitir añadirlos al carrito
    private void verProductos() {
        // Crear el JFrame para "Ver Productos"
        JFrame frameProductos = new JFrame("Ver Productos");
        frameProductos.setSize(400, 300);
        frameProductos.setLayout(new BorderLayout());

        // Crear un área con los productos y un JScrollPane
        JTextArea textAreaProductos = new JTextArea();
        textAreaProductos.setEditable(false);

        for (Object producto : this.productos.getProductos()) {
            textAreaProductos.append(producto + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textAreaProductos);
        frameProductos.add(scrollPane, BorderLayout.CENTER);

        // Botón para añadir productos al carrito
        JButton btnAgregarCarrito = new JButton("Añadir Producto al Carrito");
        btnAgregarCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombreProducto = JOptionPane.showInputDialog(
                        frameProductos,
                        "Ingrese el nombre del producto a añadir:",
                        "Añadir Producto",
                        JOptionPane.PLAIN_MESSAGE
                );
                Producto p = productos.buscarProductoPorNombre(nombreProducto);
                if (p != null) {
                    String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad:");
                    int cantidad = Integer.parseInt(cantidadStr);
                    try {
                        cliente.getCarrito().agregarAlCarrito(p,cantidad);
                    } catch (NoHayStock ex) {
                        System.out.println(ex.getMessage());
                    }
                    JOptionPane.showMessageDialog(frameProductos, "Producto añadido al carrito.");
                } else {
                    JOptionPane.showMessageDialog(frameProductos, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frameProductos.add(btnAgregarCarrito, BorderLayout.SOUTH);

        frameProductos.setLocationRelativeTo(null);
        frameProductos.setVisible(true);
    }

    // Método para mostrar el carrito
    private void verCarrito() {
        // Crear el JFrame para "Ver Carrito"
        JFrame frameCarrito = new JFrame("Carrito de Cliente");
        frameCarrito.setSize(400, 300);
        frameCarrito.setLayout(new BorderLayout());

        // Crear un área con los productos del carrito y un JScrollPane
        JTextArea textAreaCarrito = new JTextArea();
        textAreaCarrito.setEditable(false);

        if (cliente.getCarrito().isEmpty()) {
            textAreaCarrito.setText("El carrito está vacío.");
        } else {
            for (Map.Entry<Producto, Integer> entry : cliente.getCarrito().entrySet()) {
                Producto producto = entry.getKey();
                int cantidad = entry.getValue();
                textAreaCarrito.append(
                        "Producto: " + producto.getNombre() +
                                ", Precio: $" + producto.getPrecio() +
                                ", Cantidad: " + cantidad + "\n"
                );
            }
        }
        JScrollPane scrollPane = new JScrollPane(textAreaCarrito);
        frameCarrito.add(scrollPane, BorderLayout.CENTER);

        frameCarrito.setLocationRelativeTo(null);
        frameCarrito.setVisible(true);
    }

    public void mostrar() {
        setVisible(true);
    }

}
