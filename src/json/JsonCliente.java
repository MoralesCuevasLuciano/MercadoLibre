package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ArrayList.AdministradorList;
import models.Producto;
import models.Usuario.Cliente;

import java.io.File;
import java.io.IOException;

public class JsonCliente {
    public static void serializarCliente(Cliente cliente) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("cliente.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, cliente);
            System.out.println("Cliente guardado en cliente.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Cliente deserializarCliente() {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            File file = new File("cliente.json");
            Cliente cliente = objectMapper.readValue(file, Cliente.class);
            return cliente;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
