package dataAccess.rmi.server;

import business.clases.*;
import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//Esta interfaz define la API del Servidor. Representa el patron de diseño Remote Facade
public interface IRemoteFacadeUsuario extends Remote {

    /**
     * Test message to say hello to client
     * 
     * @param
     * @return Message
     * @throws RemoteException
     */
    String sayHello() throws RemoteException;

    /**
     * Provee la lista de eventos
     * 
     * @return ArrayList con los eventos guardados en el servidor REST
     * @throws RemoteException
     */
    ArrayList<business.clases.Evento> getEventos() throws RemoteException, IOException;

    ArrayList<business.clases.Artista> getArtistasDeEvento(Evento e) throws RemoteException, IOException;

    ArrayList<Artista> getArtistas(business.clases.Evento e) throws RemoteException;

    ArrayList<business.clases.Precio> getPrecios(business.clases.Evento e) throws RemoteException;

    boolean comprarEntrada(EntradaDTO e) throws RemoteException;

    boolean enviarEntradas(ArrayList<EntradaDTO> entradas, String direccion, boolean porEmail) throws RemoteException;

    ArrayList<EntradaDTO> getEntradas(ClienteDTO cliente) throws RemoteException;

    ClienteDTO iniciarSesion(String usuario, String contrasenya) throws RemoteException;

    boolean registrar(ClienteDTO c) throws RemoteException;

    boolean actualizarDatos(ClienteDTO cAntiguo, ClienteDTO cNuevo) throws RemoteException;

}
