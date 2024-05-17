package hermeslojanetbeans.model;

public class Venda {

    private int id;

    private String tipoPagamento;
    private int quantidada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getQuantidada() {
        return quantidada;
    }

    public void setQuantidada(int quantidada) {
        this.quantidada = quantidada;
    }
}
