package business.clases;

import java.util.Date;
import lombok.*;

public abstract class Usuario {
	@Getter @Setter private String nombre;
	@Getter @Setter private String apellido;
    @Getter @Setter private String usuario;
    @Getter @Setter private String contrasenya;
    @Getter @Setter private Date fecNac;
}
