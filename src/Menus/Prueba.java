package Menus;

import models.ArrayList.AdministradorList;
import models.Excepciones.NoHayStock;
import models.Producto;
import models.Usuario.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prueba extends JFrame {
    private JPanel panelMain;
    private JTextArea productosTextArea;
    private JButton comprarButton;
    private JButton añadirButton;
    private JButton salirButton;
    private AdministradorList<Producto> productos;

    public Prueba(String verProducto, Producto p, JFrame frameProductos, Cliente c) {
        // Inicializa el panel si no fue generado automáticamente
        if (panelMain == null) {
            inicializarPanelMain();
        }

        setTitle("Producto");
        setSize(800, 400); // Ajusta el tamaño para visualizar correctamente
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Contenedor para centrar panelMain
        JPanel contenedorCentrado = new JPanel(new GridBagLayout());
        contenedorCentrado.add(panelMain); // Añade el panel principal al centro
        contenedorCentrado.setSize(200,600);

        setContentPane(contenedorCentrado); // Configura el contenedor como el contenido principal

        productosTextArea.setEditable(false);
        productosTextArea.setText("Lista de productos:\n" + verProducto);

        // Acción del botón Añadir
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirAlCarrito(p, frameProductos, c);
            }
        });

        // Acción del botón Comprar
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productosTextArea.append("¡Compra realizada con éxito!\n");
            }
        });

        // Acción del botón Salir
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana
            }
        });

        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    private void inicializarPanelMain() {
        panelMain = new JPanel(); // Crea el panel principal
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

        productosTextArea = new JTextArea(10, 50); // Área de texto
        JScrollPane scrollPane = new JScrollPane(productosTextArea);
        panelMain.add(scrollPane);

        JPanel buttonPanel = new JPanel(); // Panel para los botones
        añadirButton = new JButton("Añadir");
        comprarButton = new JButton("Comprar");
        salirButton = new JButton("Salir");

        buttonPanel.add(añadirButton);
        buttonPanel.add(comprarButton);
        buttonPanel.add(salirButton);
        panelMain.add(buttonPanel);
    }

    public void mostrar() {
        setVisible(true);
    }

    public void añadirAlCarrito(Producto p, JFrame frameProductos, Cliente c) {
        if (p != null) {
            String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad:");
            int cantidad = Integer.parseInt(cantidadStr);
            try {
                c.getCarrito().agregarAlCarrito(p, cantidad);
                dispose();
                JOptionPane.showMessageDialog(this, "Producto agregado con éxito");
            } catch (NoHayStock ex) {
                JOptionPane.showMessageDialog(frameProductos, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(frameProductos, "Producto no encontrado.", "Carrito", JOptionPane.ERROR_MESSAGE, null);
        }
    }
}
