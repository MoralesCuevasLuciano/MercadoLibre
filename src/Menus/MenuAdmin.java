package Menus;

import models.ArrayList.AdministradorList;
import models.Herramienta.HerramientaElectrica;
import models.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MenuAdmin extends JFrame {
    private AdministradorList administrador = new AdministradorList();
    private boolean ventanaProductos = false;

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
        btnVerProductos.addActionListener(e -> verProductos());

        JButton btnConsultar = new JButton("Consultar");
        //btnConsultar.addActionListener(new ActionListener() {});

        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.addActionListener(e -> agregarProducto());

        JButton btnEditar = new JButton("Editar Producto");
        //btnEditar.addActionListener(new ActionListener() {});

        panelBotones.add(btnVerProductos);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);

        add(panelBotones, BorderLayout.CENTER);

    }

    private <T extends Producto> void verProductos(){

        if (ventanaProductos){
            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta");
            return;
        }

        JFrame frame = new JFrame("Lista de Productos");
        frame.setSize(650,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
//        frame.setResizable(false);

        // Panel vacío para la región WEST
        JPanel panelVacioOeste = new JPanel();
        panelVacioOeste.setPreferredSize(new Dimension(50, 600)); // Ancho de 150px
        frame.add(panelVacioOeste, BorderLayout.WEST);

        // Panel vacío para la región EAST
        JPanel panelVacioEste = new JPanel();
        panelVacioEste.setPreferredSize(new Dimension(50, 600)); // Ancho de 150px
        frame.add(panelVacioEste, BorderLayout.EAST);

        // Panel vacío para la región SOUTH

        JPanel panelVacioSur = new JPanel();
        panelVacioSur.setPreferredSize(new Dimension(650, 30));
        frame.add(panelVacioSur, BorderLayout.SOUTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(administrador.size(),1,30,20));

        JScrollPane scrollPane = new JScrollPane(panelBotones);
        frame.add(scrollPane, BorderLayout.CENTER);

        if (administrador.getProductos().isEmpty()){

            JButton mensajeVacio = new JButton("No hay existencia de productos");
            mensajeVacio.setFont(new Font("Arial", Font.BOLD, 30));
            mensajeVacio.setEnabled(false);
            panelBotones.add(mensajeVacio);
        }else {
            administrador.recorrerAdmin(panelBotones);
        }

        ventanaProductos = true;

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Cuando se cierre la ventana, actualizar la variable booleana
                ventanaProductos = false;
            }
        });


    }

    private void agregarProducto(){
        JFrame frame = new JFrame("Agregar Producto");
        frame.setSize(650,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        JPanel panelVacioOeste = new JPanel();
        panelVacioOeste.setPreferredSize(new Dimension(50, 600));
        frame.add(panelVacioOeste, BorderLayout.WEST);

        JPanel panelVacioEste = new JPanel();
        panelVacioEste.setPreferredSize(new Dimension(50, 600));
        frame.add(panelVacioEste, BorderLayout.EAST);

        JPanel panelVacioSur = new JPanel();
        panelVacioSur.setPreferredSize(new Dimension(650, 30));
        frame.add(panelVacioSur, BorderLayout.SOUTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6,1,30,20));
        frame.add(panelBotones, BorderLayout.CENTER);

        JLabel titulo = new JLabel("Seleccione categoria", JLabel.CENTER);
        panelBotones.add(titulo);

        JButton herramientas = new JButton("Herramientas");
        herramientas.addActionListener(e -> agregarHerramienta());
        panelBotones.add(herramientas);

        JButton hogar = new JButton("Hogar");
        panelBotones.add(hogar);

        JButton Juguetes = new JButton("Juguetes");
        panelBotones.add(Juguetes);

        JButton ropa = new JButton("Ropa");
        panelBotones.add(ropa);

        JButton tecnologia = new JButton("Tecnología");
        panelBotones.add(tecnologia);

    }

    private void agregarHerramienta(){
        JFrame frame = new JFrame("Seleccione tipo");
        frame.setSize(350,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        JPanel panelVacioOeste = new JPanel();
        panelVacioOeste.setPreferredSize(new Dimension(50, 300));
        frame.add(panelVacioOeste, BorderLayout.WEST);

        JPanel panelVacioEste = new JPanel();
        panelVacioEste.setPreferredSize(new Dimension(50, 300));
        frame.add(panelVacioEste, BorderLayout.EAST);

        JPanel panelVacioSur = new JPanel();
        panelVacioSur.setPreferredSize(new Dimension(350, 30));
        frame.add(panelVacioSur, BorderLayout.SOUTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3,1,30,20));
        frame.add(panelBotones, BorderLayout.CENTER);

        JButton electrica = new JButton("Electrica");
        electrica.addActionListener(e->crearProducto("Electrica"));
        panelBotones.add(electrica);

        JButton manual = new JButton("Manual");
        panelBotones.add(manual);

        JButton insumo = new JButton("Insumo");
        panelBotones.add(insumo);



    }

    private void crearProducto(String tipo){
        JFrame frame = new JFrame("Crear Producto");
        frame.setSize(650,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        JPanel panelVacioOeste = new JPanel();
        panelVacioOeste.setPreferredSize(new Dimension(50, 600));
        frame.add(panelVacioOeste, BorderLayout.WEST);

        JPanel panelVacioEste = new JPanel();
        panelVacioEste.setPreferredSize(new Dimension(50, 600));
        frame.add(panelVacioEste, BorderLayout.EAST);

        JPanel panelVacioSur = new JPanel();
        panelVacioSur.setPreferredSize(new Dimension(650, 30));
        frame.add(panelVacioSur, BorderLayout.SOUTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(10,1,30,20));
        frame.add(panelBotones, BorderLayout.CENTER);

        JLabel nombre = new JLabel("Nombre");
        panelBotones.add(nombre);

        JTextField nombreTexto = new JTextField();
        panelBotones.add(nombreTexto);

        JLabel stock = new JLabel("Stock");
        panelBotones.add(stock);

        JTextField stockTexto = new JTextField();
        panelBotones.add(stockTexto);

        JLabel precio = new JLabel("Precio");
        panelBotones.add(precio);

        JTextField precioTexto = new JTextField();
        panelBotones.add(precioTexto);

        JLabel marca  = new JLabel("Marca");
        panelBotones.add(marca);

        JTextField marcaTexto = new JTextField();
        panelBotones.add(marcaTexto);

        JLabel modelo = new JLabel("Modelo");
        panelBotones.add(modelo);

        JTextField modeloTexto = new JTextField();
        panelBotones.add(modeloTexto);





        switch (tipo){
            case "Electrica"-> {
                String esIn;
                JLabel voltaje = new JLabel("Voltaje");
                panelBotones.add(voltaje);

                JTextField voltajeTexto = new JTextField();
                panelBotones.add(voltajeTexto);

                JButton inalambrico = new JButton("Inalambrico");


                HerramientaElectrica hE = new HerramientaElectrica(
                        nombreTexto.getText(),
                        "codigornd",
                        Integer.parseInt(stockTexto.getText()),
                        Double.parseDouble(precioTexto.getText()),
                        marcaTexto.getText(),
                        modeloTexto.getText(),
                        Float.parseFloat(voltajeTexto.getText()),
                        true);


            }

        }
    }
}
