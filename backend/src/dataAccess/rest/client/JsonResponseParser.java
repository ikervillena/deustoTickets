package dataAccess.rest.client;


import business.clases.Artista;
import business.clases.Espacio;
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
            
            JSONObject espacioJson = atributos.getJSONObject("espacio").getJSONObject("data").getJSONObject("attributes");
            Espacio espacio = new Espacio();
            espacio.setNombre(espacioJson.getString("nombre"));
            espacio.setDireccion(espacioJson.getString("direccion"));

            
            Evento evento = new Evento(titulo, descripcion, fecha, aforo);
            evento.setEspacio(espacio);
            
            JsonResponseParser j = new JsonResponseParser();
            ArrayList<Artista> artistas = j.getArtistasDeEvento(evento, respuesta);
            evento.setArtistas(artistas);

            eventos.add(evento);
        }

        return eventos;
    }

    public static ArrayList<Artista> getArtistasDeEvento(Evento evento, String respuesta) throws JSONException {
        ArrayList<Artista> artistas = new ArrayList<>();
    
        JSONObject obj = new JSONObject(respuesta);
        JSONArray data = obj.getJSONArray("data");
    
        for (int i = 0; i < data.length(); i++) {
            JSONObject atributos = data.getJSONObject(i).getJSONObject("attributes");
    
            String titulo = atributos.getString("titulo");
            if (titulo.equals(evento.getTitulo())) {
                JSONArray artistasJson = atributos.getJSONObject("artistas").getJSONArray("data");    
                for (int j = 0; j < artistasJson.length(); j++) {
                    JSONObject artistaJson = artistasJson.getJSONObject(j).getJSONObject("attributes");
                    Artista artista = new Artista();
                    artista.setNombre(artistaJson.getString("nombre"));
                    artista.setEvento(evento);
                    artista.setDescripcion(artistaJson.getString("descripcion"));
                    //artista.setFecNac(new Date(artistaJson.getString("fecha_nacimiento")));
                    artistas.add(artista);
                }
            }
        }
        return artistas;
    }

}
