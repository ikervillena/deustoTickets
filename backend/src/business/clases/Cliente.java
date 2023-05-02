package business.clases;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;

import business.clases.Usuario;
import lombok.*;

import java.io.Serializable;

@PersistenceCapable
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario implements Serializable {
    @Getter @Setter private int dni;
    @Getter @Setter private String email;

    /*public Cliente(String usuario, String contrasenya, String nombre, String apellido, Date fecNac) {
        super(usuario, contrasenya, nombre, apellido, fecNac);
    }*/
}
