package business.clases;

import java.io.Serializable;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;

import business.clases.Cliente;
import lombok.*;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;

@NoArgsConstructor
@AllArgsConstructor
@PersistenceCapable

public class Entrada implements Serializable {
    @Getter @Setter private String nombre;
    @Getter @Setter private int precio;
    @Getter @Setter private Date fecCompra;
    @Column (name = "evento_id")
        @Getter @Setter private Evento evento;
    @Column (name="cliente_id")
        @Getter @Setter private Cliente cliente;
}
