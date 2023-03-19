package business;

import java.util.Date;

public class Entrada {

    Evento evento;
    Cliente cliente;
    String nombre;
    int precio;
    Date fecCompra;

    public Entrada(Evento evento, Cliente cliente, String nombre, int precio, Date fecCompra) {
        this.evento = evento;
        this.cliente = cliente;
        this.nombre = nombre;
        this.precio = precio;
        this.fecCompra = fecCompra;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Date getFecCompra() {
        return fecCompra;
    }

    public void setFecCompra(Date fecCompra) {
        this.fecCompra = fecCompra;
    }
}
