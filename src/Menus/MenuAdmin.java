package Menus;

import models.ArrayList.AdministradorList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame {
    private AdministradorList administrador = new AdministradorList();

    public MenuAdmin(AdministradorList administrador) throws HeadlessException {
        this.administrador = administrador;

        setTitle("Mercado Libre Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,400);
        setLayout(new BorderLayout());
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel vacío para la región WEST
        JPanel panelVacioOeste = new JPanel();
        panelVacioOeste.setPreferredSize(new Dimension(50, 300)); // Ancho de 150px
        add(panelVacioOeste, BorderLayout.WEST);

        // Panel vacío para la región EAST
        JPanel panelVacioEste = new JPanel();
        panelVacioEste.setPreferredSize(new Dimension(50, 300)); // Ancho de 150px
        add(panelVacioEste, BorderLayout.EAST);

        // Panel vacío para la región SOUTH

        JPanel panelVacioSur = new JPanel();
        panelVacioSur.setPreferredSize(new Dimension(650, 30));
        add(panelVacioSur, BorderLayout.SOUTH);


        JLabel titulo = new JLabel("Menu Administrador", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        add(titulo, BorderLayout.NORTH);


        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4,1,10,20));

        JButton btnVerProductos = new JButton("Ver Productos");
        //btnVerProductos.addActionListener(new ActionListener() {});

        JButton btnConsultar = new JButton("Consultar");
        //btnConsultar.addActionListener(new ActionListener() {});

        JButton btnAgregar = new JButton("Agregar Producto");
        //btnAgregar.addActionListener(new ActionListener() {});

        JButton btnEditar = new JButton("Editar Producto");
        //btnEditar.addActionListener(new ActionListener() {});

        panelBotones.add(btnVerProductos);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);

        add(panelBotones, BorderLayout.CENTER);

    }
}
