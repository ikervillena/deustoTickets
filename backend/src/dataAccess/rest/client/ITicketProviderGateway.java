package dataAccess.rest.client;

import business.Evento;

import java.io.IOException;
import java.util.ArrayList;

//Esta interfaz define los metodos para interactuar con la API de TicketProvider
//Representa el patron de diseño "Gateway"
public interface ITicketProviderGateway {

    ArrayList<Evento> getEventos() throws IOException;

    // Otros metodos necesarios para interactuar con la API TicketProvider

}
