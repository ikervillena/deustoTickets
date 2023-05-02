package business.clases;

import java.io.Serializable;
import java.util.Date;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String qr;
    @Getter @Setter private int codigo;
    @Getter @Setter private String nombre;
    @Getter @Setter private int precio;
    @Getter @Setter private Date fecCompra;
    @Getter @Setter private Evento evento;
    @Getter @Setter private Cliente cliente;
}
