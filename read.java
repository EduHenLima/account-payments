import java.io.*;
import java.io.BufferedReader;

public class read{

    private static final String SEPARADOR = ";";

    public static void main() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("contas.csv")));
        String linha = null;

        while((linha = reader.readLine()) != null){
            String[] dadosUsuario = linha.split(SEPARADOR);
            System.out.println("Conta: " + dadosUsuario[0]);
            System.out.println("Valor: " + dadosUsuario[1]);
            System.out.println("Vencimento: " + dadosUsuario[2]);
            System.out.println("-----------------------------------\n");
        }
        reader.close();

        System.out.println("\n");
    }
}