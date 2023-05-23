package business.clases;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;
import java.util.Date;
import business.clases.Entrada;
import business.clases.dao.EntradaDAO;
import lombok.*;

import java.io.Serializable;

@PersistenceCapable
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @PrimaryKey
    @Getter @Setter private String dni;
    @Getter @Setter private String nombre;
	@Getter @Setter private String apellido;
    @Getter @Setter private String usuario;
    @Getter @Setter private String contrasenya;
    @Getter @Setter private Date fecNac;
    @Getter @Setter private String email;

    public ArrayList<Entrada> getEntradas() {
        EntradaDAO eDao = new EntradaDAO();
        ArrayList<Entrada> entradasCLiente = new ArrayList<Entrada>();
        ArrayList<Entrada> entradasDB = eDao.getEntrada();
        for (Entrada e:entradasDB){
            if (this.dni.equals(e.getDniCliente())){
                entradasCLiente.add(e);
            }
        }
        return entradasCLiente;
    }

    
}
