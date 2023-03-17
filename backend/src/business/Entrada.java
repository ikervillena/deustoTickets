package business;

import java.util.Date;

public class Entrada {

    Evento evento;
    Usuario usuario;
    String nombre;
    Date fecCompra;

    public Entrada(Evento evento, Usuario usuario, String nombre, Date fecCompra) {
        this.evento = evento;
        this.usuario = usuario;
        this.nombre = nombre;
        this.fecCompra = fecCompra;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecCompra() {
        return fecCompra;
    }

    public void setFecCompra(Date fecCompra) {
        this.fecCompra = fecCompra;
    }
}
