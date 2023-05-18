package business.clases;

import java.io.Serializable;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;

import business.clases.*;
import lombok.*;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;
import java.util.ArrayList;


@NoArgsConstructor
@AllArgsConstructor
@PersistenceCapable
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String titulo;
    @Getter @Setter private String descripcion;
    @Getter @Setter private Date fecha;
    @Getter @Setter private int aforo;
	@Getter @Setter private ArrayList<Precio> precios;
    @Persistent(mappedBy = "evento")
	@Getter @Setter private ArrayList<Entrada> entradas;
    @Persistent(mappedBy = "evento")
	@Getter @Setter private ArrayList<Artista> artistas;
    @Column (name = "espacio_id")
    @Getter @Setter private Espacio espacio;


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
