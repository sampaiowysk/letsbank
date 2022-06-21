public class GerenteProjetos implements FuncionarioInterface {
    
    private Funcionario funcionario;

    public GerenteProjetos(String nome, String cpf) {
        funcionario = new Funcionario(nome, cpf);

    }

    public GerenteProjetos(String nome, String cpf, double salario) {
        funcionario = new Funcionario(nome, cpf, salario);

    }

    public String getNome() {
        return funcionario.getNome();
    }

    public void setNome(String nome) {
        funcionario.setNome(nome);
    }

    @Override
    public String getCpf() {
        return funcionario.getCpf();
    }

    public void setCpf(String cpf) {
        funcionario.setCpf(cpf);
    }

    public double getSalario() {
        return funcionario.getSalario();
    }

    public void setSalario(double salario) {
        funcionario.setSalario(salario);
    }

    @Override
    public double salarioAPagar() {
        return funcionario.getSalario();
    }
}
