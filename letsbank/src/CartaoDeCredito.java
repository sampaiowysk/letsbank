import java.time.LocalDate;

public class CartaoDeCredito {
    private static long numero = 3372036854775808L;

    private long numeroCartao;
    private LocalDate dataVencimento;

    public CartaoDeCredito(){
        this.numeroCartao = CartaoDeCredito.numero;
        this.dataVencimento = LocalDate.now();
        CartaoDeCredito.numero++;
    }

    public long getNumeroCartao() {
        return numeroCartao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
}
