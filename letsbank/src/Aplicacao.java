import java.util.Scanner;

public class Aplicacao {

    private Cliente cliente;
    private Scanner scanner;

    public void start() {
        System.out.println("Bem vindo ao Let's Bank\n");

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
        System.out.println("1 - Cadastrar cliente PJ");

        scanner = new Scanner(System.in);
        var operation = scanner.nextInt();

        if (operation == 1) {
            cliente = OperacoesCliente.cadastrarClientePf();
        } else {
            operacaoInvalida();
        }
    }

    private void operacoes() {
        System.out.println("0 - Sair");

        var operacao = scanner.nextInt();
        if (operacao == 0) {
            System.out.println("Obrigado por usar o Let's Bank");
            System.exit(0);
        } else {
            operacaoInvalida();
        }
    }

    private void operacaoInvalida() {
        System.out.println("Operação inválida");
    }
}
