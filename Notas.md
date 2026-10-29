# 📌 Status da Sessão - RateioSmart

## ⚙️ O que foi feito hoje 16/10:
- **Refatoração do `GerenciadorMorador.java`:**
  - Ajuste nos fluxos e menus do CRUD.
  - Correção das validações de entrada para evitar exceções ao digitar letras ou opções inválidas.
  - Ajuste na lógica do `delete()` para tratar o cancelamento caindo propositalmente no `case 0` com aviso ao usuário.
  - Tratamento de telas quando a lista de moradores está vazia.

- **Reestruturação das Models (`Casa` e `Morador`):**
  - Decisão de desvincular a leitura do relógio de luz do `Morador` e associá-la fisicamente à `Casa`.
  - Simplificação do identificador da casa (usando `String nome` em vez do Enum `Casas` para deixar o modelo mais flexível).
  - Preparação do atributo de leitura inicial com `-1.0` para identificar o primeiro acesso/configuração do imóvel.

---

## ⚙️ O que foi feito hoje 29/10:
- **Correções de Validação e Regras de Negócio:**
  - Ajuste no cadastro para garantir que o número de pessoas seja estritamente maior do que 1.

- **Correção de Bugs nos Fluxos de Atualização (`CRUD`):**
  - Correção do bug de salto de linha e travamento ao teclar `ENTER` nos campos de atualização de *Pessoas* e *Nome*.

- **Aprimoramento de Interface e Experiência (CLI):**
  - Implementação da função utilitária `limparTela()` utilizando sequências de escape ANSI para limpar a tela de forma limpa e profissional ao transitar entre menus.
  - Configuração do ambiente para permitir a execução direta do programa no PowerShell.
  - Implementação do método `verificarListaVazia()` para centralizar e padronizar as validações de listas vazias pelo sistema.

- **Qualidade de Código:**
  - Documentação e comentários adicionados ao longo do código para facilitar a manutenção.



## 🎯 O que preciso fazer na próxima sessão:

### 1. Persistência de Dados (Arquivo JSON)
- [ ] Definir a biblioteca para manipulação do JSON (ex: Jackson / Gson).
- [ ] Criar a classe responsável por ler e gravar o arquivo `dados.json` na raiz do projeto.
- [ ] Garantir que o `CasaService` e o `GerenciadorMorador` carreguem os dados salvos ao iniciar a aplicação e gravem as alterações ao cadastrar/atualizar/excluir.

### 2. Regras de Negócio e Rateio (Água e Luz)
- [ ] Decidir a arquitetura do rateio:
  - Fazer em módulos/entradas separadas OU unificar em um único fechamento de conta.
- [ ] Estruturar a lógica da **Água**:
  - A água será dividida proporcionalmente pelo **número total de pessoas** cadastrado no sistema (e não por leitura, já que a maioria das casas não possui relógio individual).
- [ ] Estruturar a lógica da **Luz**:
  - A luz será calculada pela diferença de consumo ($\text{Leitura Atual} - \text{Leitura Anterior}$) registrada em cada `Casa`.

---

## 🚀 Próximos Passos (Lista de Execução):
1. [ ] Atualizar o código das classes `Casa.java` e `Morador.java` para o modelo simplificado em `String`.
2. [ ] Atualizar o `CasaService.java` com a lista de casas padrão e a verificação do primeiro acesso (`-1.0`).
3. [ ] Implementar a gravação/leitura do `dados.json`.
4. [ ] Desenvolver o serviço de cálculo final do rateio (Água por pessoas + Luz por consumo do imóvel).
5. [ ] Configurar e validar o fluxo final de testes no `Main.java`.
6. [ ] Corrigir Bugs


## Correções :
1. Lista de Moradores tem q ser listada em ordem crescente