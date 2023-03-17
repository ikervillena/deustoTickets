package business;

import java.util.ArrayList;
import java.util.Date;

public class Artista {

    String nombre;
    String descripcion;
    Date fecNac;
    String foto;

    public Artista(String nombre, String descripcion, Date fecNac, String foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecNac = fecNac;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
