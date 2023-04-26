package dataAccess.rmi.server;

import business.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//Esta interfaz define la API del Servidor. Representa el patron de diseño Remote Facade
public interface IRemoteFacadeUsuario extends Remote {

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
    ArrayList<Evento> getEventos() throws RemoteException;

    ArrayList<Artista> getArtistas(Evento e) throws RemoteException;

    ArrayList<Precio> getPrecios(Evento e) throws RemoteException;

    boolean comprarEntrada(Entrada e) throws RemoteException;

    boolean enviarEmailConfirmacion(Entrada e) throws RemoteException;

    ArrayList<Entrada> getEntradas(Cliente c) throws RemoteException;

    Cliente iniciarSesion(String usuario, String contrasenya) throws RemoteException;

    boolean registrar(Cliente c) throws RemoteException;

    boolean actualizarDatos(Cliente cAntiguo, Cliente cNuevo) throws RemoteException;

}
