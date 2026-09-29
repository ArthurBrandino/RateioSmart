
import java.util.Scanner;

public class Main{
    public static void main(){
        boolean sair = false;
        Scanner leitor = new Scanner(System.in);
        do{
            System.out.flush();
            System.out.println("**********************************");
            System.out.println("*         RATEIO SMART v1        *");
            System.out.println("**********************************");

            System.out.println();
            System.out.println("**********************************");
            System.out.println("*  1- Cadastrar Morador          *");
            System.out.println("*  2- Rateio de Água             *");
            System.out.println("*  3- Rateio de Luz              *");
            System.out.println("*  0- Sair                       *");
            System.out.println("**********************************");
            System.out.println("Escolha uma das opções:");
            int option = leitor.nextInt();
s
            switch(option){
                case 1: System.out.println("Você escolheu a opção de Cadastrar Morador, pressione <ENTER> para continuar...");
                        leitor.nextLine();
                        Cadastrar(); break;

                case 2: System.out.println("Você escolheu a opção de Rateio de Água, pressione <ENTER> para continuar...");
                        leitor.nextLine();
                        RateioAgua(); break;

                case 3: System.out.println("Você escolheu a opção de Rateio de Luz, pressione <ENTER> para continuar...");
                        leitor.nextLine();
                        RateioLuz(); break;

                case 0: System.out.println("Você decidiu Sair, pressione <ENTER> para continuar...");
                        leitor.nextLine();;
                        sair = true; break;

                default: System.out.println("Opção Inválida"); break;
            }


        }while(!sair);
        
    }
}