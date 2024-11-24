package json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ArrayList.AdministradorList;
import models.Producto;
import models.Usuario.Cliente;
import models.Usuario.ClientesList;

import java.io.File;
import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar campos desconocidos
public class JsonClientes {
    public static void serializarClientes(ClientesList<Cliente> clientes) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("clientes.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, clientes);
            System.out.println("Clientes guardados en clientes.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ClientesList<Cliente> deserializarClientes() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("clientes.json");
            // Usa TypeReference para manejar tipos genéricos correctamente
            return objectMapper.readValue(file, new TypeReference<ClientesList<Cliente>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Retorna null en caso de error
        }
    }
}