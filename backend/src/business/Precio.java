package business;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import lombok.*;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;

@NoArgsConstructor
@AllArgsConstructor
@PersistenceCapable

public class Precio {
    @Getter @Setter private String nombre;
    @Getter @Setter private int precio;
    @Getter @Setter private int disponibles;
    @Getter @Setter private int ofertadas;
}
