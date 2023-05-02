package business.clases;

import java.io.Serializable;
import java.util.Date;
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
