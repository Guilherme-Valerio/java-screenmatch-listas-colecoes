import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Scanner;
import com.google.gson.Gson;

import br.com.alura.screenmatch.modelos.Titulo;

import java.net.http.HttpResponse;



//Essa classe tem a mesma funcionalidade da Principal.java, porém aqui vou fazer uma REQUEST API

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para buscar");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=e50cad54";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();
        HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        Titulo tituloJson = gson.fromJson(response.body(), Titulo.class);
        System.out.println(tituloJson);
    }
}
