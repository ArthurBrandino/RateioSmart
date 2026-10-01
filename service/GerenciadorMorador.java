package service;

import model.Casas;
import model.Morador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorMorador{

        private Scanner leitor = new Scanner(System.in);
        private List listaMoradores = new ArrayList<>();
        private CasaService casaService = new CasaService();


        //----------------------------- MENU ----------------------------------------
        public void menu(){
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
                        leitor.nextLine();
                        
                        switch(option){
                                case 1: System.out.println("Você escolheu a opção de Criar um Morador, pressione <ENTER> para continuar...");
                                        leitor.nextLine();
                                        create(); break;

                                case 2: System.out.println("Você escolheu a opção de Atualizar um Morador, pressione <ENTER> para continuar...");
                                        leitor.nextLine();
                                        update(); break;

                                case 3: System.out.println("Você escolheu a opção de Excluir um Morador, pressione <ENTER> para continuar...");
                                        leitor.nextLine();
                                        delete(); break;

                                case 0: System.out.println("Você decidiu Sair, pressione <ENTER> para continuar...");
                                        leitor.nextLine();
                                        voltar = true; break;

                                default: System.out.println("Opção Inválida"); break;
                        }
                }while(!voltar);
        }

        //------------------------------------ CRUD --------------------------------------
        public void create(){
                boolean voltar = false;

                do{
                        System.out.flush();
                        System.out.println("**********************************");
                        System.out.println("*              CRIAR             *");
                        System.out.println("**********************************");
                        System.out.println();

                        Casas casaEscolhida = mostrarCasasDisponiveis();
                        if (casaEscolhida == null) return;

                        System.out.println("Entre com o Nome do Morador: ");
                        String nome = leitor.nextLine();

                        System.out.println("Digite o número de pessoas: ");
                        int pessoas = leitor.nextInt();
                        leitor.nextLine();

                        System.out.print("Digite a leitura atual do relógio de luz: ");
                        double leituraLuz = leitor.nextDouble();
                        leitor.nextLine();


                        Morador novoMorador = new Morador(casaEscolhida, nome, pessoas, leituraLuz);
                        listaMoradores.add(novoMorador);
                        System.out.println("Morador cadastrado com sucesso na casa: " + casaEscolhida + "!");


                        System.out.print("Deseja Cadastrar outro morador? (S/N): ");
                        String resposta = leitor.nextLine().trim();

                        if (resposta.equalsIgnoreCase("N")) voltar = true;

                }while(!voltar);
        }

        public void update(){
                boolean voltar = false;

                do{
                        System.out.flush();
                        System.out.println("**********************************");
                        System.out.println("*            Atualizar           *");
                        System.out.println("**********************************");
                        System.out.println();

                        Morador moradorEscolhido =  mostrarMoradores();
                        if (moradorEscolhido == null) break;

                        boolean sair = false;
                        do{
                                System.out.flush();
                                System.out.println("**********************************");
                                System.out.println("*            Atualizar           *");
                                System.out.println("**********************************");
                                System.out.println();

                                identificarMorador(moradorEscolhido);

                                System.out.println("*  1- Casa                       *");
                                System.out.println("*  2- Nome                       *");
                                System.out.println("*  3- Pessoas                    *");
                                System.out.println("*  0- Sair                       *");
                                System.out.println("**********************************");
                                System.out.println("Escolha oque será atualizado:");
                                int option = leitor.nextInt();
                                leitor.nextLine();

                                switch(option){
                                        case 1: System.out.println("Você escolheu Atualizar a Casa do Morador, pressione <ENTER> para continuar...");
                                                leitor.nextLine();
                                                Casas novaCasa = mostrarCasasDisponiveis();
                                                if (novaCasa != null) {
                                                        moradorEscolhido.setCasa(novaCasa);
                                                        System.out.println("Casa atualizada com sucesso!");
                                                }
                                                break;

                                        case 2: System.out.println("Você escolheu Atualizar o Nome do Morador, pressione <ENTER> para continuar...");
                                                leitor.nextLine();
                                                String novoNome = leitor.nextLine();
                                                moradorEscolhido.setNome(novoNome);
                                                System.out.println("Nome atualizado com sucesso!");
                                                break;

                                        case 3: System.out.println("Você escolheu Atualizar a Quantidade de Pessoas do Morador, pressione <ENTER> para continuar...");
                                                leitor.nextLine();
                                                int novasPessoas = leitor.nextLine();
                                                moradorEscolhido.setPessoas(novasPessoas);
                                                System.out.println("Número de pessoas atualizado com sucesso!");
                                                break;

                                        case 0: System.out.println("Operação Cancelada, pressione <ENTER> para continuar...");
                                                leitor.nextLine();;
                                                break;

                                        default: System.out.println("Opção Inválida"); break;
                                }
                                

                                System.out.print("Deseja Atualizar outra informação deste morador? (S/N): ");
                                String resposta = leitor.nextLine().trim();

                                if (resposta.equalsIgnoreCase("N")) sair = true;
                        }while(!sair);

                        System.out.print("Deseja Atualizar Outro Morador? (S/N): ");
                        String resposta = leitor.nextLine().trim();
                        if (resposta.equalsIgnoreCase("N")) voltar = true;
                }while(!voltar);
        }

        // FALTA ARRUMAR O DELETE, REESTRUTURAR O MODEL CASA PARA LEITURA DE LUZ SER VINCULADA A CASA E NÃO AO MORADOR!

        public void delete(){
                boolean voltar = false;

                do{
                        System.out.flush();
                        System.out.println("**********************************");
                        System.out.println("*              DELETAR           *");
                        System.out.println("**********************************");
                        System.out.println();

                        Morador moradorEscolhido =  mostrarMoradores();

                        System.out.flush();
                        System.out.println("**********************************");
                        System.out.println("*              DELETAR           *");
                        System.out.println("**********************************");
                        System.out.println();
                        identificarMorador(moradorEscolhido);

                        System.out.println();
                        System.out.println("**********************************");
                        System.out.println("*  1- Deletar                     *");
                        System.out.println("*  0- Cancelar                    *");
                        System.out.println("**********************************");
                        System.out.println("Escolha uma opção: ");
                        int option = leitor.nextInt();

                        switch(option){
                                case 1: System.out.print("Tem Certeza que irá DELETAR este morador? (S/N): ");
                                        String resposta = leitor.nextLine().trim();

                                        if (resposta.equalsIgnoreCase("S")){
                                                listaMoradores.remove(moradorEscolhido);
                                                break;
                                        }

                                case 0: System.out.println("Operação Cancelada, pressione <ENTER> para continuar...");
                                        leitor.nextLine();
                                        break;

                                default: System.out.println("Opção Inválida"); break;
                        }

                        System.out.print("Deseja Deletar outro morador? (S/N): ");
                        String resposta = leitor.nextLine().trim();

                        if (resposta.equalsIgnoreCase("N")) voltar = true;

                }while(!voltar);
        }



        // Funções  Auxiliares
        public void identificarMorador(Morador m){
                System.out.println( "Casa: " + m.getCasa() + 
                                " | Nome: " + m.getNome() + 
                                " | Pessoas: " + m.getNumeroPessoas());
                        System.out.println("**********************************");

        }

        public Morador mostrarMoradores(){
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

                return listaMoradores.get(opcao -1);
        }


        public Casas mostrarCasasDisponiveis() {
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

                return casasDisponiveis.get(opcaoCasa -1);
        }
}