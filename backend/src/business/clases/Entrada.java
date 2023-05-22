package business.clases;

import java.io.Serializable;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;

import business.clases.*;
import lombok.*;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@NoArgsConstructor
@AllArgsConstructor
@PersistenceCapable

public class Entrada {

    @PrimaryKey
    @Getter @Setter private String qr;
    @Getter @Setter private String nombre;
    @Getter @Setter private Date fecCompra;
    @Getter @Setter private int idPrecio;
    @Getter @Setter private int idEvento;
    @Getter @Setter private String dniCliente;
    @Getter @Setter private boolean utilizada;

}
