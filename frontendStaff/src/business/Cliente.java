package business;

import java.util.Date;

public class Cliente extends Usuario {

    String dni;
    String email;

    public Cliente(String usuario, String contrasenya, String nombre, String apellido, Date fecNac) {
        super(usuario, contrasenya, nombre, apellido, fecNac);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
