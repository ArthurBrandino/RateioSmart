package service;

import model.Casa;
import model.Casas;
import model.Morador;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CasaService {
    private List<Casa> listaCasas = new ArrayList<>();

    public CasaService() {
        // Inicializa todas as casas do Enum com leitura 0.0 kWh por padrão
        for (Casas c : Casas.values()) {
            listaCasas.add(new Casa(c, 0.0));
        }
    }

    // Busca o objeto Casa correspondente ao Enum
    public Casa buscarPorEnum(Casas identificador) {
        for (Casa c : listaCasas) {
            if (c.getIdentificador() == identificador) {
                return c;
            }
        }
        return null;
    }

    // Atualiza a leitura do relógio da casa no fechamento do mês/rateio
    public void atualizarLeituraLuz(Casas identificador, double novaLeitura) {
        Casa casa = buscarPorEnum(identificador);
        if (casa != null) {
            casa.setLeituraAtualLuz(novaLeitura);
        }
    }

    // Retorna as casas do Enum que não estão ocupadas por nenhum morador
    public List<Casas> getCasasDisponiveis(List<Morador> listaMoradores) {
        Set<Casas> ocupadas = new HashSet<>();
        for (Morador m : listaMoradores) {
            if (m.getCasa() != null) {
                ocupadas.add(m.getCasa());
            }
        }

        List<Casas> disponiveis = new ArrayList<>();
        for (Casas c : Casas.values()) {
            if (!ocupadas.contains(c)) {
                disponiveis.add(c);
            }
        }
        return disponiveis;
    }
}