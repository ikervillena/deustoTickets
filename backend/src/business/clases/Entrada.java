package business.clases;

import java.io.Serializable;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;

import business.clases.*;
import lombok.*;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;

@NoArgsConstructor
@AllArgsConstructor
@PersistenceCapable

public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String qr;
    @Getter @Setter private int codigo;
    @Getter @Setter private String nombre;
    @Column (name = "precio_id")
        @Getter @Setter private Precio precio;
    @Getter @Setter private Date fecCompra;
    @Column (name = "evento_id")
        @Getter @Setter private Evento evento;
    @Column (name="cliente_id")
        @Getter @Setter private Cliente cliente;
    @Getter @Setter private boolean utilizada;
}
