package business.clases.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String dni;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String apellido;
    @Getter
    @Setter
    private String usuario;
    @Getter
    @Setter
    private String contrasenya;
    @Getter
    @Setter
    private Date fecNac;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private ArrayList<EntradaDTO> entradas;
}
