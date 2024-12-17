package models.Usuario;

public class Admin extends Persona{
    private String usuario;
    private String password;



    public Admin() {
    }

    public Admin(String usuario, String password, String nombre) {
        this.usuario = usuario;
        this.password = password;
        super.nombre(nombre);
    }

    public Admin(String nombre, String apellido, String usuario, String password) {}
}
