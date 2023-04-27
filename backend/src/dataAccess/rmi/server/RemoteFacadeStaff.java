package dataAccess.rmi.server;

import business.Evento;
import business.Staff;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteFacadeStaff extends UnicastRemoteObject implements IRemoteFacadeStaff{

    private static final long serialVersionUID = 1L;
    private int cont = 0;

    //private XAppService xAppService = new XAppService();

    protected RemoteFacadeStaff() throws RemoteException
    {
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
    public ArrayList<Evento> getEventos() throws IOException, RemoteException {
        //PENDIENTE
        return null;
    }


    @Override
    public Staff iniciarSesionStaff(String usuario, String contrasenya) throws RemoteException {
        //PENDIENTE
        return null;
    }

    @Override
    public boolean comprobarQR(String qr, Evento e) throws RemoteException {
        //PENDIENTE
        return false;
    }

}
