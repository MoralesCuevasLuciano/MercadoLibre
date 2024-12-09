import Menus.*;
import models.ArrayList.AdministradorList;
import models.Herramienta.Herramienta;
import models.Herramienta.HerramientaElectrica;
import models.Herramienta.HerramientaManual;
import models.Juguete.JuegoDeMesa;
import models.Producto;
import models.Usuario.Cliente;
import models.Usuario.ClientesList;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static json.JsonClientes.deserializarClientes;
import static json.JsonClientes.serializarClientes;
import static json.JsonProductos.deserializarProductos;
import static json.JsonProductos.serializarProductos;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int opcion;
    public static void main(String[] args) {

        ClientesList<Cliente> clientes = deserializarClientes();
        //clientes.cargarClientesRandom(10);
        serializarClientes(clientes);
        // Inicializar el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            AdministradorList<Producto> productos = deserializarProductos();
            //productos.cargarProductosRandom2(500);
            serializarProductos(productos);


            MenuPpal menuPpal = new MenuPpal(productos,clientes);
            clientes.showAllClients();
            compareCollections(10000);

        });
    }

    private static void compareCollections(int numProductos) {
        // Comparar List: ArrayList vs Vector vs Deque

        System.out.println("Comparación de List:");
        compareList(numProductos);

        // Comparar Set: HashSet vs LinkedHashSet vs TreeSet
        System.out.println("\nComparación de Set:");
        compareSet(numProductos);

        // Comparar Map: HashMap vs LinkedHashMap vs TreeMap
        System.out.println("\nComparación de Map:");
        compareMap(numProductos);
    }

    // Método para crear productos de prueba
    private static Producto createProducto(int index) {
        HerramientaElectrica a = HerramientaElectrica.herramientaElectricaRandom();
        return a;
    }

    // Método para comparar ArrayList, Vector y Deque
    private static void compareList(int numProductos) {
        long startTime, endTime;

        // ArrayList
        List<Producto> arrayList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numProductos; i++) {
            arrayList.add(createProducto(i));
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList: Tiempo de carga: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        Producto lastElementArrayList = arrayList.get(arrayList.size() - 1);
        endTime = System.nanoTime();
        System.out.println("ArrayList: Tiempo de búsqueda del último elemento: " + (endTime - startTime) / 1e6 + " ms");

        // Vector
        List<Producto> vector = new Vector<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numProductos; i++) {
            vector.add(createProducto(i));
        }
        endTime = System.nanoTime();
        System.out.println("Vector: Tiempo de carga: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        Producto lastElementVector = vector.get(vector.size() - 1);
        endTime = System.nanoTime();
        System.out.println("Vector: Tiempo de búsqueda del último elemento: " + (endTime - startTime) / 1e6 + " ms");

        // Deque (ArrayDeque)
        Deque<Producto> deque = new ArrayDeque<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numProductos; i++) {
            deque.add(createProducto(i));
        }
        endTime = System.nanoTime();
        System.out.println("Deque: Tiempo de carga: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        Producto lastElementDeque = deque.peekLast();
        endTime = System.nanoTime();
        System.out.println("Deque: Tiempo de búsqueda del último elemento: " + (endTime - startTime) / 1e6 + " ms");
    }

    // Método para comparar HashSet, LinkedHashSet y TreeSet
    private static void compareSet(int numProductos) {
        long startTime, endTime;

        // HashSet
        Set<Producto> hashSet = new HashSet<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numProductos; i++) {
            hashSet.add(createProducto(i));
        }
        endTime = System.nanoTime();
        System.out.println("HashSet: Tiempo de carga: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        boolean containsLastElementHashSet = hashSet.contains(createProducto(numProductos - 1));
        endTime = System.nanoTime();
        System.out.println("HashSet: Tiempo de búsqueda del último elemento: " + (endTime - startTime) / 1e6 + " ms");

        // LinkedHashSet
        Set<Producto> linkedHashSet = new LinkedHashSet<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numProductos; i++) {
            linkedHashSet.add(createProducto(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet: Tiempo de carga: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        boolean containsLastElementLinkedHashSet = linkedHashSet.contains(createProducto(numProductos - 1));
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet: Tiempo de búsqueda del último elemento: " + (endTime - startTime) / 1e6 + " ms");

        // TreeSet
        Set<Producto> treeSet = new TreeSet<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numProductos; i++) {
            treeSet.add(createProducto(i));
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet: Tiempo de carga: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        boolean containsLastElementTreeSet = treeSet.contains(createProducto(numProductos - 1));
        endTime = System.nanoTime();
        System.out.println("TreeSet: Tiempo de búsqueda del último elemento: " + (endTime - startTime) / 1e6 + " ms");
    }

    // Método para comparar HashMap, LinkedHashMap y TreeMap
    private static void compareMap(int numProductos) {
        long startTime, endTime;

        // HashMap
        Map<String, Producto> hashMap = new HashMap<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numProductos; i++) {
            Producto producto = createProducto(i);
            hashMap.put(producto.getId(), producto);
        }
        endTime = System.nanoTime();
        System.out.println("HashMap: Tiempo de carga: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        Producto lastElementHashMap = hashMap.get(createProducto(numProductos - 1).getId());
        endTime = System.nanoTime();
        System.out.println("HashMap: Tiempo de búsqueda del último elemento: " + (endTime - startTime) / 1e6 + " ms");

        // LinkedHashMap
        Map<String, Producto> linkedHashMap = new LinkedHashMap<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numProductos; i++) {
            Producto producto = createProducto(i);
            linkedHashMap.put(producto.getId(), producto);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashMap: Tiempo de carga: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        Producto lastElementLinkedHashMap = linkedHashMap.get(createProducto(numProductos - 1).getId());
        endTime = System.nanoTime();
        System.out.println("LinkedHashMap: Tiempo de búsqueda del último elemento: " + (endTime - startTime) / 1e6 + " ms");

        // TreeMap
        Map<String, Producto> treeMap = new TreeMap<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numProductos; i++) {
            Producto producto = createProducto(i);
            treeMap.put(producto.getId(), producto);
        }
        endTime = System.nanoTime();
        System.out.println("TreeMap: Tiempo de carga: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        Producto lastElementTreeMap = treeMap.get(createProducto(numProductos - 1).getId());
        endTime = System.nanoTime();
        System.out.println("TreeMap: Tiempo de búsqueda del último elemento: " + (endTime - startTime) / 1e6 + " ms");
    }
    private static Cliente seleccionarCliente(ClientesList<Cliente> clientesList) {
        // Crear un frame para la selección
        JFrame frame = new JFrame("Seleccionar Cliente");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel para la lista de clientes
        JPanel panel = new JPanel(new BorderLayout());

        // Crear un modelo para la lista
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Cliente cliente : clientesList.getClientes()) {
            listModel.addElement(cliente.getNombre() + " " + cliente.getApellido());
        }

        // Crear la lista y añadirla a un JScrollPane
        JList<String> list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Crear un diálogo modal para manejar la selección
        JDialog dialog = new JDialog(frame, "Seleccionar Cliente", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(null);
        dialog.add(panel);

        // Botón para confirmar la selección
        JButton selectButton = new JButton("Seleccionar");
        panel.add(selectButton, BorderLayout.SOUTH);

        // Crear una referencia mutable para guardar el cliente seleccionado
        final Cliente[] selectedCliente = {null};

        // Acción al presionar el botón
        selectButton.addActionListener(e -> {
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
                selectedCliente[0] = clientesList.getClientes().get(selectedIndex);
                dialog.dispose(); // Cerrar el diálogo
            } else {
                JOptionPane.showMessageDialog(
                        dialog,
                        "Por favor, seleccione un cliente.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        // Mostrar el diálogo
        dialog.setVisible(true);

        // Retornar el cliente seleccionado
        return selectedCliente[0];
    }

}