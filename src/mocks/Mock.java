package mocks;

import java.util.Random;

public final class Mock {
    private static final Random random = new Random();

    //MOCK DE MARCAS
    private static final String[] marcasHerramientas = {
            "Bosch", "DeWalt", "Makita", "Stanley", "Milwaukee", "Black & Decker", "Ryobi", "Hilti", "Craftsman", "Ridgid"
    };

    private static final String[] marcasBazar = {
            "IKEA", "Palermo", "Rincón del Bazar", "Sodimac", "Easy", "Librería El Ateneo", "Falabella", "Casa Pons" , "Coto" , "Musimundo"
    };

    private static final String[] marcasJuguetes = {
            "Barbie", "Hot Wheels", "Rasti", "Hasbro", "Mattel", "Lego", "Rasti", "YolyBell", "Educando", "Toy Planet"
    };

    private static final String[] marcasRopa = {"Topper", "UnderArmour", "Nike", "Adidas", "Levis", "Puma", "Lacoste", "Prune", "NorthFace", "Fila"};

    private static final String[] marcasTecnologia = {"Apple", "Samsung", "Sony", "LG", "Lenovo", "Philips", "HP", "Dell", "Asus", "Xiaomi"};

    //MOCK DE MODELOS
    private static final String[] modeloHerramientas = {
            "DWD112", "DCD771C2", "GKS190", "WES700", "DWE7485",
            "DSH902", "GWS7-115", "DWE6411K", "DCH273B", "PSE180",
            "GCM12SD", "DCS570B", "DWP611", "DCK240C2", "DCP580B",
            "DCS356C1", "DWE7485", "DCH273P2", "DCS570B", "DWE6423K",
            "DCS334B", "DCH273X1", "DCH172X1", "DCS388B", "DCHJ080",
            "DCE081", "DCP580N", "DWD520", "DCHT860N", "DCS7485B"
    };

    private static final String[] modeloBazar = {"Modelo A", "Modelo B", "Modelo C", "Modelo D", "Modelo E", "Modelo F", "Modelo G", "Modelo H", "Modelo I", "Modelo J"};

    private static final String[] modeloJuguetes = {
            "RoboCompanero 3000", "Dino Explorer", "Aventuras en el Espacio", "Carrito de Superhéroes", "Castillo Encantado",
            "Coche Volador", "Set de Cocina Mágico", "Camión de Bomberos", "Puzzle del Mundo", "Caballito de Mar Interactivo",
            "Nave de los Piratas", "Muñeca Mágica", "Tren de la Alegría", "Juego de Construcción Gigante", "Monstruo de la Selva",
            "Torre de Bloques Coloridos", "Jardín Secreto", "Robot Transformable", "Camión de Juguete de Carga", "Kit de Ciencia Divertida",
            "Muñeco de Nieve Amistoso", "Casa de Muñecas Moderna", "Coche de Carreras", "Set de Jardinería Infantil", "Avión de Papel Volador",
            "Pista de Carreras Interactiva", "Kit de Superhéroes", "Animales de la Granja", "Juego de Memoria Divertido", "Zoológico Móvil"
    };

    private static final String[] modeloRopa = {
            "Camisa de Cuadro", "Jeans", "Vestido de Verano", "Campera de Cuero", "Sweater con Capucha",
            "Pollera Larga", "Shorts", "Abrigo de Invierno", "Blusa Elegante", "Bermuda",
            "Mono de Trabajo", "Vestido de Fiesta", "Remera Estampada", "Chaleco", "Overol",
            "Traje de Baño", "Joggers", "Remera de Manga Larga", "Botas de Trekking", "Zapatos Formales",
            "Remera Deportiva", "Campera Impermeable", "Pantalón Cargo", "Gorro de Lana", "Bufanda",
            "Zapatillas Deportivas", "Mono de Verano", "Tirantes", "Pijama", "Zapatillas Urbanas"
    };


    private static final String[] modeloCelulares = {
            "iPhone 14", "Samsung Galaxy S22", "Google Pixel 6", "OnePlus 9", "Xiaomi Mi 11",
            "Sony Xperia 5", "Nokia G50", "Oppo Reno 6", "Huawei P40", "Motorola Edge 20",
            "Realme GT", "Vivo V21", "Asus ROG Phone 5", "LG Velvet", "Honor 50",
            "ZTE Axon 20", "Poco F3", "Black Shark 4", "Microsoft Surface Duo", "Lenovo Legion Phone",
            "Samsung Galaxy A52", "iPhone SE (2022)", "Google Pixel 5a", "Nokia X20", "Oppo Find X3",
            "Xiaomi Redmi Note 10", "Honor 30", "Vivo X60", "Huawei Mate 40", "Sony Xperia 1 III"
    };

    private static final String[] modeloComputadoras = {
            "Dell XPS 13", "MacBook Pro 16", "HP Spectre x360", "Lenovo ThinkPad X1", "Asus ZenBook 14",
            "Acer Swift 3", "Microsoft Surface Laptop 4", "Razer Blade 15", "LG Gram 17", "Samsung Galaxy Book Pro",
            "HP Envy 13", "Apple iMac 24", "Lenovo IdeaPad Flex 5", "Dell Inspiron 15", "Acer Aspire 5",
            "MSI GS66 Stealth", "Alienware m15", "Gigabyte AERO 15", "Huawei MateBook 14", "Toshiba Dynabook Tecra",
            "Asus ROG Zephyrus G14", "Microsoft Surface Pro 7", "HP Omen 15", "Razer Book 13", "Lenovo Legion 5",
            "Apple Mac Mini M1", "Dell Vostro 15", "Acer Predator Helios 300", "Samsung Galaxy Book Go", "Lenovo ThinkBook 14"
    };

