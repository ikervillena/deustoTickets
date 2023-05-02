package business.clases;

import java.io.Serializable;
import lombok.*;
import java.util.ArrayList;
import business.clases.Entrada;

@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private int dni;
    @Getter @Setter private String email;
    @Getter @Setter ArrayList<Entrada> entradas;

}
