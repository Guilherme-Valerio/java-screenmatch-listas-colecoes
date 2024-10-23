
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;


//Essa classe tem a mesma funcionalidade da Principal.java, porém aqui vou fazer uma REQUEST API

public class PrincipalComBusca {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.omdbapi.com/?t=matrix&apikey=e50cad54"))
            .build();
    }
}
