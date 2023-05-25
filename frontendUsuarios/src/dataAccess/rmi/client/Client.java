package dataAccess.rmi.client;

import business.clases.Evento;
import business.clases.dto.ClienteDTO;
import business.controller.Controller;
import presentation.gui.DescargaEntrada;
import presentation.gui.Inicio;
import presentation.gui.InicioSesion;

import java.io.IOException;
import java.time.temporal.TemporalQuery;

public class Client {

    public static void main(String[] args) throws IOException {

        ServiceLocator serviceLocator = ServiceLocator.getInstance();

        // args[0] = RMIRegistry IP
        // args[1] = RMIRegistry Port
        // args[2] = Service Name

        serviceLocator.setService(args[0], args[1], args[2]);

        Controller controller = new Controller(serviceLocator);
        InicioSesion inicio = new InicioSesion(controller);
        inicio.setVisible(true);

    }

}
