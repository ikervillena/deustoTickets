package business.entradas.enviarStrategy;

import business.clases.Cliente;
import business.clases.Entrada;

import java.util.ArrayList;

public interface IEnviarStrategy {

    boolean enviar(Cliente cliente, ArrayList<Entrada> entradas, String direccion);

}
