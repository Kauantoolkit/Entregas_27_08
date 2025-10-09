package SistemaDeVendas.src.sistema_vendas;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    // Construtor
    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = calcularSubtotal();
    }

    // Getters
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    // Método privado
    private double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }
}
