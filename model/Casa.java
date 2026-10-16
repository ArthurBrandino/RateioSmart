package model;

public class Casa {
    private String nome;
    private double leituraAtualLuz;

    public Casa() {}

    public Casa(String nome, double leituraInicialLuz) {
        this.nome = nome;
        this.leituraAtualLuz = leituraInicialLuz;
    }

    public String getNome() {
        return nome;
    }

    public double getLeituraAtualLuz() {
        return leituraAtualLuz;
    }

    public void setLeituraAtualLuz(double leituraAtualLuz) {
        this.leituraAtualLuz = leituraAtualLuz;
    }

    @Override
    public String toString() {
        return nome + " (Relógio: " + (leituraAtualLuz < 0 ? "Não configurado" : leituraAtualLuz + " kWh") + ")";
    }
}