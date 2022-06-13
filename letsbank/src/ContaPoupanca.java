
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public double depositar(double valor){
        return super.depositar(valor * Constants.RENDIMENTO_POUPANCA);
    }

}
