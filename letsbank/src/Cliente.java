import java.time.LocalDate;

public abstract class Cliente {

    private LocalDate dataAdesao = LocalDate.now();
    private Contato contato;
    private ContaCorrente contaCorrente;
    private ContaInvestimento contaInvestimento;

    public LocalDate getDataAdesao() {
        return dataAdesao;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void abrirContaCorrente() {
        this.contaCorrente = new ContaCorrente(this);
    }

    public ContaInvestimento getContaInvestimento() {
        return contaInvestimento;
    }

    public void abrirContaInvestimento() {
        this.contaInvestimento = new ContaInvestimento(this);
    }

    public boolean hasContaInvestimento() {
        return contaInvestimento != null;
    }

    public abstract double tarifa();

    public abstract double bonus();

}
