package business;

import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@PersistenceCapable

public class Artista {
    @Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    @Getter @Setter private Date fecNac;
    @Getter @Setter private String foto;
}
