import service.GerenciadorMorador;
import java.util.Scanner;
import static service.ConsoleUtils.limparTela;

/**
 * Classe principal do RateioSmart.
 * Inicia a aplicação exibindo o menu principal e direcionando para os módulos 
 * de Cadastro de Moradores, Rateio de Água e Rateio de Luz.
 */
public class Main {

    public static void main(String[] args) {
        boolean sair = false;
        Scanner leitor = new Scanner(System.in);
        
        // Instancia o gerenciador de moradores para chamar o menu de cadastro
        GerenciadorMorador gerenciadorMorador = new GerenciadorMorador();

        do {
            limparTela();
            System.out.println("********************************##");
            System.out.println("*          RATEIO SMART v1       *");
            System.out.println("**********************************");
            System.out.println();
            System.out.println("**********************************");
            System.out.println("*  1- Cadastrar Morador          *");
            System.out.println("*  2- Rateio de Água             *");
            System.out.println("*  3- Rateio de Luz              *");
            System.out.println("*  0- Sair                       *");
            System.out.println("**********************************");
            System.out.println("Escolha uma das opções:");

            if (!leitor.hasNextInt()) {
                System.out.println("Opção Inválida!");
                leitor.nextLine();
                continue;
            }

            int option = leitor.nextInt();
            leitor.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Você escolheu a opção de Cadastrar Morador, pressione <ENTER> para continuar...");
                    leitor.nextLine();
                    // Chama o menu de gerenciamento de moradores que criamos
                    gerenciadorMorador.menu(); 
                    break;

                case 2:
                    System.out.println("Você escolheu a opção de Rateio de Água, pressione <ENTER> para continuar...");
                    leitor.nextLine();
                    // TODO: Implementar o módulo de rateio de água na próxima sessão
                    break;

                case 3:
                    System.out.println("Você escolheu a opção de Rateio de Luz, pressione <ENTER> para continuar...");
                    leitor.nextLine();
                    // TODO: Implementar o módulo de rateio de luz na próxima sessão
                    break;

                case 0:
                    System.out.println("Você decidiu Sair, pressione <ENTER> para continuar...");
                    leitor.nextLine();
                    sair = true;
                    break;

                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (!sair);
        
        leitor.close();
        System.out.println("Aplicação encerrada com sucesso.");
    }
}