package business.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

public class Artista implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    @Getter @Setter private Date fecNac;
    @Getter @Setter private String foto;

}
