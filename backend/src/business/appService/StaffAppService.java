package business.appService;

//Representa el patron de diseño "AppService"

import business.clases.Evento;
import business.clases.Cliente;
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

}
