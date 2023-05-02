package business.clases;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;

import business.clases.Usuario;
import lombok.*;

import java.io.Serializable;

@PersistenceCapable
@NoArgsConstructor
@AllArgsConstructor

public class Staff extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private int dni;
    @Getter @Setter private String email;
}
