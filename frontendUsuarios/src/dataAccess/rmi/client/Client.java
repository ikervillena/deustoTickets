package dataAccess.rmi.client;

import business.clases.Evento;
import business.controller.Controller;
import presentation.gui.Inicio;
import presentation.gui.InicioSesion;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {

        ServiceLocator serviceLocator = new ServiceLocator();

        // args[0] = RMIRegistry IP
        // args[1] = RMIRegistry Port
        // args[2] = Service Name

        serviceLocator.setService(args[0], args[1], args[2]);

        Controller controller = new Controller(serviceLocator);
        InicioSesion inicio = new InicioSesion(controller);
        inicio.setVisible(true);

    }

}
