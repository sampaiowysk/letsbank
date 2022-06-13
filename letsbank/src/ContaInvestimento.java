
public class ContaInvestimento extends Conta {

    public ContaInvestimento(Cliente cliente) {
        super(cliente);
    }

    /*
     * O rendimento é pago no ato do depósito
     */
    @Override
    public double depositar(double valor){
        return super.depositar(valor * super.getCliente().bonus());
    }

    public double investir(double valor){
        return this.depositar(valor);
    }

}
