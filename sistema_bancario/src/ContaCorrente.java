public class ContaCorrente {
    private int numeroConta;
    private String titular;
    private double saldo;

    // Construtor
    public ContaCorrente(int numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            this.saldo = 0;
            System.out.println("Saldo inicial inválido. Conta criada com saldo 0.");
        }
    }

    // Getters e setters
    public int getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos de operação
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
            return true;
        } else {
            System.out.println("Valor de depósito inválido.");
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual: " + this.saldo);
    }

    public void exibirDetalhesConta() {
        System.out.println("Número da Conta: " + this.numeroConta);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);
    }
}
