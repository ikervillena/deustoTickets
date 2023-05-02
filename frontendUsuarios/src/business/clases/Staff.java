package business.clases;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor

public class Staff extends Usuario implements Serializable {
    @Getter @Setter private int dni;
    @Getter @Setter private String email;
}
