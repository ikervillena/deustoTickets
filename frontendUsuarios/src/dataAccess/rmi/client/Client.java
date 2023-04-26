package dataAccess.rmi.client;

import business.controller.LoginController;
import presentation.gui.LoginView;

public class Client {

    public static void main(String[] args) {

        ServiceLocator serviceLocator = new ServiceLocator();

        //args[0] = RMIRegistry IP
        //args[1] = RMIRegistry Port
        //args[2] = Service Name

        serviceLocator.setService(args[0], args[1], args[2]);

        LoginController loginController = new LoginController(serviceLocator);
        LoginView loginView = new LoginView(loginController);
        loginView.setVisible(true);
    }

}
