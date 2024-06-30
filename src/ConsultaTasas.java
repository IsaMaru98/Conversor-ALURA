import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaTasas {

    public Map<String, Double> buscaTasasPorMonedaBase(String monedaBase) {
        String API_KEY = "755913e93050568337376de4";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/"+monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();
            ConsultaTasas consultaTasas = new ConsultaTasas();
            MonedaDatos monedaDatos = gson.fromJson(json, MonedaDatos.class);
            return monedaDatos.conversion_rates();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("No encontré esa pelicula");

        }
    }
}