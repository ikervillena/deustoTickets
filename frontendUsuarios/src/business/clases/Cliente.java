package business.clases;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario implements Serializable {
    @Getter @Setter private int dni;
    @Getter @Setter private String email;

    /*public Cliente(String usuario, String contrasenya, String nombre, String apellido, Date fecNac) {
        super(usuario, contrasenya, nombre, apellido, fecNac);
    }*/
}
