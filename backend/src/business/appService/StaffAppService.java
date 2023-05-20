package business.appService;

//Representa el patron de diseño "AppService"

import business.clases.*;
import dataAccess.dao.*;
import dataAccess.rest.client.TicketProviderGateway;
import java.rmi.RemoteException;
import java.io.IOException;
import java.util.ArrayList;

public class StaffAppService {
    public static ArrayList<Evento> getEventos() throws IOException {
        TicketProviderGateway gateway = new TicketProviderGateway();
        return gateway.getEventos();
    }
    
    public static Staff iniciarSesion(String usuario, String contrasenya) throws RemoteException{
        Staff s = new Staff();
        StaffDAO staffDAO=new StaffDAO();
        ArrayList<Staff> listaStaff=staffDAO.getStaff();
        s = null;
        for (Staff staff : listaStaff) {
            if (staff.getUsuario().equals(usuario) && staff.getContrasenya().equals(contrasenya)) {
                s = staff;
                break;
            }
        }
        return s;
    }

}
