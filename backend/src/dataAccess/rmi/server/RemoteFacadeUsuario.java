package dataAccess.rmi.server;

import business.appService.UsuarioAppService;
import business.clases.Artista;
import business.clases.Cliente;

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
    public String sayHello()
    {
        cont++;
        System.out.println(" * Client number: " + cont);
        return "Hello World! It works correctly";
    }

    @Override
    public ArrayList<business.clases.Evento> getEventos() throws RemoteException, IOException {
        return UsuarioAppService.getEventos();
    }

    @Override
    public ArrayList<Artista> getArtistas(business.clases.Evento e) throws RemoteException {
        //PENDIENTE
        return null;
    }

    @Override
    public ArrayList<business.clases.Precio> getPrecios(business.clases.Evento e) throws RemoteException {
        //PENDIENTE
        return null;
    }

    @Override
    public boolean comprarEntrada(business.clases.Entrada e) throws RemoteException {
        //PENDIENTE
        return false;
    }

    @Override
    public boolean enviarEmailConfirmacion(business.clases.Entrada e) throws RemoteException {
        //PENDIENTE
        return false;
    }

    @Override
    public ArrayList<business.clases.Entrada> getEntradas(business.clases.Cliente c) throws RemoteException {
        //PENDIENTE
        return null;
    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasenya) throws RemoteException {
        return UsuarioAppService.iniciarSesion(usuario, contrasenya);
    }

    @Override
    public boolean registrar(business.clases.Cliente c) throws RemoteException {
        return UsuarioAppService.registrar(c);
    }

    @Override
    public boolean actualizarDatos(business.clases.Cliente cAntiguo, business.clases.Cliente cNuevo) throws RemoteException {
        //PENDIENTE
        return false;
    }

}
