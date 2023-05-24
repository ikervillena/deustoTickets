package dataAccess.rmi.server;

import business.appService.StaffAppService;
import business.clases.Evento;
import business.clases.Staff;
import business.clases.dto.*;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteFacadeStaff extends UnicastRemoteObject implements IRemoteFacadeStaff {

    private static final long serialVersionUID = 1L;
    private int cont = 0;

    // private XAppService xAppService = new XAppService();

    protected RemoteFacadeStaff() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() {
        cont++;
        System.out.println(" * Client number: " + cont);
        return "Hello World! It works correctly";
    }

    @Override
    public ArrayList<Evento> getEventos() throws IOException, RemoteException {
        return StaffAppService.getEventos();
    }

    @Override
    public Staff iniciarSesionStaff(String usuario, String contrasenya) throws RemoteException {
        return StaffAppService.iniciarSesion(usuario, contrasenya);
    }

    @Override
    public boolean comprobarQR(String qr, Evento e) throws RemoteException {
        // PENDIENTE
        return false;
    }

    @Override
    public boolean utilizarEntrada(EntradaDTO e) throws RemoteException {
        return StaffAppService.utilizarEntrada(e);
    }

}
