import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar clientes
        Cliente cliente1 = new Cliente("João Silva", "12345678900");
        Cliente cliente2 = new Cliente("Maria Oliveira", "98765432100");

        // Criar contas
        ContaCorrente conta1 = new ContaCorrente(1, "João Silva", 1000.0);
        ContaCorrente conta2 = new ContaCorrente(2, "Maria Oliveira", 1500.0);

        // Adicionar contas aos clientes
        cliente1.adicionarConta(conta1);
        cliente2.adicionarConta(conta2);

        // Lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        // Menu de operações
        menu(scanner, clientes);
    }

    public static void exibirClientesEContas(List<Cliente> clientes) {
        System.out.println("Clientes e suas contas:");
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNome() + " - CPF: " + cliente.getCpf());
            cliente.exibirContas();
        }
    }

    public static void menu(Scanner scanner, List<Cliente> clientes) {
        int opcao;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Depositar em Conta");
            System.out.println("2. Sacar de Conta");
            System.out.println("3. Exibir Detalhes de Contas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirClientesEContas(clientes);
                    System.out.print("Digite o número da conta para depósito: ");
                    int numeroContaDeposito = scanner.nextInt();
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    realizarOperacaoEmConta(clientes, numeroContaDeposito, valorDeposito, true);
                    break;
                case 2:
                    exibirClientesEContas(clientes);
                    System.out.print("Digite o número da conta para saque: ");
                    int numeroContaSaque = scanner.nextInt();
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    realizarOperacaoEmConta(clientes, numeroContaSaque, valorSaque, false);
                    break;
                case 3:
                    exibirClientesEContas(clientes);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 4);
    }

    public static void realizarOperacaoEmConta(List<Cliente> clientes, int numeroConta, double valor, boolean deposito) {
        for (Cliente cliente : clientes) {
            ContaCorrente conta = cliente.encontrarContaPorNumero(numeroConta);
            if (conta != null) {
                if (deposito) {
                    conta.depositar(valor);
                } else {
                    conta.sacar(valor);
                }
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
