package business.clases;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;
import java.util.ArrayList;
import java.util.Date;
import business.clases.Entrada;

import lombok.*;

import java.io.Serializable;

@PersistenceCapable
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;


    @Getter @Setter private String nombre;
	@Getter @Setter private String apellido;
    @Getter @Setter private String usuario;
    @Getter @Setter private String contrasenya;
    @Getter @Setter private Date fecNac;
    @Getter @Setter private String dni;
    @Getter @Setter private String email;
    @Persistent(mappedBy="cliente")
    @Getter @Setter ArrayList<Entrada> entradas;
    
}
