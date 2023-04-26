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
            IRemoteFacadeStaff objServer = new RemoteFacadeStaff();
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
