package busca;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {
    public void salvaJson(List<Endereco> listCep) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escrita = new FileWriter("cep.json")) {
            escrita.write(gson.toJson(listCep));
        }
   }
}