    //MOCK DE NOMBRES (TIPOS)
    private static final String[] herramientasElectricas = {
            "Taladro Inalámbrico", "Destornillador Eléctrico", "Sierra Circular", "Lijadora Orbital", "Martillo Perforador",
            "Cortadora de Azulejos", "Multiherramienta", "Compresora de Aire", "Pistola de Calor", "Sierra de Inglete",
            "Amoladora Angular", "Taladro de Banco", "Nivel Láser", "Cortadora de Metales", "Sierra de Vaivén",
            "Lijadora de Banda", "Pistola de Grapas", "Juego de Brocas"
    };

    private static final String[] herramientasManuales = {
            "Llave Ajustable", "Desarmador de Precisión", "Martillo de Goma", "Cortador de Placas", "Escuadra de Carpintero",
            "Cinta Métrica", "Pico de Gallo", "Atornillador Manual", "Cortadora de Cables", "Paleta de Yeso",
            "Juego de Llaves Allen"
    };


    private static final String[] nombresBazar = {
            "Sofá de dos cuerpos", "Mesa de comedor", "Silla de oficina", "Cama queen size", "Escritorio de madera",
            "Mesa de noche", "Estante para libros", "Aparador", "Mesa de centro", "Cajonera",
            "Silla plegable", "Taburete alto", "Cuna de bebé", "Banco de jardín", "Mesa de jardín",
            "Sofá cama", "Mueble organizador", "Rincón de lectura", "Mueble TV", "Cabecero de cama",
            "Mueble de entrada", "Consola decorativa", "Mesa auxiliar", "Silla de comedor", "Mueble de baño",
            "Cama nido", "Perchero", "Zapatero", "Librero", "Cortina decorativa"
    };

    private static final String[] juegosMesa = {
            "Aventureros al Tren", "Catan", "Jenga", "Uno", "Scrabble",
            "Dixit", "Clue", "Carcassonne", "Monopoly", "Risk",
            "Codenames", "Pandemic", "Ticket to Ride", "Azul", "Bang!"
    };

    private static final String[] juguetesElectricos = {
            "Muñeca Interactiva", "Coche de Control Remoto", "Robot Transformable", "Tren de Juguete", "Dinosaurio de Juguete",
            "Helicóptero RC", "Camión de Bomberos Eléctrico", "Nave Espacial Interactiva", "Perro Robot", "Robo-Mascota",
            "Bote de Juguete con Control Remoto", "Pista de Carreras Eléctrica", "Muñeca que Habla", "Drone para Niños", "Coche de Juguete con Sonido"
    };

    private static final String[] juguetesManuales = {
            "Juego de Construcción", "Pelota Saltarina", "Figuras de Acción", "Set de Cocina Infantil", "Casa de Muñecas",
            "Coche de Carreras", "Caballito de Madera", "Kit de Ciencia", "Torre de Bloques", "Patinete",
            "Avión de Juguete", "Kit de Manualidades", "Muñeco de Trapo", "Pelota de Fútbol", "Bicicleta Infantil"
    };

    public static String getMarcaHerramientas(){
        return marcasHerramientas[random.nextInt(marcasHerramientas.length)];
    }

    public static String getMarcaBazar() {
        return marcasBazar[random.nextInt(marcasBazar.length)];
    }

    public static String getMarcaJuguetes() {
        return marcasJuguetes[random.nextInt(marcasJuguetes.length)];
    }

    public static String getMarcaRopa() {
        return marcasRopa[random.nextInt(marcasRopa.length)];
    }

    public static String getMarcaTecnologia() {
        return marcasTecnologia[random.nextInt(marcasTecnologia.length)];
    }

    public static String getModeloHerramientas(){
        return modeloHerramientas[random.nextInt(modeloHerramientas.length)];
    };

    public static String getModeloBazar() {
        return modeloBazar[random.nextInt(modeloBazar.length)];
    }

    public static String getModeloJuguetes() {
        return modeloJuguetes[random.nextInt(modeloJuguetes.length)];
    }

    public static String getModeloRopa() {
        return modeloRopa[random.nextInt(modeloRopa.length)];
    }

    public static String getModeloCelulares() {
        return modeloCelulares[random.nextInt(modeloCelulares.length)];
    }

    public static String getModeloComputadoras() {
        return modeloComputadoras[random.nextInt(modeloComputadoras.length)];
    }

    public static String getNombreHerramientasElectricas(){
        return herramientasElectricas[random.nextInt(herramientasElectricas.length)];
    }

    public static String getNombreHerramientasManuales() {
        return herramientasManuales[random.nextInt(herramientasManuales.length)];
    }

    public static String getNombreBazar() {
        return nombresBazar[random.nextInt(nombresBazar.length)];
    }

    public static String getNombreJuegosMesa() {
        return juegosMesa[random.nextInt(juegosMesa.length)];
    }

    public static String getNombreJuguetesElectricos() {
        return juguetesElectricos[random.nextInt(juguetesElectricos.length)];
    }

    public static String getNombreJuguetesManuales() {
        return juguetesManuales[random.nextInt(juguetesManuales.length)];
    }



}
