import java.time.LocalDate;

public class ClientePF extends Cliente {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String ocupacao;
    private double renda;
    private ContaPoupanca contaPoupanca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void abrirContaPoupanca() {
        this.contaPoupanca = new ContaPoupanca(this);
    }

    @Override
    public double tarifa() {
        return Constants.TARIFA_CLIENTE_PF;
    }

    @Override
    public double bonus() {
        return Constants.RENDIMENTO_POUPANCA + Constants.BONUS_CLIENTE_PF;
    }
}
