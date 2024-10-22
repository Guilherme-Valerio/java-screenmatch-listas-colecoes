package credito;

public class Compra implements Comparable<Compra> {
    private final String descricao;
    private final double valor;

    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra: descrição = " + descricao + 
        "valor = " + valor;
    }

    @Override
    public int compareTo(Compra c) {
        return Double.valueOf(this.valor).compareTo(c.valor);
    }
}
