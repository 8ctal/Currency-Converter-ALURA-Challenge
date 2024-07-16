package models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateRequest {

    public ExchangerAPI requestRates(String from) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/a28d8f3ee0a170311f08a19d/latest/" + from);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangerAPI.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa divisa.");
        }
    }
}
