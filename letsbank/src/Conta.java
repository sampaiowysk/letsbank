import java.util.ArrayList;

public abstract class Conta {

    private static int numeroConta = 1000000;

    private double saldo = 0.0;
    private double limite = 1000.0;
    private Cliente cliente;
    private Agencia agencia;
    private int idConta;
    private ArrayList<CartaoDeCredito> cartoes = new ArrayList<CartaoDeCredito>();

    protected Conta(Cliente cliente) {
        this.cliente = cliente;
        this.idConta = Conta.numeroConta;
        Conta.numeroConta++;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public int getIdConta() {
        return this.idConta;
    }

    public boolean sacar(double valor) {
        if (this.saldo >= (valor * (1 + cliente.tarifa()))) {
            this.saldo -= (valor * (1 + cliente.tarifa()));
            return true;
        } else {
            return false;
        }
    }

    public double depositar(double valor) {
        this.saldo += valor;
        return this.saldo;
    }

    public boolean transferir(Conta conta, double valor) {
        if (this.sacar(valor)) {
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<CartaoDeCredito> getCartoes() {
        return this.cartoes;
    }

    public void novoCartao() {
        this.cartoes.add(new CartaoDeCredito());
    }

    public void removerCartao(CartaoDeCredito cartao) {
        if (this.cartoes.contains(cartao)) {
            this.cartoes.remove(cartao);
        } else {
            throw new IllegalArgumentException("Cartão solicitado não existe: " + cartao.getNumeroCartao());
        }
    }

    public void removerCartao(long numeroCartao) {
        this.cartoes.removeIf(n -> (n.getNumeroCartao() == numeroCartao));
    }
}
