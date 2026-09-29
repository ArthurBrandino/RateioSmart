package model;

public class Morador{
    public static class Morador {
        private Casas casa;
        private String nome;
        private int numeroPessoas;
        private double leituraAnteriorLuz;

        public Morador(Casas casa, String nome, int numeroPessoas, double leituraAnteriorLuz){
            this.casa = casa;
            this.nome = nome;
            this.numeroPessoas = numeroPessoas;
            this.leituraAnteriorLuz = leituraAnteriorLuz;
        }

        public Casas getCasa() { return casa; }
        public String getNome() { return nome; }
        public int getNumeroPessoas() { return numeroPessoas; }
        public double getLeituraAnteriorLuz() { return leituraAnteriorLuz; }
        public void setLeituraAnteriorLuz(double leitura) { this.leituraAnteriorLuz = leitura; }

    }
}