package dataAccess.googleMapsGateway;

import java.io.IOException;

import com.google.maps.GeocodingApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class GoogleMapsGateway implements IGoogleMapsGateway{

    private static String apiKey = "AIzaSyD2LQGliev2w0V25EmqhXI5yL-TZWPz2BY";

    public GoogleMapsGateway() {
    }

    @Override
    public String getCodigoPostal(String address) {
        try {
            // Crear el contexto de la API de Google Maps
            GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();

            // Geocodificar la dirección dada
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();

            // Obtener el primer resultado de la geocodificación
            GeocodingResult result = results[0];

            // Obtener el codigo postal de la dirección dada
            String codPostal = "";

            for (AddressComponent component : result.addressComponents) {
                AddressComponentType[] types = component.types;
                for (AddressComponentType type : types) {
                    if (type == AddressComponentType.POSTAL_CODE) {
                        codPostal = component.longName;
                        break;
                    }
                }
                if (!codPostal.isEmpty()) {
                    break;
                }
            }

            // Devolver el codigo postal
            return codPostal;
        } catch (IOException | InterruptedException | ApiException e) {
            // Manejar las excepciones aquí
            e.printStackTrace();
            return null; // O devuelve un valor por defecto o lanza una excepción personalizada
        }
    }


}
