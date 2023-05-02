package dataAccess.rmi.client;

import business.controller.Controller;
import presentation.gui.Inicio;

public class Client {

    public static void main(String[] args) {

        ServiceLocator serviceLocator = new ServiceLocator();

        //args[0] = RMIRegistry IP
        //args[1] = RMIRegistry Port
        //args[2] = Service Name

        serviceLocator.setService(args[0], args[1], args[2]);

        Controller controller = new Controller(serviceLocator);
        Inicio inicio = new Inicio(controller);
        inicio.setVisible(true);
    }

}
