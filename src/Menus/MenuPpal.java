package Menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class MenuPpal extends JFrame {
    private int opcion;
    private String nombre;
    private String contraseña;
    private CountDownLatch latch;

    public MenuPpal()  {

        latch = new CountDownLatch(1);

        JFrame menu = new JFrame("Mercado Libre");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(700, 400);
        menu.setLocationRelativeTo(null);
        menu.setLayout(new BorderLayout());//Indico que quiero la disposicion de los elementos en 5 regiones
        menu.setResizable(false);
        menu.setVisible(true);

        JLabel titulo = new JLabel("Menu Principal", JLabel.CENTER); //quiero que el label este en el centro
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        menu.add(titulo, BorderLayout.NORTH);//quiero que me añada el titulo en la parte de arriba

        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(3,1,10,10));//Que me añada las cosas una al lado de la otra
        menu.add(panelOpciones, BorderLayout.CENTER);

        JButton btnIngresarAdmin = new JButton("Ingresar como Admin");
        btnIngresarAdmin.addActionListener(e -> ingresoAdmin2());
        panelOpciones.add(btnIngresarAdmin);

        JButton btnIngresarCliente = new JButton("Ingresar como Cliente");
        btnIngresarCliente.addActionListener(e -> ingresoCliente());
        panelOpciones.add(btnIngresarCliente);

        JLabel lblNombre = new JLabel("- Lima Keyla Ayelen" +
                " - Morales Luciano" +
                " - Llopart Manuel" +
                " - Moreno Richar Jesus" +
                " - Oviedo German -", JLabel.CENTER);
        menu.add(lblNombre, BorderLayout.SOUTH);


        // Panel vacío para la región WEST
        JPanel panelVacioOeste = new JPanel();
        panelVacioOeste.setPreferredSize(new Dimension(150, 400)); // Ancho de 150px
        menu.add(panelVacioOeste, BorderLayout.WEST);

        // Panel vacío para la región EAST
        JPanel panelVacioEste = new JPanel();
        panelVacioEste.setPreferredSize(new Dimension(150, 400)); // Ancho de 150px
        menu.add(panelVacioEste, BorderLayout.EAST);
        // Aquí bloqueamos el hilo principal hasta que el usuario complete el login
        try {
            latch.await(); // Espera hasta que el latch sea contado hacia abajo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    private void ingresoCliente(){
        this.opcion=2;
        latch.countDown();
    }
    private void ingresoAdmin2(){
        this.opcion=1;
        latch.countDown();
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
        latch.countDown();

    }

    public void mostrar(){
        setVisible(true);
    }

    public Integer getOpcion() {
        return opcion;
    }
}
