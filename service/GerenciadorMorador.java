package service;

import model.Casas;
import model.Morador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastrar{
        Scanner leitor = new Scanner(System.in);
        boolean voltar = false;

        do{
                System.out.flush();
                System.out.println("**********************************");
                System.out.println("*            CADASTRO            *");
                System.out.println("**********************************");

                System.out.println();
                System.out.println("**********************************");
                System.out.println("*  1- Criar                      *");
                System.out.println("*  2- Atualizar                  *");
                System.out.println("*  3- Excluir                    *");
                System.out.println("*  0- Voltar                     *");
                System.out.println("**********************************");
                System.out.println("Escolha uma das opções:");
                int option = leitor.nextInt();

                
                switch(option){
                        case 1: System.out.println("Você escolheu a opção de Criar um Morador, pressione <ENTER> para continuar...");
                                leitor.nextLine();
                                Create(); break;

                        case 2: System.out.println("Você escolheu a opção de Atualizar um Morador, pressione <ENTER> para continuar...");
                                leitor.nextLine();
                                Update(); break;

                        case 3: System.out.println("Você escolheu a opção de Excluir um Morador, pressione <ENTER> para continuar...");
                                leitor.nextLine();
                                Delete(); break;

                        case 0: System.out.println("Você decidiu Sair, pressione <ENTER> para continuar...");
                                leitor.nextLine();
                                voltar = true; break;

                        default: System.out.println("Opção Inválida"); break;
                }
        }while(!voltar)
}

public class Create{
    Scanner leitor = new Scanner(System.in);
    private List listaMoradores = new ArrayList<>();
    private CasaService casaService = new CasaService();
    boolean voltar = false;

    do{
        System.out.flush();
        System.out.println("**********************************");
        System.out.println("*              CRIAR             *");
        System.out.println("**********************************");
        System.out.println();

        if (casasDisponiveis.isEmpty()) {
            System.out.println("⚠ Todas as casas já estão ocupadas!");
            System.out.println("Pressione <ENTER> para continuar...");
            leitor.nextLine();
            return;
        }

        System.out.println("Casas Disponíveis:");
        for (int i = 0; i < casasDisponiveis.size(); i++)
                System.out.println((i + 1) + " - " + casasDisponiveis.get(i));
        System.out.println();

        int opcaoCasa = -1;
        while (opcaoCasa < 1 || opcaoCasa > casasDisponiveis.size()) {
                System.out.print("Escolha o número correspondente à casa: ");
                if (leitor.hasNextInt()) {
                        opcaoCasa = leitor.nextInt();
                        leitor.nextLine();
                        
                        if (opcaoCasa < 1 || opcaoCasa > casasDisponiveis.size()) {
                                System.out.println("Opção inválida! Escolha um número da lista.");
                        }

                } else {
                        System.out.println("Digite apenas números inteiros.");
                        leitor.nextLine();
                }
        }

        Casas casaEscolhida = casasDisponiveis.get(opcaoCasa -1);


        System.out.println("Entre com o Nome do Morador: ");
        String nome = leitor.nextLine();

        System.out.println("Digite o número de pessoas: ");
        int pessoas = leitor.nextInt();
        leitor.nextLine();

        System.out.print("Digite a leitura atual do relógio de luz: ");
        double leituraLuz = leitor.nextDouble();
        leitor.nextLine();


        Morador novoMorador = new Morador(casaEscolhida, nome, pessoas, leituraLuz);
        System.out.println("Morador cadastrado com sucesso na casa: " + casaEscolhida + "!");


        System.out.print("Deseja Cadastrar outro morador? (S/N): ");
        String reposta = leitor.nextLine().trim();

        if (resposta.equalsIgnoreCase("N")) voltar = true;

       
    }while(!voltar)
    
}

public class Update{
    Scanner leitor = new Scanner(System.in);
    private List listaMoradores = new ArrayList<>();
    private CasaService casaService = new CasaService();
    boolean voltar = false;

    do{
        System.out.flush();
        System.out.println("**********************************");
        System.out.println("*            Atualizar           *");
        System.out.println("**********************************");
        System.out.println();

        if (listaMoradores.isEmpty()) {
            System.out.println("⚠ Nenhum morador cadastrado!");
            System.out.println("Pressione <ENTER> para continuar...");
            leitor.nextLine();
            return;
        }

        System.out.println("Moradores Existentes:");
        for (int i = 0; i < listaMoradores.size(); i++)
        {
                Morador m = listaMoradores.get(i);
                System.out.println((i + 1) + " - Casa: " + m.getCasa() + 
                       " | Nome: " + m.getNome() + 
                       " | Pessoas: " + m.getNumeroPessoas());
        }
        System.out.println();

        int opcao = -1;
        while (opcao < 1 || opcao > listaMoradores.size()) {
                System.out.print("Escolha o número correspondente ao morador: ");
                if (leitor.hasNextInt()) {
                        opcao = leitor.nextInt();
                        leitor.nextLine();
                        
                        if (opcao < 1 || opcao > listaMoradores.size()) {
                                System.out.println("Opção inválida! Escolha um número da lista.");
                        }

                } else {
                        System.out.println("Digite apenas números inteiros.");
                        leitor.nextLine();
                }
        }

        Morador moradorEscolhido = listaMoradores.get(opcao -1);


        System.out.flush();
        System.out.println("**********************************");
        System.out.println("*            Atualizar           *");
        System.out.println("**********************************");
        System.out.println();

        
        System.out.println((i + 1) + " - Casa: " + m.getCasa() + 
                       " | Nome: " + m.getNome() + 
                       " | Pessoas: " + m.getNumeroPessoas());
       

        System.out.println();
            System.out.println("**********************************");
            System.out.println("*  1- Casa                       *");
            System.out.println("*  2- Nome                       *");
            System.out.println("*  3- Pessoas                    *");
            System.out.println("*  0- Sair                       *");
            System.out.println("**********************************");
            System.out.println("Escolha oque será atualizado:");
            int option = leitor.nextInt();

        // ------------------------- Parei Aqui!!!!!!!
        switch(option){
                case 1: System.out.println("Você escolheu Atualizar a Casa do Morador, pressione <ENTER> para continuar...");
                        leitor.nextLine();
                        Cadastrar(); break;

                case 2: System.out.println("Você escolheu Atualizar o Nome do Morador, pressione <ENTER> para continuar...");
                        leitor.nextLine();
                        RateioAgua(); break;

                case 3: System.out.println("Você escolheu Atualizar a Quantidade de Pessoas do Morador, pressione <ENTER> para continuar...");
                        leitor.nextLine();
                        RateioLuz(); break;

                case 0: System.out.println("Você decidiu Sair, pressione <ENTER> para continuar...");
                        leitor.nextLine();;
                        sair = true; break;

                default: System.out.println("Opção Inválida"); break;
        }



        System.out.print("Deseja Cadastrar outro morador? (S/N): ");
        String reposta = leitor.nextLine().trim();

        if (resposta.equalsIgnoreCase("N")) voltar = true;

       
    }while(!voltar)
}