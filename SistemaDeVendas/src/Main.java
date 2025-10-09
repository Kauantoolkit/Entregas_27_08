package SistemaDeVendas.src;

import SistemaDeVendas.src.sistema_vendas.Cliente;
import SistemaDeVendas.src.sistema_vendas.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * ASSUNÇÕES: Este código assume que as classes Produto e Cliente
 * possuem os construtores necessários, getters (como getId())
 * e setters (como setPreco(), setEstoque()) para funcionar.
 */
public class Main {
    // 1. Estrutura de armazenamento centralizada (Simulando um 'banco de dados')
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Dados iniciais (Seed Data) ---
        clientes.add(new Cliente("João Silva", "12345678900"));
        produtos.add(new Produto("P001", "Produto A", 50.0, 100));
        produtos.add(new Produto("P002", "Produto B", 30.0, 200));
        produtos.add(new Produto("P003", "Produto C", 10.0, 50));

        // --- Chamada do menu principal focado em CRUD ---
        menuCRUD(scanner);
    }

    public static void menuCRUD(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n----- Menu de Gerenciamento de Produtos (CRUD) -----");
            System.out.println("1. Cadastrar Novo Produto (Create)");
            System.out.println("2. Listar Todos os Produtos (Read)");
            System.out.println("3. Atualizar Produto (Update)");
            System.out.println("4. Excluir Produto (Delete)");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha

                switch (opcao) {
                    case 1:
                        cadastrarProduto(scanner);
                        break;
                    case 2:
                        listarProdutos();
                        break;
                    case 3:
                        atualizarProduto(scanner);
                        break;
                    case 4:
                        excluirProduto(scanner);
                        break;
                    case 5:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                        break;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Consome a entrada inválida
                opcao = 0;
            }
        } while (opcao != 5);
    }

    // --- MÉTODOS AUXILIARES ---

    // Método para encontrar um produto por ID
    private static Produto buscarProdutoPorId(String id) {
        for (Produto p : produtos) {
            // Assumindo que Produto tem um método getId()
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    // 1. CREATE
    public static void cadastrarProduto(Scanner scanner) {
        System.out.println("\n--- Cadastro de Novo Produto ---");

        System.out.print("ID do Produto (ex: P004): ");
        String id = scanner.nextLine().trim();

        if (buscarProdutoPorId(id) != null) {
            System.out.println("ERRO: Já existe um produto com o ID " + id + ".");
            return;
        }

        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Estoque Inicial: ");
        int estoque = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha

        produtos.add(new Produto(id, nome, preco, estoque));
        System.out.println("SUCESSO: Produto " + nome + " cadastrado com sucesso!");
    }

    // 2. READ
    public static void listarProdutos() {
        System.out.println("\n--- Lista de Produtos Cadastrados ---");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            // Assumindo que Produto tem o método consultarInformacoes()
            p.consultarInformacoes();
        }
    }

    // 3. UPDATE
    public static void atualizarProduto(Scanner scanner) {
        System.out.println("\n--- Atualização de Produto ---");
        System.out.print("Digite o ID do produto que deseja atualizar: ");
        String id = scanner.nextLine().trim();

        Produto produto = buscarProdutoPorId(id);

        if (produto == null) {
            System.out.println("ERRO: Produto com ID " + id + " não encontrado.");
            return;
        }

        System.out.println("Produto encontrado:");
        produto.consultarInformacoes();

        System.out.println("\nO que deseja atualizar?");
        System.out.println("1. Preço");
        System.out.println("2. Estoque");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo preço: ");
                double novoPreco = scanner.nextDouble();
                scanner.nextLine();
                // Assumindo que Produto tem o método setPreco(double)
                produto.setPreco(novoPreco);
                System.out.println("SUCESSO: Preço atualizado.");
                break;
            case 2:
                System.out.print("Digite o novo estoque: ");
                int novoEstoque = scanner.nextInt();
                scanner.nextLine();
                // Assumindo que Produto tem o método setEstoque(int)
                produto.setEstoque(novoEstoque);
                System.out.println("SUCESSO: Estoque atualizado.");
                break;
            default:
                System.out.println("Opção inválida. Nenhuma alteração feita.");
        }
        produto.consultarInformacoes(); // Exibe o produto atualizado
    }





    // 4. DELETE
    public static void excluirProduto(Scanner scanner) {
        System.out.println("\n--- Exclusão de Produto ---");
        System.out.print("Digite o ID do produto que deseja excluir: ");
        String id = scanner.nextLine().trim();

        Produto produto = buscarProdutoPorId(id);

        if (produto == null) {
            System.out.println("ERRO: Produto com ID " + id + " não encontrado.");
            return;
        }

        if (produtos.remove(produto)) {
            System.out.println("SUCESSO: Produto com ID " + id + " (" + produto.getNome() + ") foi excluído.");
        } else {
            System.out.println("ERRO: Falha ao excluir produto.");
        }
    }


}