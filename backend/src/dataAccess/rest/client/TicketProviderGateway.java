package dataAccess.rest.client;


import business.clases.Evento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class TicketProviderGateway implements ITicketProviderGateway {

    private String baseURL = "https://deusto-api.arambarri.eus/api/";
    private String token = "258c263f485581b788b509f2499f49418c640fa412a19ae2a96a7d93a38354f1b06e577ec301a213027acbcde59a9a8ce709862b8e8e6f59c90dbbe6f2a4c43582fa58f384bd7c45016bcd1e61c25358c0e3a9d592dc5e39d60b5825b931ec77ccb228ce133e1360902eb3ec8948aa13ba66bbd8f92df5e1cc5acd00848f1cce";

    public TicketProviderGateway() {
    }

    private String consultarAPI(String tabla) throws MalformedURLException {

        // URL del servidor REST
        URL url = new URL(baseURL + tabla);

        //Abrir conexión a la URL
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Crear una solicitud GET con encabezado de autenticación
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }
        connection.setRequestProperty("Authorization", "Bearer " + token);

        // Ejecutar la solicitud y obtener la respuesta
        BufferedReader reader = null;
        String respuesta;
        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String responseContent = sb.toString();
            respuesta = responseContent;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Cerrar conexion
        connection.disconnect();

        return respuesta;
    }

    @Override
    public ArrayList<Evento> getEventos() throws IOException {
        return JsonResponseParser.getEventos(consultarAPI("eventos"));
    }
}
