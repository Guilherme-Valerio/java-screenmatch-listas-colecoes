package conversor_moedas;

import java.io.IOException;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor{
    public String Coins(int typeCoin, double value){
        String coin = "";
        String exchange = "";

        switch(typeCoin) {
            case 1 -> {coin = "USD"; exchange = "ARS";}
            case 2 -> {coin = "ARS"; exchange = "USD";}
            case 3 -> {coin = "USD"; exchange = "BRL";}
            case 4 -> {coin = "BRL"; exchange = "USD";}
            case 5 -> {coin = "USD"; exchange = "COP";}
            case 6 -> {coin = "COP"; exchange = "USD";}
            case 7 -> {coin = "USD"; exchange = "EUR";}
            case 8 -> {coin = "EUR"; exchange = "USD";}
            case 9 -> {coin = "USD"; exchange = "GBP";}
            case 10 -> {coin = "GBP"; exchange = "USD";}
            default -> throw new AssertionError();
        }

        // Setting URL
        URI address = URI.create("https://v6.exchangerate-api.com/v6/5f08b7d642574c3c04dfa3f0/latest/" + coin);

        // Making Request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(address)
            .build();
        
        // Getting the Request
        try {
            HttpResponse<String>response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
            
             // Parse JSON response
             Gson gson = new Gson();
             ExchangeRateResponse apiResponse = gson.fromJson(response.body(), ExchangeRateResponse.class);
 
             // Extract rate and calculate
             double rate = apiResponse.getRate(exchange);
             if (rate == 0.0) {
                 return "Exchange rate not found for" + exchange;
             }

            double convertedValue = value * rate;

            return "Value converted from " + coin + " to " + exchange + ": " + convertedValue;

        } catch (IOException | InterruptedException | IllegalStateException ex) {
            throw new RuntimeException("Error getting data from API: " + ex.getMessage());
        }
    }
}
