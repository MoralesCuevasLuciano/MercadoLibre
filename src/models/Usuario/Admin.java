package models.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;



public class Admin extends Persona{

    private String usuario;

    private String password;

    @JsonIgnoreProperties(ignoreUnknown = true)

    public Admin() {
    }

    public Admin(String usuario, String password, String nombre) {

        this.usuario = usuario;
        this.password = password;
        super.nombre(nombre);
    }

    public Admin(String nombre, String apellido, String usuario, String password) {}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

