package business;

//import javax.jdo.annotations.Persistent;

public class Espacio {

    String nombre;
    String direccion;
    /**
    @Persistent(mappedBy="espacios")
    ArrayList<Evento> eventos;
    */

    public Espacio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Espacio{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
