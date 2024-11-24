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
import java.util.*;

import static json.JsonClientes.serializarClientes;
import static json.JsonProductos.deserializarProductos;
import static json.JsonProductos.serializarProductos;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int opcion;
    public static void main(String[] args) {

        ClientesList<Cliente> clientes = new ClientesList<>();
        clientes.cargarClientesRandom(10);
        serializarClientes(clientes);
        // Inicializar el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            AdministradorList<Producto> productos = deserializarProductos();
            Cliente cliente = Cliente.clienteRandom();
            MenuPpal menuPpal = new MenuPpal(productos, cliente);

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

}