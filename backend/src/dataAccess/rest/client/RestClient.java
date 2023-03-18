package dataAccess.rest.client;

import business.Espacio;
import business.Evento;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {

    public static ArrayList<Evento> getEventos() throws IOException {
        // Crear un cliente HTTP
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // URL del servidor REST
        String url = "https://deusto-api.arambarri.eus/api/eventos";

        // Crear una solicitud GET con encabezado de autenticación
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Authorization", "Bearer 258c263f485581b788b509f2499f49418c640fa412a19ae2a96a7d93a38354f1b06e577ec301a213027acbcde59a9a8ce709862b8e8e6f59c90dbbe6f2a4c43582fa58f384bd7c45016bcd1e61c25358c0e3a9d592dc5e39d60b5825b931ec77ccb228ce133e1360902eb3ec8948aa13ba66bbd8f92df5e1cc5acd00848f1cce");

        // Ejecutar la solicitud y obtener la respuesta
        CloseableHttpResponse response = httpclient.execute(httpGet);

        ArrayList<Evento> eventos = new ArrayList<>();
        try {
            // Obtener el contenido de la respuesta como cadena de texto
            HttpEntity entity = response.getEntity();
            String respuesta = EntityUtils.toString(entity);
            eventos = parsearRespuesta(respuesta);
        } finally {
            // Cerrar la respuesta
            response.close();
        }
        return eventos;
    }

    private static ArrayList<Evento> parsearRespuesta(String respuesta) throws JSONException {
        ArrayList<Evento> eventos = new ArrayList<>();

        JSONObject obj = new JSONObject(respuesta);
        JSONArray data = obj.getJSONArray("data");

        for (int i = 0; i < data.length(); i++) {
            JSONObject atributos = data.getJSONObject(i).getJSONObject("attributes");

            String titulo = atributos.getString("titulo");
            String descripcion = atributos.getString("descripcion");
            Date fecha;
            try{
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                fecha = formato.parse(atributos.getString("fecha"));
            } catch (Exception e) {
                fecha = new Date(2,2,2);
            }
            int aforo = atributos.getInt("aforo");

            Evento evento = new Evento(titulo, descripcion, fecha, aforo, new Espacio("nombre", "direccion", new ArrayList<Evento>()));
            eventos.add(evento);
        }

        return eventos;
    }


}
