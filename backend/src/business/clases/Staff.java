package business.clases;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import lombok.*;
import java.util.Date;

import java.io.Serializable;

@PersistenceCapable
@NoArgsConstructor
@AllArgsConstructor

public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String nombre;
	@Getter @Setter private String apellido;
    @Getter @Setter private String usuario;
    @Getter @Setter private String contrasenya;
    @Getter @Setter private Date fecNac;
    @Getter @Setter private int dni;
    @Getter @Setter private String email;
}
