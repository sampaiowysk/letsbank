import java.time.LocalDate;

public class ClientePJ extends Cliente {

    private String nomeFantasia;
    private String cnpj;
    private LocalDate dataAbertura;
    private String atividadePrincipal;
    private String razaoSocial;
    private ContaInvestimento contaInvestimento;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getAtividadePrincipal() {
        return atividadePrincipal;
    }

    public void setAtividadePrincipal(String atividadePrincipal) {
        this.atividadePrincipal = atividadePrincipal;
    }

    public ContaInvestimento getContaInvestimento() {
        return contaInvestimento;
    }

    public void abrirContaInvestimento() {
        this.contaInvestimento = new ContaInvestimento(this);
    }

    @Override
    public double tarifa() {
        return Constants.TARIFA_CLIENTE_PJ;
    }

    @Override
    public double bonus() {
        return Constants.RENDIMENTO_POUPANCA + Constants.BONUS_CLIENTE_PJ;
    }
}
