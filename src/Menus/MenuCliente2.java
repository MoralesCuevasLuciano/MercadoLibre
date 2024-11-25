package Menus;

import models.ArrayList.AdministradorList;
import models.Producto;
import models.Usuario.Cliente;
import models.ArrayList.CartMap;
import models.Usuario.ClientesList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static json.JsonClientes.serializarClientes;
import static json.JsonProductos.serializarProductos;

public class MenuCliente2 extends JFrame {

    private AdministradorList productos;
    private Cliente cliente;
    private CartMap carrito;
    private JFrame menuPpal;
    private  JLabel clientFooter;
    private ClientesList clientes;


    public MenuCliente2(AdministradorList productos, Cliente cliente, JFrame menuPpal, ClientesList clientes) {
        this.productos = productos;
        this.cliente = cliente;
        this.carrito = new CartMap();
        this.menuPpal = menuPpal;
        this.clientes = clientes;

        JFrame frame = new JFrame("Menu Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500); // Tamaño más amplio para mayor elegancia
        frame.setLayout(new BorderLayout());

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

        // Título con fuente moderna y elegante
        JLabel titulo = new JLabel("Menú Cliente", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 40)); // Fuente moderna, grande y profesional
        titulo.setForeground(new Color(50, 0, 100)); // Violeta oscuro
        fondo.add(titulo, BorderLayout.NORTH);

        clientFooter = new JLabel("Bienvenido   " + cliente.getNameClient() + "Saldo:    "  +cliente.getSaldo(), JLabel.CENTER);
        fondo.add(clientFooter, BorderLayout.SOUTH);

        // Mover el título hacia abajo con un margen
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        panelBotones.setOpaque(false); // Fondo transparente

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20); // Márgenes entre botones
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear los botones con expresiones lambda
        JButton btnVerProductos = crearBotonPersonalizado("Ver Productos", e -> verProductos());
        JButton btnVerCarrito = crearBotonPersonalizado("Ver Carrito", e -> verCarrito());
        JButton btnVerHistorial = crearBotonPersonalizado("Ver Historial de Compras", e -> verHistorial());
        JButton btnComprarCarrito = crearBotonPersonalizado("Comprar Carrito", e -> comprarCarrito());
        JButton btnAgregarSaldo =crearBotonPersonalizado("Agregar Saldo", e -> agregarSaldo());


        JButton btnVolver = crearBotonPersonalizado("Volver", e -> volver(frame));


        gbc.gridy = 0;
        panelBotones.add(btnVerProductos, gbc);
        gbc.gridy = 1;
        panelBotones.add(btnVerCarrito, gbc);
        gbc.gridy = 2;
        panelBotones.add(btnVerHistorial, gbc);
        gbc.gridy = 3;
        panelBotones.add(btnComprarCarrito, gbc);
        gbc.gridy = 4;
        panelBotones.add(btnAgregarSaldo, gbc);
        gbc.gridy = 5;
        panelBotones.add(btnVolver, gbc);



        fondo.add(panelBotones, BorderLayout.CENTER);

        frame.add(fondo);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JButton crearBotonPersonalizado(String texto, ActionListener actionListener) {
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

        boton.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente sans-serif moderna
        boton.setForeground(Color.BLACK); // Texto negro
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.setPreferredSize(new Dimension(300, 50)); // Máximo ancho de 10 cm
        boton.setContentAreaFilled(false);
        boton.addActionListener(actionListener);
        return boton;
    }

    private void volver(JFrame frameActual) {
        frameActual.dispose(); // Cierra la ventana actual
        menuPpal.setVisible(true); // Vuelve a mostrar el menú principal
    }


    // Método para mostrar los productos y permitir añadirlos al carrito
    private void verProductos() {
        // Crear el JFrame para "Ver Productos"
        String[] nombresClases = productos.obtenerNombresClases();
        JComboBox<String> comboBox = new JComboBox<>(nombresClases);

        int result = JOptionPane.showConfirmDialog(this, comboBox, "Seleccionar clase", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {

            String claseSeleccionada = (String) comboBox.getSelectedItem();
            String[] arreglo = productos.mostrarProductosClases2(claseSeleccionada);

            JFrame frameProductos = new JFrame("Ver Productos");
            frameProductos.setSize(400, 300);
            frameProductos.setLayout(new BorderLayout());

            // Crear un área con los productos y un JScrollPane
            JTextArea textAreaProductos = new JTextArea();
            textAreaProductos.setEditable(false);

            this.productos.mostrareFrame1(textAreaProductos,claseSeleccionada);

            JScrollPane scrollPane = new JScrollPane(textAreaProductos);
            frameProductos.add(scrollPane, BorderLayout.CENTER);

            // Botón para añadir productos al carrito
            JButton btnAgregarCarrito = new JButton("Añadir Producto al Carrito");
            JButton salirButton = new JButton("Salir");
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
                    if(p!=null) {
                        Prueba k = new Prueba(p.toString(), p, frameProductos, cliente);
                        k.mostrar();
                    }else{
                        JOptionPane.showMessageDialog(null,"El producto que buscas no existe en nuestra tienda");
                    }
                }
            });


            salirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frameProductos.dispose();// Cierra la ventana
                }
            });

            JPanel panelBotones = new JPanel();
            panelBotones.setLayout(new FlowLayout());
            panelBotones.add(btnAgregarCarrito);
            panelBotones.add(salirButton);

            frameProductos.add(panelBotones, BorderLayout.SOUTH);
            //* frameProductos.add(salirButton, BorderLayout.NORTH);

            frameProductos.setLocationRelativeTo(null);
            frameProductos.setVisible(true);
        }
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

        JButton salirButton = new JButton("Salir");
        salirButton.setPreferredSize(new Dimension(80, 30)); // Ajusta el tamaño del botón

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCarrito.dispose(); // Cierra la ventana
            }
        });

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
        // Crear un JPanel para el botón Salir y añadirlo al sur
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(salirButton);

        frameCarrito.add(panelBoton, BorderLayout.SOUTH);

        frameCarrito.setLocationRelativeTo(null);
        frameCarrito.setVisible(true);
    }

    // Método para mostrar el historial de compras
    private void verHistorial() {
        // Crear el JFrame para "Ver Historial de Compras"
        JFrame frameHistorial = new JFrame("Historial de Compras");
        frameHistorial.setSize(400, 300);
        frameHistorial.setLayout(new BorderLayout());

        JTextArea textAreaHistorial = new JTextArea();
        textAreaHistorial.setEditable(false);

        JButton salirButton = new JButton("Salir");
        salirButton.setPreferredSize(new Dimension(80, 30)); // Ajusta el tamaño del botón

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameHistorial.dispose(); // Cierra la ventana
            }
        });

        // Obtener las compras del historial y mostrarlas
        if (cliente.getHistorialCompras().getCompras().isEmpty()) {
            textAreaHistorial.setText("No hay compras en tu historial.");
        } else {
            for (String compra : cliente.getHistorialCompras().getCompras()) {
                textAreaHistorial.append(compra + "\n");
            }
        }

        JScrollPane scrollPane = new JScrollPane(textAreaHistorial);
        frameHistorial.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(salirButton);

        frameHistorial.add(panelBoton, BorderLayout.SOUTH);

        frameHistorial.setLocationRelativeTo(null);
        frameHistorial.setVisible(true);
    }

    // Método para realizar la compra del carrito
    private void comprarCarrito() {
        // Comprobar si el carrito está vacío
        if (this.cliente.getCarrito().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío. No se puede realizar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Comprobar si el cliente tiene saldo suficiente
        double totalCompra = cliente.getCarrito().totalPrecioCarrito();
        if (totalCompra > cliente.getSaldo()) {
            JOptionPane.showMessageDialog(this, "No tienes suficiente saldo para realizar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Realizar la compra (descontar saldo y vaciar el carrito)
        cliente.getCarrito().comprarCarrito1(cliente);
        cliente.getCarrito().eliminarCarrito();
        serializarProductos(this.productos);
        serializarClientes(clientes);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Su compra ha sido realizada con éxito. Total: $" + totalCompra + "\nMuchas gracias por su compra.");
    }


    public void agregarSaldo(){
        try {
            // Solicitar el monto a agregar
            String saldoStr = JOptionPane.showInputDialog(this, "Ingresa el monto a agregar a tu saldo:");

            // Validar entrada
            if (saldoStr == null || saldoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
                return;
            }

            mostrarVentanaTarjeta();

            double nuevoSaldo = Double.parseDouble(saldoStr);

            if (nuevoSaldo < 0) {
                JOptionPane.showMessageDialog(this, "El monto no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar el saldo del cliente
            cliente.saldo(cliente.getSaldo() + nuevoSaldo);
            clientFooter.setText("Bienvenido " + cliente.getNameClient() + "Saldo: "  +cliente.getSaldo());


            // Confirmación al usuario
            JOptionPane.showMessageDialog(this, "Saldo actualizado. Nuevo saldo: $" + cliente.getSaldo(), "Saldo Actualizado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarVentanaTarjeta() {
        // Crear el JDialog
        JDialog dialog = new JDialog(this, "Datos de la Tarjeta", true);
        dialog.setLayout(new GridLayout(4, 2));
        dialog.setSize(300, 150);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Campos para datos de la tarjeta
        JLabel lblNumeroTarjeta = new JLabel("Número de tarjeta:");
        JTextField txtNumeroTarjeta = new JTextField();

        JLabel lblFechaExpiracion = new JLabel("Fecha de expiración (MM/AA):");
        JTextField txtFechaExpiracion = new JTextField();

        JLabel lblCVV = new JLabel("CVV:");
        JTextField txtCVV = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");

        // Añadir componentes al JDialog
        dialog.add(lblNumeroTarjeta);
        dialog.add(txtNumeroTarjeta);

        dialog.add(lblFechaExpiracion);
        dialog.add(txtFechaExpiracion);

        dialog.add(lblCVV);
        dialog.add(txtCVV);

        dialog.add(new JLabel()); // Espacio vacío
        dialog.add(btnAceptar);

        // Acción del botón Aceptar
        btnAceptar.addActionListener(e -> dialog.dispose());

        // Mostrar el diálogo
        dialog.setLocationRelativeTo(this); // Centrar en la ventana principal
        dialog.setVisible(true);
    }
    public void mostrar() {
        setVisible(true);
    }

}