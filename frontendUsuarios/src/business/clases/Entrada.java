package business.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String qr;
    @Getter @Setter private String nombre;
    @Getter @Setter private Date fecCompra;
    @Getter @Setter private Precio precio;
    @Getter @Setter private Evento evento;
    @Getter @Setter private Cliente cliente;
    @Getter @Setter private boolean utilizada;
}
