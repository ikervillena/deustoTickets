package business.entradas.enviarStrategy;


import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;

import java.util.ArrayList;

public class EnviarStrategy {

    private IEnviarStrategy strategy;

    public EnviarStrategy() {
        this.strategy = null;
    }

    public void setStrategy(IEnviarStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean enviar(ClienteDTO cliente, ArrayList<EntradaDTO> entradas, String direccion) {
        return strategy.enviar(cliente, entradas, direccion);
    }
}
