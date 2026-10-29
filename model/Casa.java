package model;

/**
 * Representa a entidade física de uma casa no sistema de rateio.
 */

public class Casa {
    
    // Identificador único da casa (ex: "Casa 1", "Casa 2")
    private String nome;
    
    // Armazena a leitura atual do relógio de luz em kWh.
    // Dica de negócio: Se o valor for menor que 0 (-1.0), indica que a casa 
    // ainda está no "primeiro acesso" e precisa ter sua leitura inicial configurada.
    private double leituraAtualLuz;

    /**
     * Construtor vazio padrão.
     * Necessário para frameworks de serialização (como bibliotecas de JSON) 
     * conseguirem instanciar o objeto automaticamente ao ler arquivos salvos.
     */
    public Casa() {}

    /**
     * Construtor completo para instanciar uma nova casa já definindo seu nome e leitura inicial.
     * 
     * @param nome Nome identificador da casa.
     * @param leituraInicialLuz Leitura inicial (geralmente -1.0 para sinalizar pendência de primeiro acesso).
     */
    public Casa(String nome, double leituraInicialLuz) {
        this.nome = nome;
        this.leituraAtualLuz = leituraInicialLuz;
    }

    // ==================== GETTERS E SETTERS ====================

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLeituraAtualLuz() {
        return leituraAtualLuz;
    }

    public void setLeituraAtualLuz(double leituraAtualLuz) {
        this.leituraAtualLuz = leituraAtualLuz;
    }

    // ==================== MÉTODOS AUXILIARES ====================

    /**
     * Sobrescrita do método toString() para formatar a exibição da casa no console.
     * Se a leitura for menor que 0, exibe "Não configurado". Caso contrário, mostra os kWh.
     */
    @Override
    public String toString() {
        return nome + " (Relógio: " + (leituraAtualLuz < 0 ? "Não configurado" : leituraAtualLuz + " kWh") + ")";
    }
}