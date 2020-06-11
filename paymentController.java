import java.io.*;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class paymentController{


    // Deve-se setar a data de vencimento da conta e paga-la
    // caso sobre dinheiro deve ser pago automaticamente outras contas que ainda tem saldo
    // informar que a conta foi paga

    private static final String SEPARADOR = ";";

    public static void main() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("contas.csv")));
        String linha = null;

        while((linha = reader.readLine()) != null){
            String[] dadosUsuario = linha.split(SEPARADOR);
            System.out.println(Arrays.toString(dadosUsuario));
        }
        reader.close();
        
        Scanner selectAccount = new Scanner(System.in);
        System.out.println("Qual conta você quer pagar ? ");
        
        int returnAccount = selectAccount.nextInt();

        // while(dadosUsuario[0] == )
        // System.out.println("A conta selecionada para pagar foi: " dadosUsuario[0]);

        // boolean paymentAccount = returnAccount.getSaldo();

        // System.out.println("Saldo antes do pagamento da conta: " + paymentAccount);

        // boolean paymentAccount = returnAccount.setRemoveValue(dadosUsuario[1]);


        // System.out.println("Saldo após o pagamento: " + paymentAccount);



        // if(deposito_efetuado==true){
        //     System.out.println("Depósito realizado com sucesso!");
        //     System.out.println("Saldo atual: "+returnValue.getSaldo());
        // }

        System.out.println("\n");
    }

}