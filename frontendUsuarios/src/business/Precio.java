package business;

public class Precio {

    String nombre;
    int precio;
    int disponibles;
    int ofertadas;

    public Precio(String nombre, int precio, int disponibles, int ofertadas) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponibles = disponibles;
        this.ofertadas = ofertadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public int getOfertadas() {
        return ofertadas;
    }

    public void setOfertadas(int ofertadas) {
        this.ofertadas = ofertadas;
    }
}
