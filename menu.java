import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class menu{

    public static void main(String[] args)throws Exception{
        menu initial = new menu();
        initial.init();
    }

    public static void init() throws Exception{

        valueController returnValue = new valueController();

            boolean continuar = true;
            int option;

        while(continuar ==  true) {

            option = initMenu();

            switch(option){
                case 1:
                    caseOne(returnValue);
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("--Visualizar Contas--\n");

                    read accounts = new read();
                    accounts.main();

                    break;
                case 3:
                    caseThree(returnValue);

                    break;
                case 4:
                    System.out.println(" ");
                    System.out.println("--Visualizar Saldo--\n");
                    System.out.println("Saldo atual: "+returnValue.getSaldo());

                    break;
                case 5:
                    caseFive(returnValue);

                    break;
                case 0:
                    continuar = false;
                    System.exit(0);

                    break;
            }
        }
    }

    private static int initMenu() {
        int option;
        System.out.println("\n");
        System.out.println("*************************");
        System.out.println("*         Menu          *");
        System.out.println("*************************");
        System.out.println("* 1 - Inserir Valor     *");
        System.out.println("* 2 - Visualizar Contas *");
        System.out.println("* 3 - Pagar Contas      *");
        System.out.println("* 4 - Visualizar Saldo  *");
        System.out.println("* 5 - Pagar Automatico  *");
        System.out.println("* 0 - Sair              *");
        System.out.println("*************************");
        System.out.println("\n");


        Scanner selectOption = new Scanner(System.in);
        System.out.println("Selectione uma opção: \n");
        option = selectOption.nextInt();
        return option;
    }

    private static void caseOne(valueController returnValue) {
        System.out.println(" ");
        System.out.println("--Inserir Valor--\n");

        Scanner money = new Scanner(System.in);
        System.out.println("Quanto você quer depositar para pagar as contas ? ");

        int returnMoney = money.nextInt();

        boolean deposito_efetuado = returnValue.setSaldo(returnMoney);

        if(deposito_efetuado==true){
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Saldo atual: "+returnValue.getSaldo());
        }
    }

    private static void caseThree(valueController returnValue) throws IOException {
        String SEPARADOR = ";";

        System.out.println(" ");
        System.out.println("--Pagamento de contas--\n");
        System.out.println("--Selecione a conta que quer pagar--\n");

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("contas.csv")));
        String linha = null;
        Integer position = 0;
        Integer optionSelect = 0;
        double getSaldoConta = 0;
        double getPrice = 0;
        HashMap<Integer, String> evenNumbers = new HashMap<>();
        String arrayVerifyValue[];


        while((linha = reader.readLine()) != null){
            String[] dadosUsuario = linha.split(SEPARADOR);
            System.out.println((position) + " - " +(Arrays.toString(dadosUsuario)));

            evenNumbers.put(position, linha);
            position++;
        }
        Scanner selectOptionAccount = new Scanner(System.in);
        System.out.println("Selectione uma conta que você quer pagar: \n");
        optionSelect = selectOptionAccount.nextInt();

        arrayVerifyValue = evenNumbers.get(optionSelect).split(";");

        System.out.println("Você selecionou a conta: "+ arrayVerifyValue[0]);

        getPrice = Double.parseDouble(arrayVerifyValue[1]);

        getSaldoConta = returnValue.getSaldo();

        System.out.println(getSaldoConta);
        System.out.println(getPrice);

        verifyPrice(returnValue, reader, optionSelect, getSaldoConta, getPrice, evenNumbers);
    }

    private static void verifyPrice(valueController returnValue, BufferedReader reader, Integer optionSelect, double getSaldoConta, double getPrice, HashMap<Integer, String> evenNumbers) throws IOException {
        if(getSaldoConta >= getPrice){

            returnValue.setRemoveValue(getPrice);

            FileWriter arq = new FileWriter("contasPagas.csv");
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.printf("Contas Pagas\n");
            gravarArq.printf(evenNumbers.get(optionSelect));

            arq.close();

            System.out.println("A conta foi paga e foi criado um arquivo e está dentro do seu diretório principal");

            reader.close();
        }else{
            System.out.println("Desculpe, o saldo na sua conta é inferior a conta. Por gentileza insira um saldo");
        }
    }

    private static void caseFive(valueController returnValue) throws IOException {

        String linha;
        String[] arrayVerifyValue;
        double getSaldoConta;
        Integer optionSelect;
        System.out.println("--Pagamento Automatico Selecionado--\n");

        System.out.println("Saldo atual: "+returnValue.getSaldo());


        Scanner selectOptionAccountAuto = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("1 - Efetuar o pagamento automatico");
        System.out.println("2 - Voltar ao menu inicial");

        optionSelect = selectOptionAccountAuto.nextInt();

        if(optionSelect == 1){
            if(returnValue.getSaldo() == 0){
                System.out.println("Coloque algum valor para efetuar o pagamento automatico.");
            }else{
                paymentAutomatic(returnValue);
            }
        }
        else{
            System.out.println("2 - Voltar ao menu inicial");

        }
    }

    private static void paymentAutomatic(valueController returnValue) throws IOException {
        String linha;
        String[] arrayVerifyValue;
        double getSaldoConta;
        System.out.println("Pagamento automático realizado com os seguintes itens: \n");

        BufferedReader readerAuto = new BufferedReader(new InputStreamReader(new FileInputStream("contas.csv")));
        String separadorAuto = ";";
        Integer positionAuto = 0;
        HashMap<Integer, String> evenNumbersAuto = new HashMap<>();

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("pagamentoAutomatico.csv"));
        buffWrite.append("--Pagamento Automatico--");

        while((linha = readerAuto.readLine()) != null){

            String[] dadosUsuario = linha.split(separadorAuto);

            evenNumbersAuto.put(positionAuto, linha);

            arrayVerifyValue = evenNumbersAuto.get(positionAuto).split(";");

            getSaldoConta = returnValue.getSaldo();

            double tratedCount = Double.parseDouble(arrayVerifyValue[1]);

            if(getSaldoConta >= tratedCount){
                returnValue.setRemoveValue(tratedCount);
                buffWrite.append("\n");
                buffWrite.append((positionAuto) + " - " +(Arrays.toString(dadosUsuario)));
                System.out.println(arrayVerifyValue[0]);

            }
            if(getSaldoConta == 0){
                System.out.println("Seu saldo está zerado, por favor insira para realizar essa operação");
                break;
            }
        }

        response("\n", "Os itens acimas foram pagos com sucesso!. e o valor foi debitado de sua conta\n", "o Arquivo pagamento Automatico foi criado no seu diretorio.");

        buffWrite.close();
    }

    private static void response(String s, String s2, String s3) {
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s3);
    }
}
