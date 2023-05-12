import business.clases.Evento;

import business.entradas.GeneradorEntrada;
import com.google.zxing.WriterException;
import dataAccess.rest.client.TicketProviderGateway;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, WriterException {

        GeneradorEntrada.generarEntradas("String para el QR", "nombre de ejemplo", "informacion de ejemplo", 20);

    }
}