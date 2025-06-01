package SistemaConsumoGas;


class CilindroGas {

    private int idCilindro;
    private float capacidadeMaxima;
    private float capacidadeAtual;
    private float qtdeUltimoAbastecimento;
    private float qtdeUltimoConsumo;

    // Construtor
    public CilindroGas(int idCilindro, float capacidadeMaxima) {
        if(capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("Capacidade máxima deve ser maior que zero.");
        }
        this.idCilindro = idCilindro;
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeMaxima; // A capacidade atual e com base na capacidade máxima
        this.qtdeUltimoAbastecimento = 0; // Inicialmente inicializado com a capacidade máxima
        this.qtdeUltimoConsumo = 0; // Inicialmente sem consumo
    }

    //Getters para tdos os atributos( setters não são necessários para todos os atributos, garantindo o encapsulamento)
    public int getIdCilindro() {
        return idCilindro;
    }
    public float getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    public float getCapacidadeAtual() {
        return capacidadeAtual;
    }
    public float getQtdeUltimoAbastecimento() {
        return qtdeUltimoAbastecimento;
    }
    public float getQtdeUltimoConsumo() {
        return qtdeUltimoConsumo;
    }
    
    /**
     * Registra o consumo de gás, atualizando os atributos e lançando exceção se necessário.
     * @param qtde A quantidade de gás a ser consumida.
     * @throws ConsumoExcedenteException Se a quantidade consumida for maior do que a disponível.
     */


    public boolean registrarConsumo(double qtde)throws ConsumoExcedenteException {
        if (qtde <= 0) {
            // Lança IllegalArgumentException, indicando um problema com o argumento de entrada
            throw new IllegalArgumentException("Quantidade de consumo deve ser maior que zero.");
        }
        if (qtde > capacidadeAtual) {
            // Lança ConsumoExcedenteException, conforme a regra de negócio
            // Consumo excede a capacidade atual
            throw new ConsumoExcedenteException(
                "Consumo excedente: Tentou consumir " + String.format("%.2f", qtde) + " unidades, mas há apenas " +
                String.format("%.2f", this.capacidadeAtual) + " unidades disponíveis no cilindro " + this.idCilindro + "."
            );
        }

        // Se chegou aqui, o consumo é válido. Atualiza os atributos.
        capacidadeAtual -= (float) qtde; // Diminui a capacidade atual
        qtdeUltimoConsumo = (float) qtde; // Atualiza o último consumo
        
      
        System.out.println("Cilindro " + this.idCilindro + ": Consumido " + String.format("%.2f", qtde) + " unidades. Capacidade atual: " + String.format("%.2f", this.capacidadeAtual));
        
        return true; // Consumo registrado com sucesso
    }

    @Override
    public String toString() {
        // Retorna uma representação em string do objeto CilindroGas
        // Inclui todos os atributos relevantes
        return "CilindroGas{" +
                "idCilindro=" + idCilindro +
                ", capacidadeMaxima=" + capacidadeMaxima +
                ", capacidadeAtual=" + capacidadeAtual +
                ", qtdeUltimoAbastecimento=" + qtdeUltimoAbastecimento +
                ", qtdeUltimoConsumo=" + qtdeUltimoConsumo +
                '}';
    }
  



}