package business.entradas.enviarStrategy;

import business.clases.Cliente;
import business.clases.Entrada;

import java.util.ArrayList;

public class EnviarStrategy {

    private IEnviarStrategy strategy;

    public EnviarStrategy() {
        this.strategy = null;
    }

    public void setStrategy(IEnviarStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean enviar(Cliente cliente, ArrayList<Entrada> entradas, String direccion) {
        return strategy.enviar(cliente, entradas, direccion);
    }
}
