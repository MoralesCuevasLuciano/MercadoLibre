package models.Persona;

import enums.Genero;

import java.util.UUID;

public abstract class Persona {
    private String id;
    private String nombre;
    private String dni;
    private Genero sexo;
    private String telefono;
    private Direccion direccion;


    /**Constructores*/
    public Persona(String id, String nombre, String dni, Genero sexo, String telefono, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Persona() {
    }

    ;


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
    public Direccion getDireccion() {
        return direccion;
    }
    public Persona direccion(Direccion direccion) {
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
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                ", telefono='" + telefono + '\'' +
                ", direccion=" + direccion +
                '}';
    }
}
