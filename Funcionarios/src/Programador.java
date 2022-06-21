import java.time.LocalDate;

public class Programador implements FuncionarioInterface {

    private Funcionario funcionario;
    private LocalDate bonusDay;
    private double bonus;

    public Programador(String nome, String cpf) {
        funcionario = new Funcionario(nome, cpf);
        bonusDay = LocalDate.now().plusMonths(Constants.INTERVALO_BONUS_PROGRAMADOR);
    }

    public Programador(String nome, String cpf, double salario) {
        funcionario = new Funcionario(nome, cpf, salario);
        bonusDay = LocalDate.now().plusMonths(Constants.INTERVALO_BONUS_PROGRAMADOR);
        bonus = salario;
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

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double salarioAPagar() {
        if (bonusDay.isBefore(LocalDate.now()) && bonusDay.getMonth() != LocalDate.now().getMonth()) {
            bonusDay = bonusDay.plusMonths(Constants.INTERVALO_BONUS_PROGRAMADOR);
        }

        if (bonusDay.getMonth() == LocalDate.now().getMonth()) {
            return funcionario.getSalario() + bonus;
        } else {
            return funcionario.getSalario();
        }
    }
}
