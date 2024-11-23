package models.Usuario;

import java.util.Random;

public class Direccion {

    private String calle;
    private String numero;

    // Constructor que genera una dirección aleatoria
    public Direccion() {
        this.calle = getRandomAddress();
        this.numero = getRandomNumber();
    }

    // Genera un nombre de calle aleatorio de Mar del Plata y Balcarce
    private String getRandomAddress() {
        String[] calles = {
                "Avenida Colón", "Güemes", "Juan B. Justo", "Independencia", "Ruta Nacional 226", "Funes",
                "San Martín", "Alem", "Mitre", "Balcarce", "Avenida Luro", "Patricio Peralta Ramos", "Avenida Libertad",
                "Avenida Constitución", "Rivadavia", "Córdoba", "Alvarado", "Rawson", "12 de Octubre",
                "Avenida Champagnat", "Falucho", "Moreno", "Jujuy", "La Rioja", "Santa Fe",
                "España", "Avenida Juan José Paso", "Francia", "9 de Julio", "Catamarca", "Avenida Fortunato de la Plaza",
                "Dorrego", "Italia", "Avenida Polonia", "Avellaneda", "Rodríguez Peña", "Peña",
                "San Luis", "Avenida Arturo Alió", "Arenales", "Belgrano", "Mitre", "Bolívar", "Primera Junta", "Juan B. Justo", "Alem", "Independencia", "Colón"

        };
        Random random = new Random();
        return calles[random.nextInt(calles.length)];
    }

    // Genera un número aleatorio de 1 a 5 caracteres
    private String getRandomNumber() {
        Random random = new Random();
        int longitud = random.nextInt(5) + 1; // Longitud entre 1 y 5
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            numero.append(random.nextInt(10)); // Dígito aleatorio entre 0 y 9
        }
        return numero.toString();
    }

    // Devuelve la dirección completa como un string
    public String getAddress() {
        return calle + " " + numero;
    }
}

