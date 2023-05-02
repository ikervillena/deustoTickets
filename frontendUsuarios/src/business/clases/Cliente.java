package business.clases;

import java.io.Serializable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private int dni;
    @Getter @Setter private String email;

    /*public Cliente(String usuario, String contrasenya, String nombre, String apellido, Date fecNac) {
        super(usuario, contrasenya, nombre, apellido, fecNac);
    }*/
}
