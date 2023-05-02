package business.clases;

import java.io.Serializable;
import java.util.Date;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

public class Entrada implements Serializable {
    @Getter @Setter private String nombre;
    @Getter @Setter private int precio;
    @Getter @Setter private Date fecCompra;
    @Getter @Setter private Evento evento;
    @Getter @Setter private Cliente cliente;
}
