package Menus;

import models.ArrayList.AdministradorList;
import models.Usuario.Cliente;
import models.Usuario.ClientesList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;


public class MenuPpal {

    private int opcion;
    private String nombre;
    private String contraseña;
    private AdministradorList productos;
    private Cliente cliente;
    private ClientesList clientes;


    public MenuPpal(AdministradorList productos, ClientesList clientes)  {

        this.productos = productos;
        this.clientes = clientes;

        JFrame menu = new JFrame("Mercado Libre");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(700, 400);
        menu.setLocationRelativeTo(null);
        menu.setLayout(new BorderLayout());
        menu.setResizable(false);
        menu.setVisible(true);

        // Fondo degradado
        JPanel fondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(240, 240, 255), 0, getHeight(), new Color(200, 200, 255));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        fondo.setLayout(new BorderLayout());

        // Título
        JLabel titulo = new JLabel("Menú Principal", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 40)); // Fuente moderna, grande y profesional
        titulo.setForeground(new Color(50, 0, 100)); // Violeta oscuro
        fondo.add(titulo, BorderLayout.NORTH);
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        // Panel de botones
        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(3, 1, 10, 10)); // Que los botones estén uno debajo del otro
        panelOpciones.setOpaque(false);

        // Botones con estilo personalizado
        JButton btnIngresarAdmin = crearBotonPersonalizado("Ingresar como Admin", e -> ingresoAdmin2(menu));
        JButton btnIngresarCliente = crearBotonPersonalizado("Ingresar como Cliente", e -> ingresoCliente(menu));

        // Agregar botones al panel
        panelOpciones.add(btnIngresarAdmin);
        panelOpciones.add(btnIngresarCliente);

        fondo.add(panelOpciones, BorderLayout.CENTER);

        // Información de autor
        JLabel lblNombre = new JLabel("- Lima Keila Ayelen" +
                " - Morales Luciano" +
                " - Llopart Manuel" +
                " - Moreno Richard Jesus" +
                " - Oviedo German -", JLabel.CENTER);
        fondo.add(lblNombre, BorderLayout.SOUTH);

        // Agregar el fondo al JFrame
        menu.add(fondo);

        // Panel vacío para la región WEST
        JPanel panelVacioOeste = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(240, 240, 255), 0, getHeight(), new Color(200, 200, 255));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelVacioOeste.setPreferredSize(new Dimension(100, 400)); // Ancho de 150px
        menu.add(panelVacioOeste, BorderLayout.WEST);

        // Panel vacío para la región EAST
        JPanel panelVacioEste = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(240, 240, 255), 0, getHeight(), new Color(200, 200, 255));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelVacioEste.setPreferredSize(new Dimension(100, 400)); // Ancho de 150px
        menu.add(panelVacioEste, BorderLayout.EAST);
    }

    // Método para crear botones personalizados
    private JButton crearBotonPersonalizado(String texto, java.awt.event.ActionListener actionListener) {
        JButton boton = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                // Degradado entre violeta y rojo
                GradientPaint gradient = new GradientPaint(0, 0, new Color(200, 180, 255), getWidth(), getHeight(), new Color(255, 100, 100));
                g2.setPaint(gradient);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };

        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setForeground(Color.BLACK); // Texto negro
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.setPreferredSize(new Dimension(375, 50));
        boton.setMaximumSize(new Dimension(375, 50));
        boton.setContentAreaFilled(false);
        boton.addActionListener(actionListener);
        return boton;
    }


    public MenuPpal(AdministradorList administrador) {
    }

    public static JFrame getMenuPpal() {
        return new JFrame();
    }

    private void ingresoCliente(JFrame menuppal){
        menuppal.setVisible(false);

        MenuCliente2 mCliente = new MenuCliente2(this.productos, menuppal,this.clientes);

    }

    private void ingresoAdmin2(JFrame menuppal){
        menuppal.setVisible(false);

        MenuAdmin mAdmin = new MenuAdmin(this.productos, menuppal);
    }

    private void ingresoAdmin(JFrame frame){//OPCION SI LLEGAMOS A HACER LOGEO

        //nombre = JOptionPane.showInputDialog(frame, "Ingresando como Admin");
        // Crear el panel para el login (usuario y contraseña)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2)); // Dos filas y dos columnas

        JLabel labelUsuario = new JLabel("Usuario:");
        JTextField textUsuario = new JTextField(20);

        JLabel labelContraseña = new JLabel("Contraseña:");
        JPasswordField passwordContraseña = new JPasswordField(20);

        panel.add(labelUsuario);
        panel.add(textUsuario);
        panel.add(labelContraseña);
        panel.add(passwordContraseña);

        // Mostrar el JOptionPane con el panel creado
        int option = JOptionPane.showConfirmDialog(frame, panel, "Iniciar Sesión", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    }



    public Integer getOpcion() {
        return opcion;
    }
}

