package business.clases;

import java.io.Serializable;
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
