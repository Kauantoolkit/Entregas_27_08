package sistema_vendas;

public class Produto {
    private String codigo;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;

    // Construtor
    public Produto(String codigo, String descricao, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getters e setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Métodos públicos
    public void consultarInformacoes() {
        System.out.println("Código: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
    }

    public void alterarPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public boolean verificarEstoque(int quantidade) {
        return quantidadeEstoque >= quantidade;
    }

    // Métodos privados
    private double calcularDesconto(double percentual) {
        return preco * (percentual / 100);
    }

    private boolean verificarDisponibilidade(int quantidade) {
        return quantidadeEstoque >= quantidade;
    }







}



