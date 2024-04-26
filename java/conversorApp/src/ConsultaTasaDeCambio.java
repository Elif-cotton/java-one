import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {

    public double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b6aa4cce815b83bc252a6605/latest/"+
                monedaOrigen);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

            TasaDeCambio tasaDeCambio = new Gson().fromJson(response.body(), TasaDeCambio.class);

            double tasa = tasaDeCambio.conversion_rates().get(monedaDestino);

            return tasa;
        } else {
            throw new RuntimeException("Error al obtener la tasa de cambio. Código de estado: " + response.statusCode());
        }
    } catch (Exception e) {
        throw new RuntimeException("No se pudo obtener la tasa de cambio: " + e.getMessage());
    }
}

    public double convertir(double valor, double tasaDeCambio) {
        return valor * tasaDeCambio;
    }

    public TasaDeCambio buscarTasa(String monedaOrigen){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b6aa4cce815b83bc252a6605/latest/"+
                monedaOrigen);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TasaDeCambio.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa película.");
        }
    }



}
