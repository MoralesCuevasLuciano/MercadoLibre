package mocks;

import java.util.Random;

public class MockCliente {

    public static final Random random = new Random();

    private static final String[] nombresCliente = {
            "Santiago", "Juan", "Mariana", "Lucía", "Carlos", "Martín", "Laura", "Pedro", "Ana", "Joaquín",
            "Gabriel", "Ricardo", "José", "Marta", "Patricia", "Diego", "Liliana", "Felipe", "Raúl", "Beatriz",
            "Andrés", "Francisco", "Eva", "Rosa", "Hernán", "Carolina", "Oscar", "Marcelo", "Alejandra", "Elena",
            "Luis", "Raquel", "Emilia", "Victoria", "Alicia", "René", "Cecilia", "Nicolás", "Daniela", "Fernando",
            "Silvina", "Gabriela", "Lidia", "Eduardo", "Sandra", "Margarita", "Esteban", "Julieta", "Adriana", "Sofía",
            "Miguel", "Carla", "Natalia", "Juan Pablo", "Pablo", "César", "Graciela", "Gustavo", "Susana", "Horacio",
            "Cristina", "Luciana", "Lilian", "Verónica", "Osvaldo", "Rodolfo", "Sol", "Leandro", "Miriam", "Patricio",
            "Bárbara", "Guillermo", "Paola", "Claudia", "Jorge", "Héctor", "Adrián", "Daniel", "Violeta", "Sebastián",
            "Fabiana", "Ángel", "Hilda", "Mercedes", "Silvio", "Nancy", "Matías", "Elba", "Federico", "Gisela",
            "Tomás", "Hugo", "Julio", "Inés", "Gloria", "Lidia", "Ricardo", "Luis Fernando", "Javier", "Raúl",
            "César", "Ivana", "Catalina", "Ramón", "Sofía", "Felipe", "Leonardo", "Florencia", "Néstor", "Lourdes",
            "Rocío", "Evelyn", "Marcela", "Luz", "Ariel", "Nadia", "Gabriel", "Sabrina", "Luciano", "Ricardo",
            "Martín", "Julián", "Tomás", "Virginia", "Paola", "Diana"
    };

    private static final String[] apellidosCliente = {
            "González", "Rodríguez", "Pérez", "López", "García", "Martínez", "Sánchez", "Fernández", "López", "Gómez",
            "Díaz", "Morales", "Vázquez", "Romero", "Torres", "Ramírez", "Alvarez", "Hernández", "Ruiz", "Paredes",
            "Vega", "Mendoza", "Jiménez", "Córdoba", "Ríos", "Navarro", "Ortiz", "Salazar", "Moreno", "Herrera",
            "Suárez", "Castro", "Bravo", "Carrizo", "Sosa", "Molina", "Acevedo", "Cortés", "Gutiérrez", "Aguirre",
            "Santiago", "Bravo", "Reyes", "Pereyra", "Quiroga", "Márquez", "Bermúdez", "Campos", "Santana", "Guerrero",
            "Silva", "Benítez", "Araya", "Chávez", "Álvarez", "Figueroa", "Sánchez", "Alvarado", "Rojas", "Marín",
            "Vega", "Espinoza", "Fuentes", "Ríos", "Luna", "Guerra", "Franco", "Bustos", "Cano", "Montero",
            "Salinas", "Castillo", "Luna", "Hidalgo", "Serrano", "Vazquez", "Carreño", "Ferrer", "Cáceres", "Figueroa",
            "Acevedo", "Godoy", "Bravo", "Orozco", "Gutiérrez", "Linares", "Rey", "Vargas", "Rodrigo", "Santiago",
            "Medina", "Pérez", "Molina", "Ibarra", "Delgado", "Vázquez", "Luna", "Solís", "Guerra", "Padilla"};



    public static String getNombreClientes(){
        return nombresCliente[random.nextInt(nombresCliente.length)];
    }

    public static String getApellidoCliente() {
        return apellidosCliente[random.nextInt(apellidosCliente.length)];    }

    public static String getNumeroDocumento() {
        Random random = new Random();
        int numero = random.nextInt(70000000) + 30000000;
        return String.valueOf(numero);
    }

    public static Character getSexoRandom() {
        Random random = new Random();
        int valor = random.nextInt(2); // 0 o 1
        return valor == 0 ? 'm' : 'f';
    }

    public static String getTelefonoRandom() {
        Random random = new Random();

        String[] codigosArea = {"011", "0351", "0221", "0236", "0341", "0381", "0223"};
        String codigoArea = codigosArea[random.nextInt(codigosArea.length)];

        int nro1 = random.nextInt(10000) + 1000;
        int nro2 = random.nextInt(10000) + 1000;

        return "("+ codigoArea +") " + nro1 + "-" + nro2;
    }









}
