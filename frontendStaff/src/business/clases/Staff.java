package business.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.jdo.annotations.PersistenceCapable;
import java.io.Serializable;
import java.util.Date;

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
