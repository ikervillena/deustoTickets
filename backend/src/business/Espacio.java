package business;

//import javax.jdo.annotations.Persistent;
import java.util.ArrayList;

public class Espacio {

    String nombre;
    String direccion;
    //@Persistent(mappedBy="espacios")
    ArrayList<Evento> eventos;

    public Espacio(String nombre, String direccion, ArrayList<Evento> eventos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.eventos = eventos;
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

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return "Espacio{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
