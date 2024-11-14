package conversor_moedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int typeCoin = 0;
      Double coin = 0.0;
      while(typeCoin != 11){
        System.out.println("""
        ************************************************************ 
                Seja bem-vindo/a ao Conversor de Moeda"

            1) Dólar =>> Peso Argentino
            2) Peso Argentino =>> Dólar
            3) Dólar =>> Real Brasileiro
            4) Real Brasileiro =>> Dólar
            5) Dólar =>> Peso Colombiano
            6) Peso Colombiano =>> Dólar
            7) Dólar =>> Euro
            8) Euro =>> Dólar
            9) Dólar = >> Libra
            10) Libra =>> Dólar
            11) Sair
            Escolha uma opção válida:
      
        ************************************************************       
        """);
        typeCoin = scanner.nextInt();
        
        if (typeCoin == 11){
            break;
        }

        System.out.println("What is the coin that you want to exchange?");
      }
    }
}
