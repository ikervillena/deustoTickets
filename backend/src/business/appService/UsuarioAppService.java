package business.appService;

//Representa el patron de diseño "AppService"

import business.clases.*;
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
    
    public static ArrayList<Artista> getArtistasDeEvento(Evento e) throws IOException {
        TicketProviderGateway gateway = new TicketProviderGateway();
        return gateway.getArtistasDeEvento(e);
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
    public static Cliente iniciarSesion(String usuario, String contrasenya) throws RemoteException{
        Cliente c = new Cliente();
        ClienteDAO clientDao=new ClienteDAO();
        ArrayList<Cliente> listaClientes=clientDao.getClientes();
        c = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getUsuario().equals(usuario) && cliente.getContrasenya().equals(contrasenya)) {
                c = cliente;
                break;
            }
        }
        return c;
    }

    public static ArrayList<Entrada> getEntradas(Cliente cliente) throws RemoteException{
        ArrayList<Entrada> listaEntradas = new ArrayList<Entrada>();
        EntradaDAO entradaDAO= new EntradaDAO();
        ArrayList<Entrada> todas = entradaDAO.getEntrada();
        for (Entrada e: todas){
            if(e.getCliente().getUsuario().equals(cliente.getUsuario())){
                listaEntradas.add(e);
            }
        }
        return listaEntradas;
    } 
    


}
