package business.appService;

//Representa el patron de diseño "AppService"

import business.clases.*;
import business.clases.dao.*;
import business.clases.dto.ClienteAssembler;
import business.clases.dto.EntradaAssembler;
import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;
import business.entradas.enviarStrategy.EnviarStrategy;
import business.entradas.enviarStrategy.EnvioEmail;
import business.entradas.enviarStrategy.EnvioTelegram;
import dataAccess.rest.client.TicketProviderGateway;
import java.rmi.RemoteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;



public class UsuarioAppService {

    public static ArrayList<Evento> getEventos() throws IOException {
        TicketProviderGateway gateway = new TicketProviderGateway();
        return gateway.getEventos();
    }
    
    public static ArrayList<Artista> getArtistasDeEvento(Evento e) throws IOException {
        TicketProviderGateway gateway = new TicketProviderGateway();
        return gateway.getArtistasDeEvento(e);
    }


    public static boolean registrar(ClienteDTO dto) throws RemoteException {
        ClienteAssembler assembler =  new ClienteAssembler();
        Cliente c = assembler.getCliente(dto);
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
    public static ClienteDTO iniciarSesion(String usuario, String contrasenya) throws RemoteException{
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
        ClienteAssembler assembler = new ClienteAssembler();
        try {
            return assembler.assemble(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<EntradaDTO> getEntradas(ClienteDTO cliente) throws RemoteException{
        /*
        ArrayList<Entrada> listaEntradas = new ArrayList<Entrada>();
        EntradaDAO entradaDAO= new EntradaDAO();
        ArrayList<Entrada> todas = entradaDAO.getEntrada();
        for (Entrada e: todas){
            if(e.getCliente().getUsuario().equals(cliente.getUsuario())){
                listaEntradas.add(e);
            }
        }
        return listaEntradas;
        */

        // PENDIENTE
        return null;
    }

    public static boolean enviarEntradas(ArrayList<EntradaDTO> entradas, String direccion, boolean porEmail) throws RemoteException {
        EnviarStrategy strategy = new EnviarStrategy();
        if(porEmail) {
            strategy.setStrategy(new EnvioEmail());
        } else {
            strategy.setStrategy(new EnvioTelegram());
        }
        strategy.enviar(entradas.get(0).getCliente(), entradas, direccion);
        return true;
    }

    public static ArrayList<EntradaDTO> comprarEntradas(ArrayList<EntradaDTO> entradas){
        EntradaAssembler assembler = new EntradaAssembler();
        TicketProviderGateway t = new TicketProviderGateway();
        EntradaDAO entradaDAO = new EntradaDAO();

        for (EntradaDTO e: entradas){
            t.actualizarDisponibles(e.getPrecio().getId(), 1);
            Entrada entrada = assembler.getEntrada(e);
            UUID uuid = UUID.randomUUID();
            String stringQR = uuid.toString();
            entrada.setQr(stringQR);
            e.setQr(stringQR);
            entradaDAO.setEntrada(entrada);
        }

        
        return entradas;
    }



}
