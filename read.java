import java.io.*;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class read{

    private static final String SEPARADOR = ";";

    public static void main() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("contas.csv")));
        String linha = null;

        while((linha = reader.readLine()) != null){
            String[] dadosUsuario = linha.split(SEPARADOR);
            // System.out.println(Arrays.toString(dadosUsuario));
            System.out.println("Conta: " + dadosUsuario[0]);
            System.out.println("Valor: " + dadosUsuario[1]);
            System.out.println("Vencimento: " + dadosUsuario[2]);
            System.out.println("-----------------------------------\n");
        }
        reader.close();

        System.out.println("\n");
    }
}