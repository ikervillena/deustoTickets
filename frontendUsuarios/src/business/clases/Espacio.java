package business.clases;

import java.io.Serializable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class Espacio implements Serializable {

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
