package dataAccess.rmi.server;

import business.clases.Evento;
import business.clases.Staff;
import business.clases.dto.EntradaDTO;
import business.clases.*;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//Esta interfaz define la API del Servidor. Representa el patron de diseño "Remote Facade"
public interface IRemoteFacadeStaff extends Remote {

    ArrayList<Evento> getEventos() throws IOException, RemoteException;

    Staff iniciarSesionStaff(String usuario, String contrasenya) throws RemoteException;

    boolean utilizarEntrada(EntradaDTO e) throws RemoteException;

}
