package models.Excepciones;

public class NoHayStock extends Exception{
    public NoHayStock(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Los articulos que deseas adquirir no estan disponibles por stock";
    }
}
