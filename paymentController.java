import java.io.*;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
import java.util.Scanner;

public class paymentController{

    // Deve-se setar a data de vencimento da conta e paga-la
    // caso sobre dinheiro deve ser pago automaticamente outras contas que ainda tem saldo
    // informar que a conta foi paga

    private static final String SEPARADOR = ";";

    public static void main() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("contas.csv")));
        String linha = null;
        Integer position = 0;
        Integer option = 0;
        HashMap<Integer, String> evenNumbers = new HashMap<>();

        while((linha = reader.readLine()) != null){
            String[] dadosUsuario = linha.split(SEPARADOR);
            System.out.println(Arrays.toString(dadosUsuario));

            evenNumbers.put(position, linha);
            position++;
        }
        Scanner selectOption = new Scanner(System.in);
        System.out.println("Selectione uma conta que você quer pagar: \n");
        option = selectOption.nextInt();

        System.out.println(evenNumbers.get(option));

        FileWriter arq = new FileWriter("contasPagas.csv");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("Contas Pagas\n");
        gravarArq.printf(evenNumbers.get(option));

        arq.close();

        System.out.println("O arquivo foi gravado e está dentro do seu diretório principal");

        reader.close();

        System.out.println("\n");
    }
}