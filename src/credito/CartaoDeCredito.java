package credito;
import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private final double limite;
    private double saldo;
    private final List<Compra> compras;

    public CartaoDeCredito(double limite) {
        this.compras = new ArrayList<>();
        this.limite = limite;
        this.saldo = limite;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public boolean lancaCompra(Compra compra){
        if(this.saldo > compra.getValor()){
            saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        }
        return false;
    }
    
}
