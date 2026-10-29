package model;

/**
 * Representa um Morador cadastrado no sistema de rateio.
 * Cada morador está vinculado a uma casa específica e possui informações
 * sobre o seu nome e quantas pessoas residem com ele.
 */
public class Morador {
    
    // Nome ou identificador da casa à qual este morador pertence (ex: "Casa 1")
    private String casa;
    
    // Nome completo ou apelido do morador
    private String nome;
    
    // Quantidade de pessoas que moram nesta residência
    private int numeroPessoas;

    /**
     * Construtor vazio padrão.
     */
    public Morador() {}

    /**
     * Construtor completo para instanciar um novo morador preenchendo todos os seus dados.
     * 
     * @param casa A casa onde o morador reside.
     * @param nome O nome do morador.
     * @param numeroPessoas A quantidade de moradores na residência.
     */
    public Morador(String casa, String nome, int numeroPessoas) {
        this.casa = casa;
        this.nome = nome;
        this.numeroPessoas = numeroPessoas;
    }

    // ==================== GETTERS E SETTERS ====================

    public String getCasa() { 
        return casa; 
    }
    
    public void setCasa(String casa) { 
        this.casa = casa; 
    }

    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public int getNumeroPessoas() { 
        return numeroPessoas; 
    }
    
    public void setNumeroPessoas(int numeroPessoas) { 
        this.numeroPessoas = numeroPessoas; 
    }
}