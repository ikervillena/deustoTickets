package business.appService;

//Representa el patron de diseño "AppService"

import business.clases.Evento;
import business.clases.Cliente;
import dataAccess.dao.*;
import dataAccess.rest.client.TicketProviderGateway;
import java.rmi.RemoteException;
import java.io.IOException;
import java.util.ArrayList;



public class UsuarioAppService {

    public static ArrayList<Evento> getEventos() throws IOException {
        TicketProviderGateway gateway = new TicketProviderGateway();
        return gateway.getEventos();
    }

    public static boolean registrar(business.clases.Cliente c) throws RemoteException {
        ClienteDAO clientDao=new ClienteDAO();
        boolean b = true;
        ArrayList<Cliente> listaClientes=clientDao.getClientes();
        for (Cliente cl: listaClientes){
            System.out.println(cl);
            if(cl.getUsuario().equals(c.getUsuario())){
                b=false;
            }
        }
        if (b==true){
            clientDao.setCliente(c);
        }
        return b;
    }


}
