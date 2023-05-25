package dataAccess.rmi.server;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import business.clases.Evento;
import business.clases.dto.*;

//Esta interfaz define la API del Servidor. Representa el patron de diseño Remote Facade
public interface IRemoteFacadeUsuario extends Remote {

    ArrayList<business.clases.Evento> getEventos() throws RemoteException, IOException;

    ArrayList<business.clases.Artista> getArtistasDeEvento(Evento e) throws RemoteException, IOException;

    ArrayList<EntradaDTO> comprarEntradas(ArrayList<EntradaDTO> entradas) throws RemoteException;

    boolean enviarEntradas(ArrayList<EntradaDTO> entradas, String direccion, boolean porEmail) throws RemoteException;

    ClienteDTO iniciarSesion(String usuario, String contrasenya) throws RemoteException;

    boolean registrar(ClienteDTO c) throws RemoteException;

    boolean actualizarDatos(ClienteDTO cAntiguo, ClienteDTO cNuevo) throws RemoteException;

}
