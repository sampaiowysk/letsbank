import java.text.DecimalFormat;
import java.util.Scanner;

public class OperacoesConta {

    private final Scanner scanner;

    public OperacoesConta(Scanner scanner) {
        this.scanner = scanner;
    }

    public void depositar(Cliente cliente) {
        System.out.println("Selecione conta destino:");
        Conta conta = selecionarConta(cliente);
        if (conta == null) {
            return;
        }

        System.out.println("Insira valor a ser depositado:");
        var valor = scanner.nextDouble();

        conta.depositar(valor);

        operacaoSucesso();
    }

    private void operacaoSucesso() {
        System.out.println("Operação realizada com sucesso\n");
    }

    private Conta selecionarConta(Cliente cliente) {
        System.out.println("1 - Conta corrente");
        if (cliente.hasContaInvestimento()) {
            System.out.println("2 - Conta investimento");
        }
        if (cliente instanceof ClientePF && ((ClientePF) cliente).hasContaPoupanca()) {
            System.out.println("3 - Conta poupança");
        }

        var operacao = scanner.nextInt();

        if (operacao == 1) {
            return cliente.getContaCorrente();
        } else if (operacao == 2) {
            return cliente.getContaInvestimento();
        } else if (operacao == 3 && cliente instanceof ClientePF) {
            return ((ClientePF) cliente).getContaPoupanca();
        } else {
            System.out.println("Operação inválida\n");
            return null;
        }
    }

    public void sacar(Cliente cliente) {
        System.out.println("Selecione conta origem:");
        Conta conta = selecionarConta(cliente);
        if (conta == null) {
            return;
        }

        System.out.println("Insira valor a ser sacado:");
        var valor = scanner.nextDouble();

        var sucesso = conta.sacar(valor);

        if (sucesso) {
            operacaoSucesso();
        } else {
            System.out.println("Saldo insuficiente\n");
        }
    }

    public void consultarSaldo(Cliente cliente) {
        System.out.println("Selecione conta:");
        Conta conta = selecionarConta(cliente);
        if (conta == null) {
            return;
        }

        System.out.println("Seu saldo é " + new DecimalFormat().format(conta.getSaldo()) + "\n");
    }

    public void transferir(Cliente cliente) {
        System.out.println("Selecione conta origem:");
        Conta origem = selecionarConta(cliente);
        if (origem == null) {
            return;
        }

        System.out.println("Selecione conta destino:");
        Conta destino = selecionarConta(cliente);
        if (destino == null) {
            return;
        }

        if (origem == destino) {
            System.out.println("Não é possível transferir para a mesma conta\n");
            return;
        }

        System.out.println("Insira valor a ser transferido:");
        var valor = scanner.nextDouble();

        var sucesso = origem.transferir(destino, valor);

        if (sucesso) {
            operacaoSucesso();
        } else {
            System.out.println("Saldo insuficiente\n");
        }
    }
}
