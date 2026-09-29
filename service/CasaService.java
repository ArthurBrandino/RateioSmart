// Retorna apenas as casas OCUPADAS
public List getCasasOcupadas(List listaMoradores) {
    return listaMoradores.stream()
            .map(Morador::getCasa)
            .toList();
}

// Retorna apenas as casas DISPONÍVEIS
public List getCasasDisponiveis(List listaMoradores) {
    List ocupadas = getCasasOcupadas(listaMoradores);
    return java.util.Arrays.stream(Casas.values())
            .filter(casa -> !ocupadas.contains(casa))
            .toList();
}