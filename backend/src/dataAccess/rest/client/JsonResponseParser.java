package dataAccess.rest.client;


import business.clases.Evento;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JsonResponseParser {

    public static ArrayList<Evento> getEventos(String respuesta) throws JSONException {
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

            Evento evento = new Evento(titulo, descripcion, fecha, aforo);
            eventos.add(evento);
        }

        return eventos;
    }

}
