package business.clases;

//import javax.jdo.annotations.Persistent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class Espacio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String nombre;
    @Getter @Setter private String direccion;
    

    @Override
    public String toString() {
        return "Espacio{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
