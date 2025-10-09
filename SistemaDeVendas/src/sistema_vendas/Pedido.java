package SistemaDeVendas.src.sistema_vendas;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private String data;

    // Construtor
    public Pedido(int numeroPedido, Cliente cliente, String data) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.data = data;
    }

    // Getters e setters
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // Métodos públicos
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    // Métodos privados
    private int gerarNumeroPedido() {
        // Implementar lógica para gerar um número de pedido único
        return (int) (Math.random() * 10000);
    }

    private boolean verificarDisponibilidadeItens() {
        for (ItemPedido item : itens) {
            if (!item.getProduto().verificarEstoque(item.getQuantidade())) {
                return false;
            }
        }
        return true;
    }
}
