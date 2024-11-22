package mocks;

import java.util.Random;

public final class Mock {
    public static final Random random = new Random();

    //MOCK DE MARCAS

    private static final String[] marcasHerramientas = {
            "Bosch", "DeWalt", "Makita", "Stanley", "Milwaukee", "Black & Decker", "Ryobi", "Hilti", "Craftsman", "Ridgid"
    };

    private static final String[] marcasInsumos = {
            "Fixser", "Sodecar", "Herdez", "Rex", "Basso",
            "Sparta", "Scotch", "Obrero", "Sodecar", "Pirelli"
    };

    private static final String[] marcasMuebles = {
            "Nordic Living", "Urban Habitat", "Casa Moderna", "Rustic Charm", "Luxe Interiors", "Vintage Vibes", "The Furniture Co.", "Artisan Spaces", "Cozy Nest", "EcoHome Designs", "Trendy Furnishings", "Elegant Essence", "Bold Lines", "Timber & Steel", "Minimalist Magic", "Oak Haven", "HomeCraft", "Modular Masters", "Heritage Woods", "Chic Corners"
    };


    private static final String[] marcasBazar = {
            "IKEA", "Palermo", "Rincón del Bazar", "Sodimac", "Easy", "Librería El Ateneo", "Falabella", "Casa Pons" , "Coto" , "Musimundo"
    };

    private static final String[] marcasJuguetes = {
            "Barbie", "Hot Wheels", "Rasti", "Hasbro", "Mattel", "Lego", "Rasti", "YolyBell", "Educando", "Toy Planet"
    };

    private static final String[] marcasRopa = {"Topper", "UnderArmour", "Nike", "Adidas", "Levis", "Puma", "Lacoste", "Prune", "NorthFace", "Fila", "Urban Threads", "Velvet Lane", "Golden Stitch", "Luxe Appeal", "Bold & Basic", "Civic Style", "Amber Wardrobe", "Pure Cotton Co.", "Royal Threads", "Eclipse Wear", "Summit Apparel", "Infinite Trend", "Street Vogue", "True Edge", "Ocean Breeze", "Classic Charm", "Modern Tailor", "Aspire Fit", "Timeless Elegance", "Frost & Co."};

    private static final String[] marcasTecnologia = {"Apple", "Samsung", "Xiaomi", "Huawei", "Google", "OnePlus", "Motorola", "Sony", "Oppo", "Realme", "LG", "Asus", "Nokia", "Lenovo", "Vivo"};

    //MOCK DE MODELOS
    private static final String[] modeloHerramientas = {
            "DWD112", "DCD771C2", "GKS190", "WES700", "DWE7485",
            "DSH902", "GWS7-115", "DWE6411K", "DCH273B", "PSE180",
            "GCM12SD", "DCS570B", "DWP611", "DCK240C2", "DCP580B",
            "DCS356C1", "DWE7485", "DCH273P2", "DCS570B", "DWE6423K",
            "DCS334B", "DCH273X1", "DCH172X1", "DCS388B", "DCHJ080",
            "DCE081", "DCP580N", "DWD520", "DCHT860N", "DCS7485B"
    };

