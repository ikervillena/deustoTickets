package dataAccess.rmi.server;

import business.*;
import business.appService.LoginAppService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteFacadeUsuario extends UnicastRemoteObject implements IRemoteFacadeUsuario {

    private static final long serialVersionUID = 1L;
    private int cont = 0;

    private LoginAppService loginAppService = new LoginAppService();

    protected RemoteFacadeUsuario() throws RemoteException {
        super();
    }

    @Override
    public String sayHello()
    {
        cont++;
        System.out.println(" * Client number: " + cont);
        return "Hello World! It works correctly";
    }

    @Override
    public ArrayList<Evento> getEventos() throws RemoteException {
        //PENDIENTE
        return null;
    }

    @Override
    public ArrayList<Artista> getArtistas(Evento e) throws RemoteException {
        //PENDIENTE
        return null;
    }

    @Override
    public ArrayList<Precio> getPrecios(Evento e) throws RemoteException {
        //PENDIENTE
        return null;
    }

    @Override
    public boolean comprarEntrada(Entrada e) throws RemoteException {
        //PENDIENTE
        return false;
    }

    @Override
    public boolean enviarEmailConfirmacion(Entrada e) throws RemoteException {
        //PENDIENTE
        return false;
    }

    @Override
    public ArrayList<Entrada> getEntradas(Cliente c) throws RemoteException {
        //PENDIENTE
        return null;
    }

    @Override
    public Cliente iniciarSesion(String usuario, String contrasenya) throws RemoteException {
        //PENDIENTE
        return loginAppService.iniciarSesion(usuario, contrasenya);
    }

    @Override
    public boolean registrar(Cliente c) throws RemoteException {
        //PENDIENTE
        return false;
    }

    @Override
    public boolean actualizarDatos(Cliente cAntiguo, Cliente cNuevo) throws RemoteException {
        //PENDIENTE
        return false;
    }

}
