package business.clases;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;
import java.util.ArrayList;

import business.clases.Usuario;
import business.clases.Entrada;

import lombok.*;

import java.io.Serializable;

@PersistenceCapable
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private int dni;
    @Getter @Setter private String email;
    @Persistent(mappedBy="cliente")
    @Getter @Setter ArrayList<Entrada> entradas;
    
}
