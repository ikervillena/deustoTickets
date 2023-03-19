package dataAccess.rmi.server;

import business.*;
import dataAccess.rest.client.RestClient;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerUsuario extends UnicastRemoteObject implements IServerUsuario {

    private static final long serialVersionUID = 1L;
    private int cont = 0;

    protected ServerUsuario() throws RemoteException
    {
        super();
    }

    @Override
    public String sayHello()
    {
        cont++;
        System.out.println(" * Client number: " + cont);
        return "Hello World!";
    }

    @Override
    public ArrayList<Evento> getEventos() throws RemoteException {
        ArrayList<Evento> eventos = new ArrayList<>();
        System.out.println("size: "+eventos.size());
        return eventos;
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
        return null;
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


    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
            System.exit(0);
        }

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

        try
        {
            IServerUsuario objServer = new ServerUsuario();
            Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
            //Naming.rebind(name, objServer);
            registry.rebind(name, objServer);
            System.out.println("* Server '" + name + "' active and waiting...");
        }
        catch (Exception e)
        {
            System.err.println("- Exception running the server: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
