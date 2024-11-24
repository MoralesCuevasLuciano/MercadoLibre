package Menus;

import enums.*;
import models.ArrayList.AdministradorList;
import models.Herramienta.HerramientaElectrica;
import models.Herramienta.HerramientaManual;
import models.Herramienta.Insumo;
import models.Hogar.Bazar;
import models.Hogar.Escritorio;
import models.Hogar.Sillon;
import models.Juguete.JugueteElectrico;
import models.Juguete.JugueteManual;
import models.Producto;

import javax.swing.*;
import java.awt.*;

import static json.JsonProductos.serializarProductos;

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
        btnAgregar.addActionListener(e -> agregarProducto1());

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
            panelBotones.setLayout(new GridLayout(14,1,30,20));
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
                    inalambrico.addActionListener(e-> esInalambrico[0] = true);
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
                case "Buzo"-> {

                }
                case "Calzado"-> {}
                case "Pantalon"-> {}
                case "Remera"-> {}
                case "Celular"-> {}
                case "Computadora"-> {}
                case "PC de escritorio"-> {}
                case "Portatil"-> {}
                case "Televisor"-> {}


            }
        }

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
