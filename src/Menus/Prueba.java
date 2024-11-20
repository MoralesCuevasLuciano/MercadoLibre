package Menus;

import models.ArrayList.AdministradorList;
import models.Producto;
import models.Usuario.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prueba extends JFrame {
    private JPanel panelMain;
    private JTextArea productosTextArea;
    private JButton comprarButton;
    private JButton añadirButton;
    private JButton salirButton;
    private AdministradorList<Producto> productos;
    private Cliente cliente;

    public Prueba() {
        setTitle("Producto");
        setSize(800, 80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelMain);


        productosTextArea.setEditable(false);
        productosTextArea.setText("Lista de productos:\n");

        // Acción del botón Añadir
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productosTextArea.append("Producto añadido: EjemploProducto\n");
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
    }

    public void mostrar() {
        setVisible(true);
    }

    public static void main(String[] args) {
        Prueba ventana = new Prueba();
        ventana.mostrar();
    }
}