    private static final String[] modeloMueble = {
            "Denver Sofa", "Oslo Dining Table", "Cambridge Armchair", "Luna Coffee Table", "Vienna Bed Frame", "Aurora Bookshelf", "Hampton Dresser", "Berlin Nightstand", "Milan TV Stand", "Phoenix Recliner", "Stockholm Wardrobe", "Sierra Loveseat", "Verona Bar Stool", "Aspen Sectional", "Dakota Sideboard", "Montreal Chaise Lounge", "Savannah Bench", "Brooklyn Console Table", "Madrid Ottoman", "Geneva Cabinet"
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

    private static final String[] modeloJuegosDeMesa = {
            "Dados", "Cartas", "Fichas", "Tablero", "Piezas",
            "Marcadores", "Contadores", "Figuras", "Fichas de puntuación", "Carteles"
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

    private static final String[] insumos = {
            "Tornillo", "Clavo", "Mecha", "Tuerca", "Arandela",
            "Perno", "Grapa", "Clavo de Acero", "Tornillo de Mariposa", "Cinta Adhesiva",
            "Bisagra", "Perno de Anclaje", "Anillo de Seguridad", "Pasador", "Manguera"
    };


    private static final String[] nombresBazar = {
            "Sofá de dos cuerpos", "Mesa de comedor", "Silla de oficina", "Cama queen size",
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

    //MOCK MATERIALES DE BAZAR

    private static final String[] materialBazar = {
            "Madera", "Acero", "Aluminio", "Vidrio", "Plástico",
            "Cerámica", "Cobre", "Cartón", "Piedra", "Tela"
    };

    private static final String[] materialesMuebles = {
            "Madera de Pino", "Madera de Roble", "Madera de Nogal", "Madera de Cedro", "Madera de Haya",
            "Aluminio", "Acero Inoxidable", "Madera Contrachapada", "MDF", "Aglomerado"
    };

    private static final String[] colores = {
            "Rojo", "Azul", "Verde", "Amarillo", "Naranja", "Violeta", "Celeste", "Blanco", "Negro"
    };

    private static final String[] nombresSillones = {
            "Armonía", "Serenity", "Lúmina", "Osaka", "Baltimore", "Cloud Nine", "Zenith", "Eterna", "Oxford", "Nova", "Valencia", "Solstice", "Everest", "Cumbre", "Mistral", "Savoy", "Aurora", "Cairo", "Velvet Touch", "Lodge"
    };

    private static final String[] tallesRopa = {
            "XS", "S", "M", "L", "XL", "XXL", "XXXL", "34", "36", "38", "40", "42", "44", "46", "48", "Petite", "Regular", "Tall", "Slim Fit", "Plus Size"
    };

    private static final String[] materialesRopa = {
            "Algodón", "Lana", "Poliéster", "Seda", "Lino", "Rayón", "Nylon", "Elastano", "Denim", "Franela", "Viscosa", "Cáñamo", "Tencel", "Pana", "Acrílico", "Cuero", "Gamuzina", "Cashmere", "Lycra", "Bambú"
    };

    private static final String[] modelosBuzos = {
            "Buzo Canguro", "Buzo Oversize", "Buzo Crop", "Buzo con Cremallera", "Buzo con Capucha", "Buzo de Lana", "Buzo de Polar", "Buzo Deportivo", "Buzo Estampado", "Buzo Básico", "Buzo Tie-Dye", "Buzo Bordado", "Buzo a Rayas", "Buzo de Algodón Orgánico", "Buzo de Punto", "Buzo Slim Fit", "Buzo Acolchado", "Buzo con Bolsillo", "Buzo de Cuello Redondo", "Buzo Vintage"
    };

    private static final String[] nombresBuzos = {
            "Storm", "Aurora", "Shadow", "Eclipse", "Nimbus", "Blizzard", "Horizon", "Crest", "Summit", "Pulse", "Drift", "Frost", "Radiance", "Echo", "Zephyr", "Lunar", "Vortex", "Altitude", "Glide", "Halo"
    };

    private static final String[] modelosRemeras = {
            "Remera Básica", "Remera Oversize", "Remera Slim Fit", "Remera de Cuello en V", "Remera de Cuello Redondo", "Remera de Algodón", "Remera Estampada", "Remera de Manga Larga", "Remera sin Mangas", "Remera Polo", "Remera Crop", "Remera Tie-Dye", "Remera Bordada", "Remera Rayada", "Remera Deportiva", "Remera con Bolsillo", "Remera Vintage", "Remera de Modal", "Remera de Cuello Alto", "Remera de Corte Recto"
    };

    private static final String [] nombresRemeras = {
            "Nova", "Pulse", "Bliss", "Echo", "Summit", "Lunar", "Vivid", "Ethereal", "Horizon", "Zenith", "Drift", "Crest", "Vortex", "Halo", "Nimbus", "Radiance", "Glide", "Fusion", "Solstice", "Apex"
    };

    private static final String[] modelosPatnalones= {
            "Pantalón Skinny", "Pantalón Slim Fit", "Pantalón Palazzo", "Pantalón Jogger", "Pantalón Cargo", "Pantalón Chino", "Pantalón Recto", "Pantalón Acampanado", "Pantalón de Cuero", "Pantalón de Lana", "Pantalón Sastre", "Pantalón Deportivo", "Pantalón de Tiro Alto", "Pantalón de Tiro Bajo", "Pantalón Cropped", "Pantalón Wide Leg", "Pantalón Pijama", "Pantalón de Algodón", "Pantalón Rayado", "Pantalón de Cintura Elástica"
    };
    private static final String[] nombresPantalones = {
        "Trail", "Summit", "Vista", "Loom", "Stride", "Horizon", "Crest", "Flow", "Pivot", "Pulse", "Echo", "Peak", "Frost", "Lunar", "Tide", "Nimbus", "Drift", "Glide", "Apex", "Eclipse"
    };
    private static final String[] modelosCalzados = {
        "Zapatillas Deportivas", "Botas de Montaña", "Mocasines de Cuero", "Sandalias Planas", "Zapatos Oxford", "Botines Chelsea", "Zapatillas Running", "Zapatos Derby", "Alpargatas", "Botas Militares", "Zapatos de Tacón", "Sandalias de Plataforma", "Bailarinas", "Botas Altas", "Zapatillas Skate", "Zapatos Monk Strap", "Pantuflas de Casa", "Zapatos Náuticos", "Zapatos Brogue", "Sneakers Retro"
    };
    private static final String[] nombresCalzado= {
        "Strider", "Nimbus", "Trailblazer", "Summit", "Crest", "Echo", "Pulse", "Loom", "Trek", "Glide", "Lunar", "Horizon", "Vortex", "Drift", "Apex", "Sprint", "Vertex", "Frost", "Eclipse", "Dash"
    };

    private static final String[] nombresProcesadoresAndroid = {

            "Snapdragon 8 Gen 2", "Snapdragon 778G", "Exynos 2200", "Exynos 1380", "MediaTek Dimensity 9200", "MediaTek Helio G99", "Apple A17 Bionic", "Apple A15 Bionic", "Google Tensor G3", "Google Tensor G2", "Kirin 9000", "Kirin 990", "Unisoc T610", "Snapdragon 480+", "Dimensity 8100", "Snapdragon 870", "Snapdragon 4 Gen 1", "Exynos 2100", "MediaTek Dimensity 1200", "Snapdragon 7+ Gen 2"
    };


    private static final String[] nombresProcesadoresPc = {
            "Intel Core i9-13900K", "Intel Core i7-12700H", "Intel Core i5-13600KF", "Intel Core i3-12100F", "AMD Ryzen 9 7950X", "AMD Ryzen 7 7800X3D", "AMD Ryzen 5 7600", "AMD Ryzen 3 5300G", "Intel Xeon W-2400", "AMD Threadripper PRO 5995WX", "Intel Pentium Gold G7400", "AMD Athlon 3000G", "Intel Core i9-12900HX", "AMD Ryzen 9 5900X", "Intel Celeron N4020", "AMD Ryzen 7 PRO 6850U", "Intel Core i7-13700K", "AMD FX-8350", "Intel Core i5-12400", "AMD Ryzen 5 5600X"
    };
    /*
    private static final String[] = {

    };
    private static final String[] = {

    };
    private static final String[] = {

    };
    private static final String[] = {

    };
    private static final String[] = {

    };
    private static final String[] = {

    };
    private static final String[] = {

    };*/

    public static String getNombreProcesadorAndroid(){
        return nombresProcesadoresAndroid[random.nextInt(nombresProcesadoresAndroid.length)];
    }

    public static String getNombreProcesadorPc(){
        return nombresProcesadoresPc[random.nextInt(nombresProcesadoresPc.length)];
    }

    public static String getModeloBuzo(){
        return modelosBuzos[random.nextInt(modelosBuzos.length)];
    }

    public static String getNombreBuzo(){
        return nombresBuzos[random.nextInt(nombresBuzos.length)];
    }

    public static String getModeloRemera(){
        return modelosRemeras[random.nextInt(modelosRemeras.length)];
    }

    public static String getNombreRemera(){
        return nombresRemeras[random.nextInt(nombresRemeras.length)];
    }

    public static String getModeloPantalon(){
        return modelosPatnalones[random.nextInt(modelosPatnalones.length)];
    }

    public static String getNombrePantalon(){
        return nombresPantalones[random.nextInt(nombresPantalones.length)];
    }

    public static String getModeloCalzado(){
        return modelosCalzados[random.nextInt(modelosCalzados.length)];
    }

    public static String getNombreCalzado(){
        return nombresCalzado[random.nextInt(nombresCalzado.length)];
    }

    public static String getMaterialRopa(){
        return materialesRopa[random.nextInt(materialesRopa.length)];
    }

    public static String getTalleRopa(){
        return tallesRopa[random.nextInt(tallesRopa.length)];
    }

    public static String getMarcaHerramientas(){
        return marcasHerramientas[random.nextInt(marcasHerramientas.length)];
    }

    public static String getMarcaMuebles(){
        return marcasMuebles[random.nextInt(marcasMuebles.length)];
    }

    public static String getNombresSillones(){
        return nombresSillones[random.nextInt(nombresSillones.length)];
    }

    public static String getColores(){
        return colores[random.nextInt(colores.length)];
    }

    public static String getMarcaInsumos(){
        return marcasInsumos[random.nextInt(marcasInsumos.length)];
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

    public static String getModeloMueble(){
        return modeloMueble[random.nextInt(modeloMueble.length)];
    }

    public static String getModeloBazar() {
        return modeloBazar[random.nextInt(modeloBazar.length)];
    }

    public static String getModeloJuguetes() {
        return modeloJuguetes[random.nextInt(modeloJuguetes.length)];
    }

    public static String getModeloJuegosDeMesa() {
        return modeloJuegosDeMesa[random.nextInt(modeloJuegosDeMesa.length)];
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

    public static String getNombreInsumos() {
        return insumos[random.nextInt(insumos.length)];
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

    public static String getMaterialBazar() {
        return materialBazar[random.nextInt(materialBazar.length)];
    }

    public static String getMaterialMuebles() {
        return materialesMuebles[random.nextInt(materialesMuebles.length)];
    }

    public static float getPrecio(){
        return (float) (Math.random()*1000);
    }

    public static int getStock(){
        return (int) (Math.random()*1000);
    }
}
