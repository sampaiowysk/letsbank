import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class FolhaPagamento {
    private static ArrayList<FuncionarioInterface> colaboradores = new ArrayList<>();

    private FolhaPagamento(){
        
    }

    public static double fecharFolha() {
        double totalFolha = 0.0;
        for (FuncionarioInterface funcionario : colaboradores) {
            totalFolha += funcionario.salarioAPagar();
        }
        return totalFolha;
    }

    public static HashMap<String, Double> getFuncionarios() {
        HashMap<String, Double> funcionarios = new HashMap<>();
        for (FuncionarioInterface funcionario : colaboradores) {
            funcionarios.put(funcionario.getCpf(), funcionario.salarioAPagar());
        }
        return funcionarios;
    }

    public static FuncionarioInterface buscaFuncionario(String cpf) {
        for (FuncionarioInterface funcionario : colaboradores) {
            if (Objects.equals(funcionario.getCpf(), cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public static void contratarFuncionario(FuncionarioInterface funcionario) {
        if (buscaFuncionario(funcionario.getCpf()) != null) {
            throw new IllegalArgumentException("CPF solicitado já é um Funcionário: " + funcionario.getCpf());
        } else {
            colaboradores.add(funcionario);
        }
    }

    public static void demitirFuncionario(FuncionarioInterface funcionario) {
        if (colaboradores.contains(funcionario)) {
            colaboradores.remove(funcionario);
        } else {
            throw new IllegalArgumentException("Funcionário solicitado não existe: " + funcionario.getCpf());
        }
    }

    public static void demitirFuncionario(String cpf) {
        colaboradores.removeIf(n -> Objects.equals(n.getCpf(), cpf));
    }
}
