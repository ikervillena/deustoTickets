package business;

import java.util.Date;

public class Usuario {

    String usuario;
    String contrasenya;
    String nombre;
    String apellido;
    Date fecNac;

    public Usuario(String usuario, String contrasenya, String nombre, String apellido, Date fecNac) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNac = fecNac;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

}
