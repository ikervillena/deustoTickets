package business.appService;

//Representa el patron de diseño "AppService"

import business.clases.Evento;
import dataAccess.rest.client.TicketProviderGateway;

import java.io.IOException;
import java.util.ArrayList;

public class UsuarioAppService {

    public static ArrayList<Evento> getEventos() throws IOException {
        TicketProviderGateway gateway = new TicketProviderGateway();
        return gateway.getEventos();
    }

}
