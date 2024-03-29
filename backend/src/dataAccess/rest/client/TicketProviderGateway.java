package dataAccess.rest.client;

import business.clases.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import dataAccess.rest.client.JsonResponseParser;

public class TicketProviderGateway implements ITicketProviderGateway {

    private String baseURL = "https://deusto-api.arambarri.eus/api/";
    private String token = "258c263f485581b788b509f2499f49418c640fa412a19ae2a96a7d93a38354f1b06e577ec301a213027acbcde59a9a8ce709862b8e8e6f59c90dbbe6f2a4c43582fa58f384bd7c45016bcd1e61c25358c0e3a9d592dc5e39d60b5825b931ec77ccb228ce133e1360902eb3ec8948aa13ba66bbd8f92df5e1cc5acd00848f1cce";

    public TicketProviderGateway() {
    }

    private String consultarAPI(String tabla) throws MalformedURLException {

        // URL del servidor REST
        URL url = new URL(baseURL + tabla);

        // Abrir conexión a la URL
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
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
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

        // Cerrar conexion
        connection.disconnect();

        return respuesta;
    }

    public void actualizarDisponibles(int idPrecio, int numEntradas) {

        try {
            int nuevosDisponibles = obtenerNuevasDisponibles(idPrecio,numEntradas);
            // Construir la URL de la API
            URL url = new URL(baseURL +"precios/"+idPrecio);
    
            // Abrir la conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    
            // Configurar la solicitud como PUT
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + token);
    
            // Crear el objeto JSON para enviar en el cuerpo de la solicitud
            String requestBody = "{\"data\": {\"disponibles\": \"" + nuevosDisponibles + "\"}}";
    
            // Habilitar el envío de datos en la solicitud
            connection.setDoOutput(true);
    
            // Escribir el cuerpo de la solicitud en la conexión
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
    
            // Obtener la respuesta de la API
            int responseCode = connection.getResponseCode();
    
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // La solicitud se realizó correctamente
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
    
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
    
                reader.close();
    
                // Hacer algo con la respuesta de la API, si es necesario
                System.out.println("La solicitud se realizó correctamente. Respuesta: " + response.toString());
            } else {
                // La solicitud falló
                System.out.println("La solicitud falló. Código de respuesta: " + responseCode);
            }
    
            // Cerrar la conexión
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int obtenerNuevasDisponibles (int idPrecio, int numEntradas)throws IOException{
        return JsonResponseParser.obtenerNuevasDisponibles(idPrecio,consultarAPI("eventos?populate=*"),numEntradas);
    }

    @Override
    public ArrayList<Evento> getEventos() throws IOException {
        return JsonResponseParser.getEventos(consultarAPI("eventos?populate=*"));
    }

    public ArrayList<Artista> getArtistasDeEvento(Evento e) throws IOException {
        return JsonResponseParser.getArtistasDeEvento(e, consultarAPI("eventos?populate=*"));
    }

    @Override
    public Precio getPrecio(int idPrecio) throws IOException {
        return JsonResponseParser.getPrecio(idPrecio, consultarAPI("precios?populate=*"));
    }

    @Override
    public Evento getEvento(int idEvento) throws IOException {
        return JsonResponseParser.getEvento(idEvento,consultarAPI("eventos?populate=*"));
    }
    
    public ArrayList<Integer> getIDPrecios(Evento e) throws IOException {
        return JsonResponseParser.getIDPrecios(consultarAPI("precios?populate=*"));
    }

    public ArrayList<Precio> getPreciosEvento(Evento e) throws IOException {
        ArrayList<Integer> idPrecios = getIDPrecios(e);
        return JsonResponseParser.getPreciosEvento(e, idPrecios, consultarAPI("eventos?populate=precios"));
    }

}
