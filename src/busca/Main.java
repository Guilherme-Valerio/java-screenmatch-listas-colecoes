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
        GeradorDeArquivo gerador = new GeradorDeArquivo();
        String cep = "";
        while(!cep.equalsIgnoreCase("sair")){
            System.out.println("Qual CEP deseja buscar?");
            cep = leitura.nextLine();

            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                listCep.add(consultaCep.buscaEndereco(cep));
                System.out.println(consultaCep.buscaEndereco(cep));
                
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        gerador.salvaJson(listCep);
        leitura.close();
    }
}
