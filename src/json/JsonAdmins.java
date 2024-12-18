package json;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Usuario.Admin;
import models.Usuario.AdminList;
import models.Usuario.Persona;

import java.io.File;
import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)

@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "admin") // Registrar subtipo
})
public class JsonAdmins {
    public static void serializarAdmins(AdminList admins) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            File archivo = new File("src/admins.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, admins);//Este método utiliza un "Pretty Printer" para generar un
            // JSON más legible para los humanos, con saltos de línea e indentaciones.
            // Si no se puede poner directamente writeValue()
            System.out.println("Archivo guardado exitosamente");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static AdminList deserializarAdmins() {
        ObjectMapper mapper = new ObjectMapper();
        try{
            File archivo2 = new File("src/admins.json");
            return mapper.readValue(archivo2, new TypeReference<AdminList>(){});// type reference ayuda a Jackson a identificar los datos genericos
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
