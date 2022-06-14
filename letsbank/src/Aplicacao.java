import java.util.Scanner;

public class Aplicacao {

    private Cliente cliente;
    private Scanner scanner;

    private final OperacoesCliente operacoesCliente;

    public Aplicacao() {
        scanner = new Scanner(System.in);
        operacoesCliente = new OperacoesCliente(scanner);
    }

    public void start() {
        System.out.println("Bem vindo ao Let's Bank\n");

        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.println("Escolha a operação:");

            listarOperacoes();
        }
    }

    private void listarOperacoes() {
        if (cliente == null) {
            operacoesIniciais();
        } else {
            operacoes();
        }
    }

    private void operacoesIniciais() {
        System.out.println("1 - Cadastrar cliente PF");
        System.out.println("2 - Cadastrar cliente PJ");

        scanner = new Scanner(System.in);
        var operation = scanner.nextInt();

        if (operation == 1) {
            cliente = operacoesCliente.cadastrarClientePf();
        } else if (operation == 2) {
            cliente = operacoesCliente.cadastrarClientePj();
        } else {
            operacaoInvalida();
        }
    }

    private void operacoes() {
        System.out.println("1 - Abrir conta");
        System.out.println("0 - Sair");

        var operacao = scanner.nextInt();
        if (operacao == 1) {
            operacoesCliente.abrirConta(cliente);
        } else if (operacao == 0) {
            System.out.println("Obrigado por usar o Let's Bank\n");
            System.exit(0);
        } else {
            operacaoInvalida();
        }
    }

    private void operacaoInvalida() {
        System.out.println("Operação inválida\n");
    }
}
