package business.clases.dto;

import business.clases.Cliente;
import business.clases.Evento;
import business.clases.Precio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class EntradaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String qr;
    @Getter @Setter private String nombre;
    @Getter @Setter private Date fecCompra;
    @Getter @Setter private Precio precio;
    @Getter @Setter private Evento evento;
    @Getter @Setter private ClienteDTO cliente;
    @Getter @Setter private boolean utilizada;
}
