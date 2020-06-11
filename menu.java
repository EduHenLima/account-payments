import java.util.Scanner;

public class menu{

    public static void main(String[] args)throws Exception{
        menu initial = new menu();
        initial.initMenu();
    }

    public static void initMenu()throws Exception{
        menu initial = new menu();
        initial.init();
    }

    public static void init() throws Exception{
        
        System.out.println("\n");
        System.out.println("*************************");
        System.out.println("*         Menu          *");
        System.out.println("*************************");
        System.out.println("* 1 - Inserir Valor     *");
        System.out.println("* 2 - Visualizar Contas *");
        System.out.println("* 3 - Pagar Contas      *");
        System.out.println("* 0 - Sair              *");
        System.out.println("*************************");
        System.out.println("\n");

        
        Scanner selectOption = new Scanner(System.in);
        System.out.println("Selectione uma opção: \n");

        int option = selectOption.nextInt();

        if(option == 1){
            System.out.println(" ");
            System.out.println("--Inserir Valor--\n");


        }

        if(option == 2){
            System.out.println(" ");
            System.out.println("--Visualizar Contas--\n");

            read accounts = new read();
            accounts.main();

            Scanner backMenu = new Scanner(System.in);
            System.out.println("1 - Voltar ao menu inicial");
            System.out.println("0 - Sair\n");

            int backSelect = backMenu.nextInt();

            if(backSelect == 2){
                menu initialMenu = new menu();
                initialMenu.initMenu();
            }else{
                System.exit(0);
            }
        }

        if(option == 0){
            System.exit(0);
        }
    }
}
