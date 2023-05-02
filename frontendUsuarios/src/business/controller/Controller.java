package business.controller;

import dataAccess.rmi.client.ServiceLocator;

import java.rmi.RemoteException;

//Esta clase implementa el patron de diseño "Controller"
public class Controller {

    //Referencia a Service Locator
    private ServiceLocator serviceLocator;

    public Controller(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    /**
     * Metodo de inicio de sesion.
     * @param usuario
     * @param contrasenya
     * @return Devuelve el Cliente al que pertenece, o null si no es correcto.
     */
    public Cliente login(String usuario, String contrasenya) {
        try {
            return this.serviceLocator.getService().iniciarSesion(usuario, contrasenya);
        } catch (RemoteException e) {
            return null;
        }
    }

}
