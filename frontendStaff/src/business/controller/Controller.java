package business.controller;

import business.clases.*;

import dataAccess.rmi.client.ServiceLocator;

import java.util.ArrayList;

//Esta clase implementa el patron de diseño "Controller"
public class Controller {

    private ServiceLocator serviceLocator;

    public Controller(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public ArrayList<Evento> getEventos() {
        try {
            return this.serviceLocator.getService().getEventos();
        } catch (Exception e) {
            return null;
        }
    }

    public Staff iniciarSesionStaff(String usuario, String contrasenya) {
        try {
            return this.serviceLocator.getService().iniciarSesionStaff(usuario,contrasenya);
        } catch (Exception e) {
            return null;
        }
    }

}
