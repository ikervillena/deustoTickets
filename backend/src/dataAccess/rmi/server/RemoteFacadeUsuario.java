package dataAccess.rmi.server;

import business.appService.UsuarioAppService;
import business.clases.*;
import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;
import business.entradas.enviarStrategy.EnviarStrategy;
import business.entradas.enviarStrategy.EnvioEmail;
import business.entradas.enviarStrategy.EnvioTelegram;
import dataAccess.dao.ClienteDAO;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteFacadeUsuario extends UnicastRemoteObject implements IRemoteFacadeUsuario {

    private static final long serialVersionUID = 1L;
    private int cont = 0;

    protected RemoteFacadeUsuario() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() {
        cont++;
        System.out.println(" * Client number: " + cont);
        return "Hello World! It works correctly";
    }

    
    @Override
    public ArrayList<business.clases.Evento> getEventos() throws RemoteException, IOException {
        return UsuarioAppService.getEventos();
    } 

    @Override
    public ArrayList<business.clases.Artista> getArtistasDeEvento(Evento e) throws RemoteException, IOException {
        return UsuarioAppService.getArtistasDeEvento(e);
    }

    @Override
    public ArrayList<Artista> getArtistas(business.clases.Evento e) throws RemoteException {
        // PENDIENTE
        return null;
    }

    @Override
    public ArrayList<business.clases.Precio> getPrecios(business.clases.Evento e) throws RemoteException {
        // PENDIENTE
        return null;
    }

    @Override
    public boolean comprarEntrada(EntradaDTO e) throws RemoteException {
        // PENDIENTE
        return false;
    }

    @Override
    public boolean enviarEntradas(ArrayList<EntradaDTO> entradas, String direccion, boolean porEmail) throws RemoteException {
       return UsuarioAppService.enviarEntradas(entradas,direccion,porEmail);
    }

    @Override
    public ArrayList<EntradaDTO> getEntradas(ClienteDTO cliente) throws RemoteException {
        return UsuarioAppService.getEntradas(cliente);
    }

    @Override
    public ClienteDTO iniciarSesion(String usuario, String contrasenya) throws RemoteException {
        return UsuarioAppService.iniciarSesion(usuario, contrasenya);
    }

    @Override
    public boolean registrar(ClienteDTO c) throws RemoteException {
        return UsuarioAppService.registrar(c);
    }

    @Override
    public boolean actualizarDatos(ClienteDTO cAntiguo, ClienteDTO cNuevo)
            throws RemoteException {
        // PENDIENTE
        return false;
    }


}
