package models.Usuario;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import enums.Genero;

import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
public abstract class Persona {
    private String id;
    private String nombre;
    private String dni;
    private Genero sexo;
    private String telefono;
    private String direccion;


    /**Constructores*/
    public Persona(String nombre, String dni, Genero sexo, String telefono, String direccion) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    public Persona() {
    }



    /**Getters y Setters*/
    public String getId() {
        return id;
    }
    public Persona id(String id) {
        this.id = UUID.randomUUID().toString();
        return this;
    }
    public String getNombre() {
        return nombre;
    }
    public Persona nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public String getDni() {
        return dni;
    }
    public Persona dni(String dni) {
        this.dni = dni;
        return this;
    }
    public Genero getSexo() {
        return sexo;
    }
    public Persona sexo(Genero sexo) {
        this.sexo = sexo;
        return this;
    }
    public String getTelefono() {
        return telefono;
    }
    public Persona telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public Persona setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    /**Imprimir*/
    public void imprimir() {
        System.out.println("ID:........................: " + id);
        System.out.println("Nombre:....................: " + nombre);
        System.out.println("Dni:.......................: " + dni);
        System.out.println("Sexo:......................: " + sexo);
        System.out.println("Telefono:..................: " + telefono);
        System.out.println("Direccion:.................: " + direccion);
    }


    /**IMPRIMIR SIN ID YA QUE SON DATOS NO NECESARIOS PARA LOS CLIENTES*/
    public void imprimirCliente() {
        System.out.println("Nombre:....................: " + nombre);
        System.out.println("Dni:.......................: " + dni);
        System.out.println("Sexo:......................: " + sexo);
        System.out.println("Telefono:..................: " + telefono);
        System.out.println("Direccion:.................: " + direccion);
    }


    @Override
    public String toString() {
        return
                "\nId:............................: " + id +
                "\nNombre:.........................: " + nombre +
                "\nDNI:............................: " + dni +
                "\nSexo:...........................: " + sexo +
                "\nTelefono:.......................: " + telefono +
                "\nDireccion:......................: " + direccion +
                "\n==============================================\n\n";
    }


    /**
     * Crear admin y cliente con sus atributos
     * DE aca hereda Cliente y Administrador,
     * los dos van a recorrer la lista de productos,
     * pero el cliente va a comprar y el administrador va a modificar
     * el user va a realizar compras, agregar cosas al carrito, etc
     * hay que hacer al cliente un trycatch para que no compre mas de lo que hay en stock
     * otro mas para que no pueda comprar si no tiene dinero suficiente en la cuenta
     * Crear arrays para cliente de compras y administrador y que se guarden en un archivo
     * para que no se pierdan los datos
     *
     * */
}
