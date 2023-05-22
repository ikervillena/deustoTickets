package business.entradas.enviarStrategy;

import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;

import java.util.ArrayList;

public interface IEnviarStrategy {

    boolean enviar(ClienteDTO cliente, ArrayList<EntradaDTO> entradas, String direccion);

}
