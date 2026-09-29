import java.util.Scanner;

public class Criar{
    Scanner leitor = new Scanner(System.in);
    private List listaMoradores = new ArrayList<>();
    boolean voltar = false;

    do{
        System.out.flush();
        System.out.println("**********************************");
        System.out.println("*              CRIAR             *");
        System.out.println("**********************************");
        System.out.println();

        if (casasDisponiveis.isEmpty()) {
            System.out.println("⚠ Todas as casas já estão ocupadas!");
            return;
        }

        System.out.print("Escolha o número correspondente à casa: ");
        int numero = leitor.nextLine();

        System.out.println("Entre com o Nome do Morador: ");
        String nome = leitor.nextLine();

        System.out.println("Digite o número de pessoas: ");
        String nome = leitor.nextLine();

        System.out.print("Digite a leitura atual do relógio de luz: ");
        double leituraLuz = leitor.nextDouble();
        leitor.nextLine();
       
    }while(!voltar)
    

}