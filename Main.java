package SistemaConsumoGas;

public class Main {
    public static void main(String[] args) {
        CilindroGas cilindro = null;

        System.out.println("-- Criando Cilindro de Gás --");

        try {
            // Instancia o cilindro com capacidade máxima de 50
            cilindro = new CilindroGas(1, 50.0f);
            System.out.println(cilindro.toString());
        } catch (ConsumoExcedenteException e) {
            System.err.println("Erro de consumo no construtor: " + e.getMessage());
            return;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar cilindro: " + e.getMessage());
            return;
        }

        System.out.println("\n--- Realizando Registros de Consumo ---");

        // 1. Consumo de 10 unidades
        try {
            cilindro.registrarConsumo(10);
        } catch (Exception e) {
            System.err.println("Erro no consumo de 10: " + e.getMessage());
        }

        // 2. Consumo de 5 unidades
        try {
            cilindro.registrarConsumo(5);
        } catch (Exception e) {
            System.err.println("Erro no consumo de 5: " + e.getMessage());
        }

        // 3. Consumo de 40 unidades (deve gerar exceção)
        try {
            cilindro.registrarConsumo(40);
        } catch (Exception e) {
            System.err.println("Erro no consumo de 40: " + e.getMessage());
        }

        // Exibe a capacidade final do cilindro
        System.out.println("\nCapacidade atual do cilindro: " +
            String.format("%.2f", cilindro.getCapacidadeAtual()) + " unidades.");
    }
}
