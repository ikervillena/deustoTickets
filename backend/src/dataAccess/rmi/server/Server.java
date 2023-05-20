package dataAccess.rmi.server;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import business.appService.UsuarioAppService;
import business.clases.*;

import java.util.ArrayList;
import java.util.Date;

import dataAccess.rest.client.TicketProviderGateway;
import dataAccess.rmi.server.RemoteFacadeUsuario;;

public class Server {

    public static void main(String[] args) throws IOException {

        if (args.length != 4) {
            System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [serverStaff] [ServerUsuario]");
            System.exit(0);
        }

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String nameStaff = "//" + args[0] + ":" + args[1] + "/" + args[2];
        String nameUsuario = "//" + args[0] + ":" + args[1] + "/" + args[3];

        try
        {
            Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));

            IRemoteFacadeStaff objServerStaff = new RemoteFacadeStaff();
            registry.rebind(nameStaff, objServerStaff);
            System.out.println("* Server '" + nameStaff + "' active and waiting...");

            IRemoteFacadeUsuario objServerUsuario = new RemoteFacadeUsuario();
            registry.rebind(nameUsuario, objServerUsuario);
            System.out.println("* Server '" + nameUsuario + "' active and waiting...");
        }
        catch (Exception e)
        {
            System.err.println("- Exception running the server: " + e.getMessage());
            e.printStackTrace();
        }
  
    }

}
