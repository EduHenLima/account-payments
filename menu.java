import java.util.Scanner;
import javax.swing.JOptionPane;


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
            
            System.out.println("\n");
            System.out.println("*************************");
            System.out.println("*         Menu          *");
            System.out.println("*************************");
            System.out.println("* 1 - Inserir Valor     *");
            System.out.println("* 2 - Visualizar Contas *");
            System.out.println("* 3 - Pagar Contas      *");
            System.out.println("* 4 - Visualizar Saldo  *");
            System.out.println("* 0 - Sair              *");
            System.out.println("*************************");
            System.out.println("\n");

            
            Scanner selectOption = new Scanner(System.in);
            System.out.println("Selectione uma opção: \n");
            option = selectOption.nextInt();

            switch(option){
                case 1:
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
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("--Visualizar Contas--\n");

                    read accounts = new read();
                    accounts.main();


                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println("--Pagamento de contas--\n");
                    System.out.println("--Selecione a conta que quer pagar--\n");

                    paymentController selectPaymentType = new paymentController();
                    selectPaymentType.main();

                    break;
                case 4:
                    System.out.println(" ");
                    System.out.println("--Visualizar Saldo--\n");

                    System.out.println("Saldo atual: "+returnValue.getSaldo());

                    break;
                case 0:
                    continuar = false;
                    System.exit(0);
                    break;
            }
        }
    }
}
