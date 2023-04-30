package business;

import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import lombok.*;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;

@NoArgsConstructor
@AllArgsConstructor
@PersistenceCapable

public class Entrada{
    @Getter @Setter private String nombre;
    @Getter @Setter private int precio;
    @Getter @Setter private Date fecCompra;
    @Column (name = "evento_id")
        @Getter @Setter private Evento evento;
    @Column (name="cliente_id")
        @Getter @Setter private Cliente cliente;
}
