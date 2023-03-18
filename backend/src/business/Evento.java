package business;

//import javax.jdo.annotations.Column;
import java.util.Date;

public class Evento {

    String titulo;
    String descripcion;
    Date fecha;
    int aforo;
    //@Column(name="espacios_id")
    Espacio espacio;

    public Evento(String titulo, String descripcion, Date fecha, int aforo, Espacio espacio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.aforo = aforo;
        this.espacio = espacio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", aforo=" + aforo +
                ", espacio=" + espacio +
                '}';
    }
}
