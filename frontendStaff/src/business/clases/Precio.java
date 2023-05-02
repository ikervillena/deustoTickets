package business.clases;

import java.io.Serializable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

public class Precio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String nombre;
    @Getter @Setter private int precio;
    @Getter @Setter private int disponibles;
    @Getter @Setter private int ofertadas;
}
