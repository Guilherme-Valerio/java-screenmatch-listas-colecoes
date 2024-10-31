package busca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        List<Endereco> listCep = new ArrayList<>();
        ConsultaCep consultaCep = new ConsultaCep();
        String busca = "";
        while(!busca.equalsIgnoreCase("sair")){
            System.out.println("Qual CEP deseja buscar?");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            var cep = busca;
            try {
                listCep.add(consultaCep.buscaEndereco(cep));
                System.out.println(consultaCep.buscaEndereco(cep));
                
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        GeradorDeArquivo gerador = new GeradorDeArquivo();
        gerador.salvaJson(listCep);
        leitura.close();
    }
}
