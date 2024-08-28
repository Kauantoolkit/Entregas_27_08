import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<ContaCorrente> contas = new ArrayList<>();

    // Construtor
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters e setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ContaCorrente> getContas() {
        return this.contas;
    }

    public boolean adicionarConta(ContaCorrente conta) {
        if (encontrarContaPorNumero(conta.getNumeroConta()) == null) {
            this.contas.add(conta);
            System.out.println("Conta adicionada com sucesso!");
            return true;
        } else {
            System.out.println("Conta já existe.");
            return false;
        }
    }

    public void exibirContas() {
        System.out.println("Contas do cliente " + this.nome + ":");
        for (ContaCorrente conta : this.contas) {
            conta.exibirDetalhesConta();
        }
    }

    public void depositarEmConta(int numeroConta, double valor) {
        ContaCorrente conta = encontrarContaPorNumero(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacarDeConta(int numeroConta, double valor) {
        ContaCorrente conta = encontrarContaPorNumero(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Tornar o método público para acesso externo
    public ContaCorrente encontrarContaPorNumero(int numeroConta) {
        for (ContaCorrente conta : this.contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
