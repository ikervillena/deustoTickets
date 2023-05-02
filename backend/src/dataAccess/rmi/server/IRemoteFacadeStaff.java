package dataAccess.rmi.server;

import business.clases.Evento;
import business.clases.Staff;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//Esta interfaz define la API del Servidor. Representa el patron de diseño "Remote Facade"
public interface IRemoteFacadeStaff extends Remote {

    /**
     * Test message to say hello to client
     * @param
     * @return Message
     * @throws RemoteException
     */
    String sayHello() throws RemoteException;

    /**
     * Provee la lista de eventos
     * @return ArrayList con los eventos guardados en el servidor REST
     * @throws RemoteException
     */
    ArrayList<Evento> getEventos() throws IOException, RemoteException;

    /**
     * Gestiona el inicio de sesion de un miembro del Staff
     * @param usuario
     * @param contrasenya
     * @return Staff al que corresponden las credenciales o null en caso de que sean incorrectas
     * @throws RemoteException
     */
    Staff iniciarSesionStaff(String usuario, String contrasenya) throws RemoteException;

    /**
     * Comprueba la validez de un codigo QR
     * @param qr
     * @param e
     * @return True en caso de que el código QR corresponda a una entrada del evento que no haya sido utilizada, o False en caso contrario
     * @throws RemoteException
     */
    boolean comprobarQR(String qr, Evento e) throws RemoteException;

}
