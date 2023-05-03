package dataAccess.rmi.client;

import business.clases.Evento;
import business.controller.Controller;
import presentation.gui.*;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) throws IOException {

        ServiceLocator serviceLocator = new ServiceLocator();

        // args[0] = RMIRegistry IP
        // args[1] = RMIRegistry Port
        // args[2] = Service Name

        serviceLocator.setService(args[0], args[1], args[2]);

        System.out.println("\n\nEY\n\n");
        Controller controller = new Controller(serviceLocator);
        System.out.println("\n\nEY\n\n");

        for (Evento e : serviceLocator.getService().getEventos()) {
            System.out.println(e);
        }

        InicioStaff ventana = new InicioStaff(controller);
        ventana.setVisible(true);
    }

}
