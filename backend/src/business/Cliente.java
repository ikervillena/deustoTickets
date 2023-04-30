package business;

import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;
import lombok.*;

@PersistenceCapable
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario {
    @Getter @Setter private int dni;
    @Getter @Setter private String email;

    /*public Cliente(String usuario, String contrasenya, String nombre, String apellido, Date fecNac) {
        super(usuario, contrasenya, nombre, apellido, fecNac);
    }*/
}
