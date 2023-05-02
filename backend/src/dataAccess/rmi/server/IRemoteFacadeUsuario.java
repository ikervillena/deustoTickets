package dataAccess.rmi.server;

import business.clases.Artista;

import java.io.IOException;
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
    ArrayList<business.clases.Evento> getEventos() throws RemoteException, IOException;

    ArrayList<Artista> getArtistas(business.clases.Evento e) throws RemoteException;

    ArrayList<business.clases.Precio> getPrecios(business.clases.Evento e) throws RemoteException;

    boolean comprarEntrada(business.clases.Entrada e) throws RemoteException;

    boolean enviarEmailConfirmacion(business.clases.Entrada e) throws RemoteException;

    ArrayList<business.clases.Entrada> getEntradas(business.clases.Cliente c) throws RemoteException;

    business.clases.Cliente iniciarSesion(String usuario, String contrasenya) throws RemoteException;

    boolean registrar(business.clases.Cliente c) throws RemoteException;

    boolean actualizarDatos(business.clases.Cliente cAntiguo, business.clases.Cliente cNuevo) throws RemoteException;

}
