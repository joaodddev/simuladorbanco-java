import java.util.Scanner;

public class SimuladorBanco {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria(
                "João",
                "Corrente",
                2500.00
        );

        int opcao = 0;

        System.out.println("*********");
        System.out.println("Cliente: " + conta.getNomeCliente());
        System.out.println("Tipo da conta: " + conta.getTipoConta());
        System.out.println("*********");

        String menu = """
            1 - Consultar saldo
            2 - Transferir valor
            3 - Receber valor
            4 - Exibir histórico
            5 - Sair
            """;

        while (opcao != 5) {
            System.out.println(menu);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> conta.consultarSaldo();

                case 2 -> {
                    System.out.print("Valor da transferência: ");
                    double valor = scanner.nextDouble();
                    conta.transferirValor(valor);
                }

                case 3 -> {
                    System.out.print("Valor a receber: ");
                    double valor = scanner.nextDouble();
                    conta.receberValor(valor);
                }

                case 4 -> conta.exibirHistorico();

                case 5 -> System.out.println("Encerrando sistema...");

                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
