package dataAccess.rmi.server;

import business.clases.Artista;
import business.clases.Evento;
import business.clases.Precio;
import business.clases.Cliente;
import business.clases.Entrada;

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
    ArrayList<Evento> getEventos() throws RemoteException, IOException;

    ArrayList<Artista> getArtistasDeEvento(Evento e) throws RemoteException, IOException;

    ArrayList<Artista> getArtistas(Evento e) throws RemoteException;

    ArrayList<Precio> getPrecios(Evento e) throws RemoteException;

    boolean comprarEntrada(Entrada e) throws RemoteException;

    boolean enviarEntradas(ArrayList<Entrada> entradas, String direccion, boolean porEmail) throws RemoteException;

    ArrayList<Entrada> getEntradas(Cliente cliente) throws RemoteException;

    Cliente iniciarSesion(String usuario, String contrasenya) throws RemoteException;
    
    boolean registrar(Cliente c) throws RemoteException;

    boolean actualizarDatos(Cliente cAntiguo, Cliente cNuevo) throws RemoteException;

}
