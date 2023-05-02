package business.clases;

import java.io.Serializable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

public class Staff extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private int dni;
    @Getter @Setter private String email;
}
