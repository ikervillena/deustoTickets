package dataAccess.rmi.client;

import dataAccess.rmi.server.IServerStaff;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {
        if (args.length != 3)
        {
            System.out.println("uso: java [policy] [codebase] cliente.Cliente [host] [port] [server]");
            System.exit(0);
        }

        if (System.getSecurityManager() == null)
        {
            System.setSecurityManager(new SecurityManager());
        }

        IServerStaff stubServer = null;

        /**
         * Try test message
         */
        try
        {
            Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
            String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
            //stubServer = (IServer) java.rmi.Naming.lookup(name);
            stubServer = (IServerStaff) registry.lookup(name);
            System.out.println("* Message coming from the server: '" + stubServer.sayHello() + "'");

        }
        catch (Exception e)
        {
            System.err.println("- Exception running the client: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
