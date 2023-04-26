import business.Evento;
import dataAccess.rest.client.RestClient;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        TicketProviderGateway gateway = new TicketProviderGateway();
        ArrayList<Evento> eventos = gateway.getEventos();

        System.out.println("Lista de eventos:");

        for(Evento e : eventos) {
            System.out.println(e);
        }

    }
}