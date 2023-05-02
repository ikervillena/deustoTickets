package business.clases;

import java.io.Serializable;
import java.util.Date;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

public class Artista implements Serializable {
    @Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    @Getter @Setter private Date fecNac;
    @Getter @Setter private String foto;
}
