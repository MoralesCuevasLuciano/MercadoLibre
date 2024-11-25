package Menus;

import enums.*;
import models.ArrayList.AdministradorList;
import models.Herramienta.HerramientaElectrica;
import models.Herramienta.HerramientaManual;
import models.Herramienta.Insumo;
import models.Hogar.Bazar;
import models.Hogar.Escritorio;
import models.Hogar.Sillon;
import models.Juguete.JuegoDeMesa;
import models.Juguete.JugueteElectrico;
import models.Juguete.JugueteManual;
import models.Producto;
import models.Ropa.Buzo;
import models.Ropa.Calzado;
import models.Ropa.Pantalon;
import models.Ropa.Remera;
import models.Tecnologia.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static json.JsonProductos.serializarProductos;

public class MenuAdmin extends JFrame {
    private AdministradorList administrador = new AdministradorList();
    private boolean ventanaProductos = false;
    private JFrame MenuPpal;

    public MenuAdmin(AdministradorList administrador, JFrame menuPpal) throws HeadlessException {
        this.administrador = administrador;
        this.MenuPpal = menuPpal;

        setTitle("Mercado Libre Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,450);
        setLayout(new BorderLayout());
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);


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
        JLabel titulo = new JLabel("Menú Administrador", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 40)); // Fuente moderna, grande y profesional
        titulo.setForeground(new Color(50, 0, 100)); // Violeta oscuro
        fondo.add(titulo, BorderLayout.NORTH);
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));



        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        panelBotones.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear botones con expresiones lambda
        JButton btnVerProductos = crearBotonPersonalizado("Ver Productos", e -> verProductos());
        JButton btnConsultar = crearBotonPersonalizado("Consultar", e -> buscarYeditarProducto()); //, e -> consultar()
        JButton btnAgregar = crearBotonPersonalizado("Agregar Producto", e -> agregarProducto1());
        JButton btnEliminar = crearBotonPersonalizado("Dar de baja Producto", e -> buscarYeliminarProducto());
        JButton btnVolver = crearBotonPersonalizado("Volver", e -> volverAlMenuPrincipal());

        // Agregar botones al panel
        gbc.gridy = 0;
        panelBotones.add(btnVerProductos, gbc);
        gbc.gridy = 1;
        panelBotones.add(btnConsultar, gbc);
        gbc.gridy = 2;
        panelBotones.add(btnAgregar, gbc);
        gbc.gridy = 3;
        panelBotones.add(btnEliminar, gbc);
        gbc.gridy = 4;
        panelBotones.add(btnVolver, gbc);

        fondo.add(panelBotones, BorderLayout.CENTER);
        add(fondo);
        setVisible(true);
    }

    private void volverAlMenuPrincipal() {
        this.MenuPpal.setVisible(true); // Muestra el menú principal
        setVisible(false);
    }

    // Método para crear botones personalizados con degradado
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

        boton.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente moderna
        boton.setForeground(Color.BLACK); // Texto negro
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.setPreferredSize(new Dimension(300, 50));
        boton.setContentAreaFilled(false);
        boton.addActionListener(actionListener);
        return boton;
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
        //frame.setResizable(false);

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
            serializarProductos(administrador);
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

    /**CLASE DE EDITAR PRODUCTO DE PRUEBA. CREO QUE FUNCIONAAAAAAAAAA*/
    private void buscarYeditarProducto(){

        String nombreProducto = JOptionPane.showInputDialog(
                this,
                "Ingrese el nombre del producto:",
                "Buscar Producto",
                JOptionPane.PLAIN_MESSAGE
        );
        Producto p = administrador.buscarProductoPorNombre(nombreProducto);
        if(p!=null) {
            JFrame frame = new JFrame("Producto");
            frame.setSize(650,400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            JPanel panelVacioOeste = new JPanel();
            panelVacioOeste.setPreferredSize(new Dimension(50, 400));
            frame.add(panelVacioOeste, BorderLayout.WEST);

            JPanel panelVacioEste = new JPanel();
            panelVacioEste.setPreferredSize(new Dimension(50, 400));
            frame.add(panelVacioEste, BorderLayout.EAST);

            JPanel panelVacioSur = new JPanel();
            panelVacioSur.setPreferredSize(new Dimension(650, 45));
            frame.add(panelVacioSur, BorderLayout.SOUTH);

            JPanel panelBotones = new JPanel();
            panelBotones.setLayout(new GridLayout(1,1,30,20));

            JTextArea producto = new JTextArea();
            producto.setEditable(false);
            producto.setText(p.toString());
            panelBotones.add(producto);

            JScrollPane scrollPane = new JScrollPane(panelBotones);
            frame.add(scrollPane, BorderLayout.CENTER);

            JButton editar = new JButton("Editar");
            editar.setFont(new Font("Arial", Font.BOLD, 20));
            editar.addActionListener(e->administrador.editAction(p));
            serializarProductos(administrador);
            panelVacioSur.add(editar);

        }else{
            JOptionPane.showMessageDialog(null,"El producto que buscas no existe en nuestra tienda");
        }

    }
    
    private void buscarYeliminarProducto(){
        String nombreProducto = JOptionPane.showInputDialog(
                this,
                "Ingrese el nombre del producto:",
                "Buscar Producto",
                JOptionPane.PLAIN_MESSAGE
        );
        Producto p = administrador.buscarProductoPorNombre(nombreProducto);
        if(p!=null) {
            JFrame frame = new JFrame("Producto");
            frame.setSize(650,400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            JPanel panelVacioOeste = new JPanel();
            panelVacioOeste.setPreferredSize(new Dimension(50, 400));
            frame.add(panelVacioOeste, BorderLayout.WEST);

            JPanel panelVacioEste = new JPanel();
            panelVacioEste.setPreferredSize(new Dimension(50, 400));
            frame.add(panelVacioEste, BorderLayout.EAST);

            JPanel panelVacioSur = new JPanel();
            panelVacioSur.setPreferredSize(new Dimension(650, 45));
            frame.add(panelVacioSur, BorderLayout.SOUTH);

            JPanel panelBotones = new JPanel();
            panelBotones.setLayout(new GridLayout(1,1,30,20));

            JTextArea producto = new JTextArea();
            producto.setEditable(false);
            producto.setText(p.toString());
            panelBotones.add(producto);

            JScrollPane scrollPane = new JScrollPane(panelBotones);
            frame.add(scrollPane, BorderLayout.CENTER);

            JButton borrar = new JButton("Borrar");
            borrar.setFont(new Font("Arial", Font.BOLD, 20));
            borrar.addActionListener(e->{administrador.remove(p);
            frame.dispose();});
            serializarProductos(administrador);
            panelVacioSur.add(borrar);

        }else{
            JOptionPane.showMessageDialog(null,"El producto que buscas no existe en nuestra tienda");
        }
    }
    private void agregarProducto1(){
        String[] nombresClases = {"Herramienta Electrica", "Herramienta Manual", "Insumo",
        "Bazar", "Escritorio", "Sillon",
        "Juego De Mesa", "Juguete Electrico", "Juguete Manual",
        "Buzo", "Calzado", "Pantalon", "Remera",
        "Celular", "Computadora", "PC de escritorio", "Portatil", "Televisor"};
        JComboBox<String> comboBox = new JComboBox<>(nombresClases);

        int result = JOptionPane.showConfirmDialog(this, comboBox, "Seleccionar clase", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION){
            String claseSeleccionado = comboBox.getSelectedItem().toString();
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
            panelBotones.setLayout(new GridLayout(15,1,30,20));
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





            switch (claseSeleccionado){
                case "Herramienta Electrica"-> {
                    final boolean[] esInalambrico = {false};
                    JLabel voltaje = new JLabel("Voltaje");
                    panelBotones.add(voltaje);

                    JTextField voltajeTexto = new JTextField();
                    panelBotones.add(voltajeTexto);

                    JButton inalambrico = new JButton("Inalambrico");
                    inalambrico.setBackground(Color.RED);
                    inalambrico.addActionListener(e->{
                        esInalambrico[0] = !esInalambrico[0];
                        if (esInalambrico[0]){
                            inalambrico.setBackground(Color.GREEN);
                        }else {
                            inalambrico.setBackground(Color.RED);
                        }
                    });
                    panelBotones.add(inalambrico);






                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || voltajeTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            HerramientaElectrica hE = new HerramientaElectrica(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    Float.parseFloat(voltajeTexto.getText()),
                                    esInalambrico[0]);
                            administrador.add(hE);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });



                }
                case "Herramienta Manual"-> {
                    JLabel uso = new JLabel("Uso");
                    panelBotones.add(uso);

                    JComboBox<CategoriasHerramientas> comboBox1 = new JComboBox<>(new CategoriasHerramientas[]{CategoriasHerramientas.CORTAR,
                            CategoriasHerramientas.TALADRAR,
                            CategoriasHerramientas.SUJETAR,
                            CategoriasHerramientas.MEDIR,
                            CategoriasHerramientas.GOLPEAR,
                            CategoriasHerramientas.ATORNILLAR,
                            CategoriasHerramientas.AJUSTAR,
                            CategoriasHerramientas.LIMAR,
                            CategoriasHerramientas.PULIR});
                    panelBotones.add(comboBox1);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            HerramientaManual hM = new HerramientaManual(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    (CategoriasHerramientas) comboBox1.getSelectedItem());
                            administrador.add(hM);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                }
                case "Insumo"-> {
                    JLabel tipoDeMaterial = new JLabel("Tipo de Material");
                    panelBotones.add(tipoDeMaterial);

                    JComboBox<MaterialInsumo> comboBox1 = new JComboBox<>(new MaterialInsumo[]{MaterialInsumo.MADERA,
                            MaterialInsumo.METAL,
                            MaterialInsumo.PLASTICO,
                            MaterialInsumo.CONCRETO,
                            MaterialInsumo.VIDRIO,
                            MaterialInsumo.CERAMICA,
                            MaterialInsumo.YESO});
                    panelBotones.add(comboBox1);

                    JLabel largo = new JLabel("Largo");
                    panelBotones.add(largo);

                    JTextField largoTexto = new JTextField();
                    panelBotones.add(largoTexto);

                    JLabel ancho = new JLabel("Ancho");
                    panelBotones.add(ancho);

                    JTextField anchoTexto = new JTextField();
                    panelBotones.add(anchoTexto);



                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Insumo insumo = new Insumo(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    (MaterialInsumo) comboBox1.getSelectedItem(), Float.parseFloat(largoTexto.getText()), Float.parseFloat(anchoTexto.getText()), 0);
                            administrador.add(insumo);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                }
                case "Bazar"-> {
                    final boolean[] resistCalor = {false};

                    JLabel categoria = new JLabel("Categoria");
                    panelBotones.add(categoria);
                    JComboBox<CategoriasHogar> combobox = new JComboBox<>(new CategoriasHogar[]{CategoriasHogar.COCINA,
                            CategoriasHogar.BAÑO,
                            CategoriasHogar.JARDIN,
                            CategoriasHogar.LAVANDERIA,
                            CategoriasHogar.ELECTRODOMESTICOS,
                            CategoriasHogar.DECORACION,
                            });
                    panelBotones.add(combobox);

                    JLabel uso = new JLabel("Uso");
                    panelBotones.add(uso);
                    JComboBox<UsoHogar> comboBox1 = new JComboBox<>(new UsoHogar[]{UsoHogar.DECORACION,
                            UsoHogar.COMER,
                            UsoHogar.LIMPIAR,
                            UsoHogar.COCINAR,
                            UsoHogar.LAVAR,
                            UsoHogar.ORGANIZAR,
                            UsoHogar.ALMACENAR,
                            UsoHogar.CUIDADO_HOGAR,
                            UsoHogar.CUIDADO_PERSONAL,
                            UsoHogar.OTRO});
                    panelBotones.add(comboBox1);


                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JTextField materialTexto = new JTextField();
                    panelBotones.add(materialTexto);

                    JLabel tamanio = new JLabel("Tamaño");
                    panelBotones.add(tamanio);

                    JComboBox<TamañoBazar> comboBox2 = new JComboBox<>(new TamañoBazar[]{TamañoBazar.PEQUEÑO,
                            TamañoBazar.GRANDE,
                    TamañoBazar.MEDIANO,
                    TamañoBazar.HONDO,
                    TamañoBazar.LLANO});
                    panelBotones.add(comboBox2);

                    JButton resistenteAlCalor = new JButton("Resistente al calor");
                    resistenteAlCalor.setBackground(Color.RED);
                    resistenteAlCalor.addActionListener(e->{
                        resistCalor[0] = !resistCalor[0];
                        if (resistCalor[0]){
                            resistenteAlCalor.setBackground(Color.GREEN);
                        }else {
                            resistenteAlCalor.setBackground(Color.RED);
                        }
                        });

                        panelBotones.add(resistenteAlCalor);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Bazar insumo = new Bazar(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    (CategoriasHogar) combobox.getSelectedItem(),
                                    (UsoHogar) comboBox1.getSelectedItem(),
                                    materialTexto.getText(),
                                    (TamañoBazar) comboBox2.getSelectedItem(),
                                    resistCalor[0]);

                            administrador.add(insumo);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                }
                case "Escritorio"-> {
                    final boolean[] cajones = {false};

                    JLabel categoria = new JLabel("Categoria");
                    panelBotones.add(categoria);
                    JComboBox<CategoriasHogar> combobox = new JComboBox<>(new CategoriasHogar[]{CategoriasHogar.COCINA,
                            CategoriasHogar.BAÑO,
                            CategoriasHogar.JARDIN,
                            CategoriasHogar.LAVANDERIA,
                            CategoriasHogar.ELECTRODOMESTICOS,
                            CategoriasHogar.DECORACION,
                    });
                    panelBotones.add(combobox);

                    JLabel uso = new JLabel("Uso");
                    panelBotones.add(uso);
                    JComboBox<UsoHogar> comboBox1 = new JComboBox<>(new UsoHogar[]{UsoHogar.DECORACION,
                            UsoHogar.COMER,
                            UsoHogar.LIMPIAR,
                            UsoHogar.COCINAR,
                            UsoHogar.LAVAR,
                            UsoHogar.ORGANIZAR,
                            UsoHogar.ALMACENAR,
                            UsoHogar.CUIDADO_HOGAR,
                            UsoHogar.CUIDADO_PERSONAL,
                            UsoHogar.OTRO});
                    panelBotones.add(comboBox1);


                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JTextField materialTexto = new JTextField();
                    panelBotones.add(materialTexto);

                    JLabel numeroDePuertas = new JLabel("Capacidad");
                    panelBotones.add(numeroDePuertas);

                    JTextField capacidad = new JTextField();
                    panelBotones.add(capacidad);

                    JLabel estilo = new JLabel("Estilo");
                    panelBotones.add(estilo);

                    JComboBox<EstiloMueble> comboBox2 = new JComboBox<>(new EstiloMueble[]{EstiloMueble.OFICINA
                            ,EstiloMueble.SALA
                            ,EstiloMueble.LIVING});
                    panelBotones.add(comboBox2);

                    JButton tieneCajones = new JButton("Tiene cajones");
                    tieneCajones.setBackground(Color.RED);
                    tieneCajones.addActionListener(e->{
                        cajones[0] = !cajones[0];
                        if (cajones[0]){
                            tieneCajones.setBackground(Color.GREEN);
                        }else {
                            tieneCajones.setBackground(Color.RED);
                        }
                    });
                    panelBotones.add(tieneCajones);




                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                    if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                            precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                            modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null || comboBox.getSelectedItem()==null || comboBox2.getSelectedItem()==null) {
                        JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                        try {
                            Escritorio escritorio = new Escritorio(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    (CategoriasHogar) combobox.getSelectedItem(),
                                    (UsoHogar) comboBox1.getSelectedItem(),
                                    materialTexto.getText(),
                                    Integer.parseInt(capacidad.getText()),
                                    (EstiloMueble) comboBox2.getSelectedItem(),
                                    1,
                                    cajones[0]);
                            administrador.add(escritorio);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });





                }
                case "Sillon"-> {
                    JLabel categoria = new JLabel("Categoria");
                    panelBotones.add(categoria);
                    JComboBox<CategoriasHogar> combobox = new JComboBox<>(new CategoriasHogar[]{CategoriasHogar.COCINA,
                            CategoriasHogar.BAÑO,
                            CategoriasHogar.JARDIN,
                            CategoriasHogar.LAVANDERIA,
                            CategoriasHogar.ELECTRODOMESTICOS,
                            CategoriasHogar.DECORACION,
                    });
                    panelBotones.add(combobox);

                    JLabel uso = new JLabel("Uso");
                    panelBotones.add(uso);
                    JComboBox<UsoHogar> comboBox1 = new JComboBox<>(new UsoHogar[]{UsoHogar.DECORACION,
                            UsoHogar.COMER,
                            UsoHogar.LIMPIAR,
                            UsoHogar.COCINAR,
                            UsoHogar.LAVAR,
                            UsoHogar.ORGANIZAR,
                            UsoHogar.ALMACENAR,
                            UsoHogar.CUIDADO_HOGAR,
                            UsoHogar.CUIDADO_PERSONAL,
                            UsoHogar.OTRO});
                    panelBotones.add(comboBox1);


                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JTextField materialTexto = new JTextField();
                    panelBotones.add(materialTexto);

                    JLabel numeroDePuertas = new JLabel("Capacidad");
                    panelBotones.add(numeroDePuertas);

                    JTextField capacidad = new JTextField();
                    panelBotones.add(capacidad);

                    JLabel estilo = new JLabel("Estilo");
                    panelBotones.add(estilo);

                    JComboBox<EstiloMueble> comboBox2 = new JComboBox<>(new EstiloMueble[]{EstiloMueble.OFICINA
                            ,EstiloMueble.SALA
                            ,EstiloMueble.LIVING});
                    panelBotones.add(comboBox2);

                    JLabel ancho = new JLabel("Ancho");
                    panelBotones.add(ancho);

                    JTextField anchoTexto = new JTextField();
                    panelBotones.add(anchoTexto);

                    JLabel alto = new JLabel("Alto");
                    panelBotones.add(alto);

                    JTextField altoTexto = new JTextField();
                    panelBotones.add(altoTexto);

                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null ||
                                comboBox.getSelectedItem()==null || comboBox2.getSelectedItem()==null||
                                anchoTexto.getText().isEmpty() || altoTexto.getText().isEmpty() ||
                                colorTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Sillon sillon = new Sillon(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    (CategoriasHogar) combobox.getSelectedItem(),
                                    (UsoHogar) comboBox1.getSelectedItem(),
                                    materialTexto.getText(),
                                    Integer.parseInt(capacidad.getText()),
                                    (EstiloMueble) comboBox2.getSelectedItem(),
                                    Float.parseFloat(anchoTexto.getText()),
                                    Float.parseFloat(altoTexto.getText()),
                                    colorTexto.getText());
                            administrador.add(sillon);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });

                }
                case "Juguete Electrico"-> {
                    JLabel edad = new JLabel("Edad");
                    panelBotones.add(edad);

                    JTextField edadTexto = new JTextField();
                    panelBotones.add(edadTexto);

                    JLabel categoria = new JLabel("Categoria");
                    panelBotones.add(categoria);

                    JComboBox<CategoriaJuguete> comboBox1 = new JComboBox<>(new CategoriaJuguete[]{CategoriaJuguete.EDUCATIVO,
                            CategoriaJuguete.CONSTRUCCION,
                            CategoriaJuguete.PELUCHES,
                            CategoriaJuguete.VEHICULOS,
                            CategoriaJuguete.DEPORTIVO,
                            CategoriaJuguete.MUÑECAS,
                            CategoriaJuguete.MUSICAL,
                            CategoriaJuguete.JUEGOS_DE_MESA});
                    panelBotones.add(comboBox1);

                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JComboBox<MaterialJuguete> comboBox2 = new JComboBox<>(new MaterialJuguete[]{MaterialJuguete.MADERA,
                            MaterialJuguete.METAL,
                            MaterialJuguete.PLASTICO,
                            MaterialJuguete.TELA,
                            MaterialJuguete.GOMA,
                            MaterialJuguete.CARTON,
                            MaterialJuguete.PAPEL,
                            MaterialJuguete.ESPUMA});
                    panelBotones.add(comboBox2);

                    JLabel pilas = new JLabel("Pilas");
                    panelBotones.add(pilas);

                    JTextField pilasTexto = new JTextField();
                    panelBotones.add(pilasTexto);

                    JLabel voltaje = new JLabel("Voltaje");
                    panelBotones.add(voltaje);

                    JTextField voltajeTexto = new JTextField();
                    panelBotones.add(voltajeTexto);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null ||
                                comboBox.getSelectedItem()==null || comboBox2.getSelectedItem()==null ||
                                pilasTexto.getText().isEmpty() || voltajeTexto.getText().isEmpty() ||
                                edadTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            JugueteElectrico jugueteElectrico = new JugueteElectrico(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    Integer.parseInt(edadTexto.getText()),
                                    (CategoriaJuguete) comboBox1.getSelectedItem(),
                                    (MaterialJuguete) comboBox2.getSelectedItem(),
                                    Integer.parseInt(pilasTexto.getText()),
                                    Float.parseFloat(voltajeTexto.getText()));
                            administrador.add(jugueteElectrico);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                }
                case "Juguete Manual"-> {
                    JLabel edad = new JLabel("Edad");
                    panelBotones.add(edad);

                    JTextField edadTexto = new JTextField();
                    panelBotones.add(edadTexto);

                    JLabel categoria = new JLabel("Categoria");
                    panelBotones.add(categoria);

                    JComboBox<CategoriaJuguete> comboBox1 = new JComboBox<>(new CategoriaJuguete[]{CategoriaJuguete.EDUCATIVO,
                            CategoriaJuguete.CONSTRUCCION,
                            CategoriaJuguete.PELUCHES,
                            CategoriaJuguete.VEHICULOS,
                            CategoriaJuguete.DEPORTIVO,
                            CategoriaJuguete.MUÑECAS,
                            CategoriaJuguete.MUSICAL,
                            CategoriaJuguete.JUEGOS_DE_MESA});
                    panelBotones.add(comboBox1);

                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JComboBox<MaterialJuguete> comboBox2 = new JComboBox<>(new MaterialJuguete[]{MaterialJuguete.MADERA,
                            MaterialJuguete.METAL,
                            MaterialJuguete.PLASTICO,
                            MaterialJuguete.TELA,
                            MaterialJuguete.GOMA,
                            MaterialJuguete.CARTON,
                            MaterialJuguete.PAPEL,
                            MaterialJuguete.ESPUMA});
                    panelBotones.add(comboBox2);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null ||
                                comboBox.getSelectedItem()==null || comboBox2.getSelectedItem()==null ||
                                edadTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            JugueteManual jugueteManual = new JugueteManual(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    Integer.parseInt(edadTexto.getText()),
                                    (CategoriaJuguete) comboBox1.getSelectedItem(),
                                    (MaterialJuguete) comboBox2.getSelectedItem()
                                    );
                            administrador.add(jugueteManual);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });


                }
                case "Juego De Mesa"-> {
                    JLabel edad = new JLabel("Edad");
                    panelBotones.add(edad);

                    JTextField edadTexto = new JTextField();
                    panelBotones.add(edadTexto);

                    JLabel categoria = new JLabel("Categoria");
                    panelBotones.add(categoria);

                    JComboBox<CategoriaJuguete> comboBox1 = new JComboBox<>(new CategoriaJuguete[]{CategoriaJuguete.EDUCATIVO,
                            CategoriaJuguete.CONSTRUCCION,
                            CategoriaJuguete.PELUCHES,
                            CategoriaJuguete.VEHICULOS,
                            CategoriaJuguete.DEPORTIVO,
                            CategoriaJuguete.MUÑECAS,
                            CategoriaJuguete.MUSICAL,
                            CategoriaJuguete.JUEGOS_DE_MESA});
                    panelBotones.add(comboBox1);

                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JComboBox<MaterialJuguete> comboBox2 = new JComboBox<>(new MaterialJuguete[]{MaterialJuguete.MADERA,
                            MaterialJuguete.METAL,
                            MaterialJuguete.PLASTICO,
                            MaterialJuguete.TELA,
                            MaterialJuguete.GOMA,
                            MaterialJuguete.CARTON,
                            MaterialJuguete.PAPEL,
                            MaterialJuguete.ESPUMA});
                    panelBotones.add(comboBox2);

                    JLabel cantJugadores = new JLabel("Cantidad de jugadores");
                    panelBotones.add(cantJugadores);

                    JTextField cantJugadoresTexto = new JTextField();
                    panelBotones.add(cantJugadoresTexto);

                    JLabel duracion = new JLabel("Duración");
                    panelBotones.add(duracion);

                    JTextField duracionTexto = new JTextField();
                    panelBotones.add(duracionTexto);


                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null ||
                                comboBox.getSelectedItem()==null || comboBox2.getSelectedItem()==null ||
                                edadTexto.getText().isEmpty() || cantJugadoresTexto.getText().isEmpty() ||
                                duracionTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            JuegoDeMesa juegoDeMesa = new JuegoDeMesa(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    Integer.parseInt(edadTexto.getText()),
                                    (CategoriaJuguete) comboBox1.getSelectedItem(),
                                    (MaterialJuguete) comboBox2.getSelectedItem(),
                                    Integer.parseInt(cantJugadoresTexto.getText()),
                                    Integer.parseInt(duracionTexto.getText()));
                            administrador.add(juegoDeMesa);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });

                }
                case "Buzo"-> {
                    final boolean[] capucha = {false};
                    final boolean[] cierre = {false};
                    final boolean[] bolsillos = {false};
                    final boolean[] estampado = {false};
                    final boolean[] impermeable = {false};

                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JLabel genero = new JLabel("Genero");
                    panelBotones.add(genero);

                    JComboBox<Genero> comboBox1 = new JComboBox<>(new Genero[]{Genero.MASCULINO,
                            Genero.FEMENINO,
                            Genero.UNISEX});
                    panelBotones.add(comboBox1);

                    JLabel talle = new JLabel("Talle");
                    panelBotones.add(talle);

                    JComboBox<TalleRemera> comboBox2 = new JComboBox<>(new TalleRemera[]{TalleRemera.XS,
                            TalleRemera.S,
                            TalleRemera.M,
                            TalleRemera.L,
                            TalleRemera.XL,
                            TalleRemera.XXL});
                    panelBotones.add(comboBox2);

                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JTextField materialTexto = new JTextField();
                    panelBotones.add(materialTexto);

                    JButton tieneCapucha = new JButton("Tiene capucha");
                    tieneCapucha.setBackground(Color.RED);
                    tieneCapucha.addActionListener(e->{
                        capucha[0] = !capucha[0];
                        if (capucha[0]){
                            tieneCapucha.setBackground(Color.GREEN);
                        }else {
                            tieneCapucha.setBackground(Color.RED);
                        }
                    });

                    panelBotones.add(tieneCapucha);

                    JButton tieneCierre = new JButton("Tiene cierre");
                    tieneCierre.setBackground(Color.RED);
                    tieneCierre.addActionListener(e->{
                        cierre[0] = !cierre[0];
                        if (cierre[0]){
                            tieneCierre.setBackground(Color.GREEN);
                        }else {
                            tieneCierre.setBackground(Color.RED);
                        }
                    });
                    panelBotones.add(tieneCierre);

                    JButton tieneBolsillos = new JButton("Tiene bolsillos");
                    tieneBolsillos.setBackground(Color.RED);
                    tieneBolsillos.addActionListener(e->{
                        bolsillos[0] = !bolsillos[0];
                        if (bolsillos[0]){
                            tieneBolsillos.setBackground(Color.GREEN);
                        }else {
                            tieneBolsillos.setBackground(Color.RED);
                        }
                    });
                    panelBotones.add(tieneBolsillos);

                    JButton tieneEstampado = new JButton("Tiene estampado");
                    tieneEstampado.setBackground(Color.RED);
                    tieneEstampado.addActionListener(e->{
                        estampado[0] = !estampado[0];
                        if (estampado[0]){
                            tieneEstampado.setBackground(Color.GREEN);
                        }else {
                            tieneEstampado.setBackground(Color.RED);
                        }
                    });
                    panelBotones.add(tieneEstampado);

                    JButton esImpermeable = new JButton("Es impermeable");
                    esImpermeable.setBackground(Color.RED);
                    esImpermeable.addActionListener(e->{
                        impermeable[0] = !impermeable[0];
                        if (impermeable[0]){
                            esImpermeable.setBackground(Color.GREEN);
                        }else {
                            esImpermeable.setBackground(Color.RED);
                        }
                    });
                    panelBotones.add(esImpermeable);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null ||
                                comboBox.getSelectedItem()==null || comboBox2.getSelectedItem()==null ||
                                colorTexto.getText().isEmpty() || materialTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Buzo buzo = new Buzo(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    colorTexto.getText(),
                                    (Genero) comboBox1.getSelectedItem(),
                                    (TalleRemera) comboBox2.getSelectedItem(),
                                    materialTexto.getText(),
                                    capucha[0],
                                    cierre[0],
                                    bolsillos[0],
                                    estampado[0],
                                    impermeable[0]);
                            administrador.add(buzo);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });



                }
                case "Calzado"-> {
                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JLabel genero = new JLabel("Genero");
                    panelBotones.add(genero);

                    JComboBox<Genero> comboBox1 = new JComboBox<>(new Genero[]{Genero.MASCULINO,
                            Genero.FEMENINO,
                            Genero.UNISEX});
                    panelBotones.add(comboBox1);

                    JLabel talle = new JLabel("Talle");
                    panelBotones.add(talle);

                    JComboBox<TalleRemera> comboBox2 = new JComboBox<>(new TalleRemera[]{TalleRemera.XS,
                            TalleRemera.S,
                            TalleRemera.M,
                            TalleRemera.L,
                            TalleRemera.XL,
                            TalleRemera.XXL});
                    panelBotones.add(comboBox2);

                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JTextField materialTexto = new JTextField();
                    panelBotones.add(materialTexto);

                    JLabel tipo = new JLabel("Tipo");
                    panelBotones.add(tipo);

                    JComboBox<TipoCalzado> comboBox3 = new JComboBox<>(new TipoCalzado[]{TipoCalzado.ZAPATILLA,
                            TipoCalzado.BOTIN,
                            TipoCalzado.BOTA,
                            TipoCalzado.SANDALIA,
                            TipoCalzado.OJOTA,
                            TipoCalzado.ZAPATO,
                            TipoCalzado.MOCASIN,
                            TipoCalzado.ZAPATILLA,
                            TipoCalzado.CROCS,
                            TipoCalzado.CHINELA,
                            TipoCalzado.BORCEGO,
                            TipoCalzado.CHINELA,
                            TipoCalzado.ALPARGATA,
                            TipoCalzado.CHATITA,
                            TipoCalzado.PANCHAS,
                            TipoCalzado.ZUECO,
                            TipoCalzado.BAILARINA,
                            TipoCalzado.NÁUTICO,
                            TipoCalzado.ROLLERS,
                            TipoCalzado.PATINES}
                    );
                    panelBotones.add(comboBox3);

                    JLabel uso = new JLabel("Uso");
                    panelBotones.add(uso);

                    JComboBox<UsoCalzadoPantalon> comboBox4 = new JComboBox<>(new UsoCalzadoPantalon[]{UsoCalzadoPantalon.CASUAL,
                            UsoCalzadoPantalon.DEPORTIVO,
                            UsoCalzadoPantalon.FORMAL,
                            UsoCalzadoPantalon.CASUAL});
                    panelBotones.add(comboBox4);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null ||
                                comboBox.getSelectedItem()==null || comboBox2.getSelectedItem()==null ||
                                colorTexto.getText().isEmpty() || materialTexto.getText().isEmpty() ||
                                comboBox3.getSelectedItem()==null || comboBox4.getSelectedItem()==null) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Calzado calzado = new Calzado(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    colorTexto.getText(),
                                    (Genero) comboBox1.getSelectedItem(),
                                    (TalleRemera) comboBox2.getSelectedItem(),
                                    materialTexto.getText(),
                                    (TipoCalzado) comboBox3.getSelectedItem(),
                                    (UsoCalzadoPantalon) comboBox4.getSelectedItem());
                            administrador.add(calzado);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });

                }
                case "Pantalon"-> {
                    final boolean[] cierre = {false};
                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JLabel genero = new JLabel("Genero");
                    panelBotones.add(genero);

                    JComboBox<Genero> comboBox1 = new JComboBox<>(new Genero[]{Genero.MASCULINO,
                            Genero.FEMENINO,
                            Genero.UNISEX});
                    panelBotones.add(comboBox1);

                    JLabel talle = new JLabel("Talle");
                    panelBotones.add(talle);

                    JComboBox<TalleRemera> comboBox2 = new JComboBox<>(new TalleRemera[]{TalleRemera.XS,
                            TalleRemera.S,
                            TalleRemera.M,
                            TalleRemera.L,
                            TalleRemera.XL,
                            TalleRemera.XXL});
                    panelBotones.add(comboBox2);

                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JTextField materialTexto = new JTextField();
                    panelBotones.add(materialTexto);

                    JLabel cantidadBolsillos = new JLabel("Cantidad de bolsillos");
                    panelBotones.add(cantidadBolsillos);

                    JTextField cantidadBolsillosTexto = new JTextField();
                    panelBotones.add(cantidadBolsillosTexto);

                    JLabel estilo = new JLabel("Estilo");
                    panelBotones.add(estilo);

                    JTextField estiloTexto = new JTextField();
                    panelBotones.add(estiloTexto);

                    JLabel uso = new JLabel("Uso");
                    panelBotones.add(uso);

                    JComboBox<UsoCalzadoPantalon> comboBox4 = new JComboBox<>(new UsoCalzadoPantalon[]{UsoCalzadoPantalon.CASUAL,
                            UsoCalzadoPantalon.DEPORTIVO,
                            UsoCalzadoPantalon.FORMAL,
                            UsoCalzadoPantalon.CASUAL});
                    panelBotones.add(comboBox4);

                    JButton tieneCierre = new JButton("Tiene cierre");
                    tieneCierre.setBackground(Color.RED);
                    tieneCierre.addActionListener(e->{
                        cierre[0] = !cierre[0];
                        if (cierre[0]){
                            tieneCierre.setBackground(Color.GREEN);
                        }else {
                            tieneCierre.setBackground(Color.RED);
                        }
                    });
                    panelBotones.add(tieneCierre);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null ||
                                comboBox.getSelectedItem()==null || comboBox2.getSelectedItem()==null ||
                                colorTexto.getText().isEmpty() || materialTexto.getText().isEmpty() ||
                                cantidadBolsillosTexto.getText().isEmpty() || estiloTexto.getText().isEmpty() ||
                                comboBox4.getSelectedItem()==null) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Pantalon pantalon = new Pantalon(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    colorTexto.getText(),
                                    (Genero) comboBox1.getSelectedItem(),
                                    (TalleRemera) comboBox2.getSelectedItem(),
                                    materialTexto.getText(),
                                    Integer.parseInt(cantidadBolsillosTexto.getText()),
                                    estiloTexto.getText(),
                                    (UsoCalzadoPantalon) comboBox4.getSelectedItem(),
                                    cierre[0]);
                            administrador.add(pantalon);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });

                }
                case "Remera"-> {
                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JLabel genero = new JLabel("Genero");
                    panelBotones.add(genero);

                    JComboBox<Genero> comboBox1 = new JComboBox<>(new Genero[]{Genero.MASCULINO,
                            Genero.FEMENINO,
                            Genero.UNISEX});
                    panelBotones.add(comboBox1);

                    JLabel talle = new JLabel("Talle");
                    panelBotones.add(talle);

                    JComboBox<TalleRemera> comboBox2 = new JComboBox<>(new TalleRemera[]{TalleRemera.XS,
                            TalleRemera.S,
                            TalleRemera.M,
                            TalleRemera.L,
                            TalleRemera.XL,
                            TalleRemera.XXL});
                    panelBotones.add(comboBox2);

                    JLabel material = new JLabel("Material");
                    panelBotones.add(material);

                    JTextField materialTexto = new JTextField();
                    panelBotones.add(materialTexto);

                    JLabel tipoDeRemera = new JLabel("Tipo de remera");
                    panelBotones.add(tipoDeRemera);

                    JComboBox<TipoDeRemera> comboBox3 = new JComboBox<>(new TipoDeRemera[]{TipoDeRemera.MANGACORTA,
                            TipoDeRemera.MANGALARGA,
                            TipoDeRemera.MANGA3_4});
                    panelBotones.add(comboBox3);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || comboBox1.getSelectedItem()==null ||
                                comboBox.getSelectedItem()==null || comboBox2.getSelectedItem()==null ||
                                colorTexto.getText().isEmpty() || materialTexto.getText().isEmpty() ||
                                comboBox3.getSelectedItem()==null) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Remera remera = new Remera(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    colorTexto.getText(),
                                    (Genero) comboBox1.getSelectedItem(),
                                    (TalleRemera) comboBox2.getSelectedItem(),
                                    materialTexto.getText(),
                                    (TipoDeRemera) comboBox3.getSelectedItem(),
                                    (TalleRemera) comboBox2.getSelectedItem());
                            administrador.add(remera);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });

                }
                case "Celular"-> {
                    JLabel peso = new JLabel("Peso");
                    panelBotones.add(peso);

                    JTextField pesoTexto = new JTextField();
                    panelBotones.add(pesoTexto);

                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JLabel anio = new JLabel("Año");
                    panelBotones.add(anio);

                    JTextField anioTexto = new JTextField();
                    panelBotones.add(anioTexto);

                    JLabel sOCelular = new JLabel("Sistema Operativo");
                    panelBotones.add(sOCelular);

                    JComboBox<SOCelular> soCelularJComboBox = new JComboBox<>(new SOCelular[]{SOCelular.ANDROID,
                    SOCelular.IOS,
                    SOCelular.BLACKBERRY,
                    SOCelular.SYMBIAN,
                    SOCelular.WINDOWS_PHONE});
                    panelBotones.add(soCelularJComboBox);

                    JLabel duracionBateria = new JLabel("Duracion de la bateria");
                    panelBotones.add(duracionBateria);

                    JTextField duracionBateriaTexto = new JTextField();
                    panelBotones.add(duracionBateriaTexto);

                    JLabel tamanioPantalla = new JLabel("Tamaño de Pantalla");
                    panelBotones.add(tamanioPantalla);

                    JTextField tamanioPantallaTexto = new JTextField();
                    panelBotones.add(tamanioPantallaTexto);

                    JLabel procesador = new JLabel("Procesador");
                    panelBotones.add(procesador);

                    JTextField procesadorTexto = new JTextField();
                    panelBotones.add(procesadorTexto);

                    JLabel ram = new JLabel("Ram");
                    panelBotones.add(ram);

                    JTextField ramTexto = new JTextField();
                    panelBotones.add(ramTexto);

                    JLabel capacidad = new JLabel("Capacidad");
                    panelBotones.add(capacidad);

                    JTextField capacidadTexto = new JTextField();
                    panelBotones.add(capacidadTexto);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || soCelularJComboBox.getSelectedItem()==null ||
                                colorTexto.getText().isEmpty() || pesoTexto.getText().isEmpty() ||
                                anioTexto.getText().isEmpty() || duracionBateriaTexto.getText().isEmpty()||
                                tamanioPantallaTexto.getText().isEmpty() || procesadorTexto.getText().isEmpty() ||
                                ramTexto.getText().isEmpty() || capacidadTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Celular celular = new Celular(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    Float.parseFloat(pesoTexto.getText()),
                                    colorTexto.getText(),
                                    Integer.parseInt(anioTexto.getText()),
                                    (SOCelular) soCelularJComboBox.getSelectedItem(),
                                    Integer.parseInt(duracionBateriaTexto.getText()),
                                    Float.parseFloat(tamanioPantallaTexto.getText()),
                                    procesadorTexto.getText(),
                                    Integer.parseInt(ramTexto.getText()),
                                    Integer.parseInt(capacidadTexto.getText())
                                    );
                            administrador.add(celular);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    });



                }
                case "Computadora"-> {
                    JLabel peso = new JLabel("Peso");
                    panelBotones.add(peso);

                    JTextField pesoTexto = new JTextField();
                    panelBotones.add(pesoTexto);

                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JLabel anio = new JLabel("Año");
                    panelBotones.add(anio);

                    JTextField anioTexto = new JTextField();
                    panelBotones.add(anioTexto);

                    JLabel soComputadora = new JLabel("Sistema operativo");
                    panelBotones.add(soComputadora);

                    JComboBox<SOComputadora> soComputadoraJComboBox = new JComboBox<SOComputadora>(new SOComputadora[]{
                            SOComputadora.LINUX,
                            SOComputadora.MACOS,
                            SOComputadora.WINDOWS,
                            SOComputadora.UBUNTU
                    });
                    panelBotones.add(soComputadoraJComboBox);

                    JLabel procesador = new JLabel("Procesador");
                    panelBotones.add(procesador);

                    JTextField procesadorTexto = new JTextField();
                    panelBotones.add(procesadorTexto);

                    JLabel ram = new JLabel("Ram");
                    panelBotones.add(ram);

                    JTextField ramTexto = new JTextField();
                    panelBotones.add(ramTexto);

                    JLabel capacidad = new JLabel("Capacidad");
                    panelBotones.add(capacidad);

                    JTextField capacidadTexto = new JTextField();
                    panelBotones.add(capacidadTexto);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || colorTexto.getText().isEmpty() ||
                                pesoTexto.getText().isEmpty() || (SOComputadora)soComputadoraJComboBox.getSelectedItem()==null||
                                anioTexto.getText().isEmpty() ||procesadorTexto.getText().isEmpty() ||
                                ramTexto.getText().isEmpty() || capacidadTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Computadora computadora = new Computadora(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    Float.parseFloat(pesoTexto.getText()),
                                    colorTexto.getText(),
                                    Integer.parseInt(anioTexto.getText()),
                                    (SOComputadora) soComputadoraJComboBox.getSelectedItem(),
                                    procesadorTexto.getText(),
                                    Integer.parseInt(ramTexto.getText()),
                                    Integer.parseInt(capacidadTexto.getText())
                            ) {
                            };
                            administrador.add(computadora);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });


                }
                case "PC de escritorio"-> {
                    JLabel peso = new JLabel("Peso");
                    panelBotones.add(peso);

                    JTextField pesoTexto = new JTextField();
                    panelBotones.add(pesoTexto);

                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JLabel anio = new JLabel("Año");
                    panelBotones.add(anio);

                    JTextField anioTexto = new JTextField();
                    panelBotones.add(anioTexto);

                    JLabel soComputadora = new JLabel("Sistema operativo");
                    panelBotones.add(soComputadora);

                    JComboBox<SOComputadora> soComputadoraJComboBox = new JComboBox<SOComputadora>(new SOComputadora[]{
                            SOComputadora.LINUX,
                            SOComputadora.MACOS,
                            SOComputadora.WINDOWS,
                            SOComputadora.UBUNTU
                    });
                    panelBotones.add(soComputadoraJComboBox);

                    JLabel procesador = new JLabel("Procesador");
                    panelBotones.add(procesador);

                    JTextField procesadorTexto = new JTextField();
                    panelBotones.add(procesadorTexto);

                    JLabel ram = new JLabel("Ram");
                    panelBotones.add(ram);

                    JTextField ramTexto = new JTextField();
                    panelBotones.add(ramTexto);

                    JLabel capacidad = new JLabel("Capacidad");
                    panelBotones.add(capacidad);

                    JTextField capacidadTexto = new JTextField();
                    panelBotones.add(capacidadTexto);

                    JLabel fuente = new JLabel("Fuente");
                    panelBotones.add(fuente);

                    JTextField fuenteTexto = new JTextField();
                    panelBotones.add(fuenteTexto);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || colorTexto.getText().isEmpty() ||
                                pesoTexto.getText().isEmpty() || (SOComputadora)soComputadoraJComboBox.getSelectedItem()==null||
                                anioTexto.getText().isEmpty() ||procesadorTexto.getText().isEmpty() ||
                                ramTexto.getText().isEmpty() || capacidadTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            PC_Escritorio pcEscritorio = new PC_Escritorio(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    Float.parseFloat(pesoTexto.getText()),
                                    colorTexto.getText(),
                                    Integer.parseInt(anioTexto.getText()),
                                    (SOComputadora) soComputadoraJComboBox.getSelectedItem(),
                                    procesadorTexto.getText(),
                                    Integer.parseInt(ramTexto.getText()),
                                    Integer.parseInt(capacidadTexto.getText()),
                                    "Gabinete",
                                    Float.parseFloat(fuenteTexto.getText())
                            ) {
                            };
                            administrador.add(pcEscritorio);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });

                }
                case "Portatil"-> {
                    JLabel peso = new JLabel("Peso");
                    panelBotones.add(peso);

                    JTextField pesoTexto = new JTextField();
                    panelBotones.add(pesoTexto);

                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JLabel anio = new JLabel("Año");
                    panelBotones.add(anio);

                    JTextField anioTexto = new JTextField();
                    panelBotones.add(anioTexto);

                    JLabel soComputadora = new JLabel("Sistema operativo");
                    panelBotones.add(soComputadora);

                    JComboBox<SOComputadora> soComputadoraJComboBox = new JComboBox<SOComputadora>(new SOComputadora[]{
                            SOComputadora.LINUX,
                            SOComputadora.MACOS,
                            SOComputadora.WINDOWS,
                            SOComputadora.UBUNTU
                    });
                    panelBotones.add(soComputadoraJComboBox);

                    JLabel procesador = new JLabel("Procesador");
                    panelBotones.add(procesador);

                    JTextField procesadorTexto = new JTextField();
                    panelBotones.add(procesadorTexto);

                    JLabel ram = new JLabel("Ram");
                    panelBotones.add(ram);

                    JTextField ramTexto = new JTextField();
                    panelBotones.add(ramTexto);

                    JLabel capacidad = new JLabel("Capacidad");
                    panelBotones.add(capacidad);

                    JTextField capacidadTexto = new JTextField();
                    panelBotones.add(capacidadTexto);

                    JLabel tamanio = new JLabel("Tamaño");
                    panelBotones.add(tamanio);

                    JTextField tamanioText = new JTextField();
                    panelBotones.add(tamanioText);

                    JLabel duracionBateria = new JLabel("Duracion Bateria");
                    panelBotones.add(duracionBateria);

                    JTextField duracionBateriaTexto = new JTextField();
                    panelBotones.add(duracionBateriaTexto);

                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || colorTexto.getText().isEmpty() ||
                                pesoTexto.getText().isEmpty() || (SOComputadora)soComputadoraJComboBox.getSelectedItem()==null||
                                anioTexto.getText().isEmpty() ||procesadorTexto.getText().isEmpty() ||
                                ramTexto.getText().isEmpty() || capacidadTexto.getText().isEmpty() ||
                                tamanioText.getText().isEmpty() || duracionBateriaTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Portatil portatil = new Portatil(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    Float.parseFloat(pesoTexto.getText()),
                                    colorTexto.getText(),
                                    Integer.parseInt(anioTexto.getText()),
                                    (SOComputadora) soComputadoraJComboBox.getSelectedItem(),
                                    procesadorTexto.getText(),
                                    Integer.parseInt(ramTexto.getText()),
                                    Integer.parseInt(capacidadTexto.getText()),
                                    Integer.parseInt(tamanioText.getText()),
                                    Float.parseFloat(duracionBateriaTexto.getText())
                            ) {
                            };
                            administrador.add(portatil);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                }
                case "Televisor"-> {
                    final boolean[] smart = {false};
                    JLabel peso = new JLabel("Peso");
                    panelBotones.add(peso);

                    JTextField pesoTexto = new JTextField();
                    panelBotones.add(pesoTexto);

                    JLabel color = new JLabel("Color");
                    panelBotones.add(color);

                    JTextField colorTexto = new JTextField();
                    panelBotones.add(colorTexto);

                    JLabel anio = new JLabel("Año");
                    panelBotones.add(anio);

                    JTextField anioTexto = new JTextField();
                    panelBotones.add(anioTexto);

                    JLabel tipoTelevisor = new JLabel("Tipo Televisor");
                    panelBotones.add(tipoTelevisor);

                    JComboBox<TipoTelevisor> tipoTelevisorJComboBox = new JComboBox<>(new TipoTelevisor[]{
                            TipoTelevisor.LCD,
                            TipoTelevisor.LED,
                            TipoTelevisor.OLED,
                            TipoTelevisor.AMOLED,
                            TipoTelevisor.QLED
                    });
                    panelBotones.add(tipoTelevisorJComboBox);

                    JLabel tamanio = new JLabel("Tamaño");
                    panelBotones.add(tamanio);

                    JTextField tamanioTexto = new JTextField();
                    panelBotones.add(tamanioTexto);

                    JButton tieneCajones = new JButton("Es smart");
                    tieneCajones.setBackground(Color.RED);
                    tieneCajones.addActionListener(e->{
                        smart[0] = !smart[0];
                        if (smart[0]){
                            tieneCajones.setBackground(Color.GREEN);
                        }else {
                            tieneCajones.setBackground(Color.RED);
                        }
                    });
                    panelBotones.add(tieneCajones);


                    JButton guardar = new JButton("Guardar");
                    panelBotones.add(guardar);
                    guardar.addActionListener(e ->{
                        if (nombreTexto.getText().isEmpty() || stockTexto.getText().isEmpty() ||
                                precioTexto.getText().isEmpty() || marcaTexto.getText().isEmpty() ||
                                modeloTexto.getText().isEmpty() || colorTexto.getText().isEmpty() ||
                                pesoTexto.getText().isEmpty() || tipoTelevisorJComboBox.getSelectedItem()==null||
                                anioTexto.getText().isEmpty() ||tamanioTexto.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try{
                            Televisor televisor = new Televisor(
                                    nombreTexto.getText(),
                                    "codigornd",
                                    Integer.parseInt(stockTexto.getText()),
                                    Double.parseDouble(precioTexto.getText()),
                                    marcaTexto.getText(),
                                    modeloTexto.getText(),
                                    Float.parseFloat(pesoTexto.getText()),
                                    colorTexto.getText(),
                                    Integer.parseInt(anioTexto.getText()),
                                    smart[0],
                                    (TipoTelevisor) tipoTelevisorJComboBox.getSelectedItem(),
                                    Integer.parseInt(tamanioTexto.getText())
                                    );

                            administrador.add(televisor);
                            serializarProductos(administrador);
                            JOptionPane.showMessageDialog(frame, "Producto guardado exitosamente");
                            frame.dispose();
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(frame, "Datos inválidos. Intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });

                }


            }
        }

    }
}
