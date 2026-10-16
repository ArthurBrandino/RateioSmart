package model;

public class Morador{
    private String casa;
    private String nome;
    private int numeroPessoas;

    public Morador() {}

    public Morador(String casa, String nome, int numeroPessoas, double leituraAnteriorLuz){
        this.casa = casa;
        this.nome = nome;
        this.numeroPessoas = numeroPessoas;
    }

    public String getCasa() { return casa; }
    public void setCasa(String casa) { this.casa = casa; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getNumeroPessoas() { return numeroPessoas; }
    public void setNumeroPessoas(int numeroPessoas) { this.numeroPessoas = numeroPessoas; }
    
}