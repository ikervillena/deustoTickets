package dataAccess.rest.client;


import business.clases.Artista;
import business.clases.Entrada;
import business.clases.Espacio;
import business.clases.Evento;
import business.clases.Precio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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
            
            TicketProviderGateway tg = new TicketProviderGateway();
            ArrayList<Artista> artistas = new ArrayList<Artista>();
            try {
                artistas = tg.getArtistasDeEvento(evento);
              }
              catch(IOException e) {
                e.printStackTrace();
              }
            evento.setArtistas(artistas);
            
            ArrayList<Precio> listaPrecios = new ArrayList<Precio>();
            try {
                listaPrecios = tg.getPreciosEvento(evento);
              }
              catch(IOException e) {
                e.printStackTrace();
              }
            evento.setPrecios(listaPrecios);
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
                    artista.setDescripcion(artistaJson.getString("descripcion"));
                    //artista.setFecNac(new Date(artistaJson.getString("fecha_nacimiento")));
                    artistas.add(artista);
                }
            }
        }
        return artistas;
    }

    public static ArrayList<Integer> getIDPrecios(String respuesta) throws JSONException {
        ArrayList<Integer> listaID = new ArrayList<Integer>();

        JSONObject obj = new JSONObject(respuesta);
        JSONArray data = obj.getJSONArray("data");

        for (int i = 0; i < data.length(); i++) {
            int id = data.getJSONObject(i).getJSONObject("attributes").getJSONObject("cliente").getJSONObject("data").getInt("id");
            if (id == 4) {
                listaID.add(data.getJSONObject(i).getInt("id"));
            }

        }
        return listaID;
    }

    public static ArrayList<Precio> getPreciosEvento(Evento evento, ArrayList<Integer> idPrecios, String respuesta) throws JSONException{
        ArrayList<Precio> listaPrecios = new ArrayList<Precio>();
        
        JSONObject obj = new JSONObject(respuesta);
        JSONArray data = obj.getJSONArray("data");

        for (int i = 0; i < data.length(); i++) {
            JSONObject atributos = data.getJSONObject(i).getJSONObject("attributes");
            String titulo = atributos.getString("titulo");
            if (titulo.equals(evento.getTitulo())) {
                JSONArray preciosJson = atributos.getJSONObject("precios").getJSONArray("data");
                for (int j = 0; j < preciosJson.length(); j++) {
                    for (Integer id: idPrecios){
                        if (id==preciosJson.getJSONObject(j).getInt("id")){
                            JSONObject precioJson = preciosJson.getJSONObject(j).getJSONObject("attributes");
                            Precio p = new Precio();
                            p.setNombre(precioJson.getString("nombre"));
                            p.setPrecio(precioJson.getInt("precio"));
                            p.setDisponibles(Integer.parseInt(precioJson.getString("disponibles")));
                            p.setOfertadas(Integer.parseInt(precioJson.getString("ofertadas")));
                            listaPrecios.add(p);
                        }
                    }
                }
            }
        }
        return listaPrecios;
    }

    public static Precio getPrecio(int IdPrecio, String respuesta) throws JSONException{
        Precio p = new Precio();
        JSONObject obj = new JSONObject(respuesta);
        JSONArray data = obj.getJSONArray("data");

        for (int i = 0; i < data.length(); i++) {
            if (IdPrecio==data.getJSONObject(i).getInt("id")){
                p.setId(data.getJSONObject(i).getInt("id"));
                JSONObject precioJson = data.getJSONObject(i).getJSONObject("attributes");
                p.setNombre(precioJson.getString("nombre"));
                p.setPrecio(precioJson.getInt("precio"));
                p.setDisponibles(Integer.parseInt(precioJson.getString("disponibles")));
                p.setOfertadas(Integer.parseInt(precioJson.getString("ofertadas")));
            }
        }
        return p;
    }

    public static Evento getEvento(int IdEvento, String respuesta) throws JSONException{
        Evento e = new Evento();
        JSONObject obj = new JSONObject(respuesta);
        JSONArray data = obj.getJSONArray("data");

        for (int i = 0; i < data.length(); i++) {
            if (IdEvento==data.getJSONObject(i).getInt("id")){
                e.setId(data.getJSONObject(i).getInt("id"));
                JSONObject eventoJson = data.getJSONObject(i).getJSONObject("attributes");
                e.setTitulo(eventoJson.getString("titulo"));
                e.setDescripcion(eventoJson.getString("descripcion"));
                e.setAforo(eventoJson.getInt("aforo"));
            }
        }
        return e;
    }

}
