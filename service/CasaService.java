package service;

import model.Casa;
import model.Morador;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Serviço responsável por gerenciar as regras de negócio referentes às Casas.
 * Controla a lista de imóveis cadastrados, busca por nome, verificação de disponibilidade
 * e o gerenciamento das leituras do relógio de luz.
 */
public class CasaService {
    
    // Lista em memória que armazena todas as casas do sistema
    private List<Casa> listaCasas = new ArrayList<>();

    /**
     * Construtor da classe.
     * Inicializa a lista com as casas padrão do sistema. 
     * Nota: A leitura é iniciada com -1.0 para sinalizar que a casa 
     * ainda não passou pelo "primeiro acesso".
     */
    public CasaService() {
        // Criando 7 casas padrão de exemplo para a versão 1
        listaCasas.add(new Casa("Casa 1", -1.0));
        listaCasas.add(new Casa("Casa 2", -1.0));
        listaCasas.add(new Casa("Casa 3", -1.0));
        listaCasas.add(new Casa("Casa 4", -1.0));
        listaCasas.add(new Casa("Casa 5", -1.0));
        listaCasas.add(new Casa("Casa 6", -1.0));
        listaCasas.add(new Casa("Casa 7", -1.0));
    }

    /**
     * Busca um objeto Casa na lista através do seu nome.
     * 
     * @param nome O nome da casa que está sendo procurada.
     * @return O objeto Casa correspondente, ou null se não encontrar.
     */
    public Casa buscarPorNome(String nome) {
        for (Casa c : listaCasas) {
            // equalsIgnoreCase evita problemas se o usuário digitar maiúsculo/minúsculo
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Verifica se a casa está no seu primeiro acesso
     * 
     * @param nome O nome da casa a ser verificada.
     * @return true se for o primeiro acesso, false caso contrário.
     */
    public boolean isPrimeiroAcesso(String nome) {
        Casa c = buscarPorNome(nome);
        return c != null && c.getLeituraAtualLuz() < 0;
    }

    /**
     * Atualiza a leitura atual do relógio de luz de uma casa específica.
     * Utilizado tanto no primeiro acesso quanto no fechamento do mês.
     * 
     * @param nome O nome da casa.
     * @param novaLeitura O valor numérico da nova leitura em kWh.
     */
    public void atualizarLeituraLuz(String nome, double novaLeitura) {
        Casa casa = buscarPorNome(nome);
        if (casa != null) {
            casa.setLeituraAtualLuz(novaLeitura);
        }
    }

    /**
     * Filtra e retorna apenas as casas que NÃO estão ocupadas por nenhum morador no momento.
     * Utilizado para exibir opções válidas na hora de cadastrar um novo morador.
     * @param listaMoradores A lista atual de moradores cadastrados no sistema.
     * @return Uma lista com os nomes (String) das casas disponíveis.
     */
    public List<String> getCasasDisponiveis(List<Morador> listaMoradores) {
        // Cria um conjunto (Set) com os nomes das casas ocupadas (em letras maiúsculas para padronizar)
        Set<String> casasOcupadas = new HashSet<>();
        for (Morador m : listaMoradores) {
            if (m.getCasa() != null) {
                // Garante que compara a string convertida para maiúsculo
                casasOcupadas.add(m.getCasa().trim().toUpperCase());
            }
        }

        // Percorre todas as casas cadastradas e filtra as que NÃO estão no Set de ocupadas
        List<String> casasDisponiveis = new ArrayList<>();
        for (Casa c : listaCasas) {
            String nomeCasaFormatado = c.getNome().trim().toUpperCase();
            if (!casasOcupadas.contains(nomeCasaFormatado)) {
                // Adiciona o nome original (com as maiúsculas/minúsculas corretas) à lista
                casasDisponiveis.add(c.getNome());
            }
        }
        
        return casasDisponiveis;
    }
    
    /**
     * Retorna a lista completa de todas as casas cadastradas.
     */
    public List<Casa> getListaCasas() {
        return listaCasas;
    }
}
