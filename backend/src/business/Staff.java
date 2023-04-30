package business;

import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import lombok.*;

@PersistenceCapable
@NoArgsConstructor
@AllArgsConstructor

public class Staff extends Usuario {
    @Getter @Setter private int dni;
    @Getter @Setter private String email;
}
