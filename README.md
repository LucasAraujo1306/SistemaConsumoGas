# Sistema de Controle de Consumo de Gás

Este projeto em Java simula o controle de consumo de gás em cilindros, aplicando os conceitos de **encapsulamento** e **tratamento de exceções** para garantir a robustez e a integridade dos dados.

---

## 🚀 Funcionalidades

O sistema permite:

* **Representar um Cilindro de Gás**: Cada cilindro possui uma capacidade máxima, capacidade atual e registra a quantidade do último consumo.
* **Registrar Consumo**: Realiza a retirada de gás do cilindro, atualizando sua capacidade atual.
* **Tratamento de Exceções Personalizadas**: Impede o consumo de gás em excesso e trata entradas inválidas de forma controlada.

---

## 🛠️ Tecnologias Utilizadas

* **Java**: Linguagem de programação principal.

---

## 📂 Estrutura do Projeto

O projeto é composto por três classes principais, organizadas no pacote `SistemaConsumoGas`:

1.  **`ConsumoExcedenteException.java`**:
    * Uma exceção personalizada (`checked exception`) que é lançada quando uma tentativa de consumo excede a capacidade atual do cilindro.
    * Herda de `Exception` e permite a passagem de uma mensagem de erro detalhada.

2.  **`CilindroGas.java`**:
    * Representa um cilindro de gás.
    * **Atributos**:
        * `idCilindro`: Identificador único do cilindro.
        * `capacidadeMaxima`: Capacidade total do cilindro (ex: 50 unidades).
        * `capacidadeAtual`: Quantidade de gás disponível no momento.
        * `qtdeUltimoAbastecimento`: Quantidade do último abastecimento (inicialmente igual à capacidade máxima).
        * `qtdeUltimoConsumo`: Quantidade de gás consumida na última operação.
    * **Métodos**:
        * `CilindroGas(int idCilindro, float capacidadeMaxima)`: Construtor que inicializa o cilindro. Lança `IllegalArgumentException` se a capacidade máxima for inválida.
        * **Getters** para todos os atributos, garantindo o encapsulamento.
        * `registrarConsumo(int qtde)`: Registra o consumo de gás.
            * Lança `IllegalArgumentException` se `qtde` for menor ou igual a zero.
            * Lança `ConsumoExcedenteException` se `qtde` for maior que `capacidadeAtual`.
            * Atualiza `capacidadeAtual` e `qtdeUltimoConsumo`.
        * `toString()`: Retorna uma representação em string do estado atual do cilindro.

3.  **`Main.java`**:
    * Classe principal para execução da aplicação.
    * Demonstra a criação de um `CilindroGas` e a realização de operações de consumo.
    * Utiliza blocos `try-catch` para capturar e tratar as exceções `ConsumoExcedenteException` e `IllegalArgumentException`, exibindo mensagens de erro apropriadas.
    * Garante que a capacidade atual do cilindro seja sempre exibida ao final da execução, mesmo em caso de erro, utilizando um bloco `finally`.

---

