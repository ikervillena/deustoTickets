package business.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String qr;
    @Getter @Setter private String titulo;
    @Getter @Setter private String descripcion;
    @Getter @Setter private Date fecha;
    @Getter @Setter private int aforo;
    @Getter @Setter private ArrayList<Entrada> entradas;

        public Evento(String titulo, String descripcion, Date fecha, int aforo) {
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.fecha = fecha;
            this.aforo = aforo;
        }

    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", aforo=" + aforo +
                '}';
    }
}
