import java.util.Scanner;

public class OperacoesCliente {
    Scanner scanner;

    public OperacoesCliente(Scanner scanner) {
        this.scanner = scanner;
    }

    public Cliente cadastrarClientePf() {
        System.out.println("Insira nome:");
        var nome = scanner.nextLine();

        System.out.println("Insira CPF:");
        var cpf = scanner.nextLine();

        var cliente = new ClientePF();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.abrirContaCorrente();

        System.out.println("Cliente cadastrado com sucesso\n");

        return cliente;
    }

    public Cliente cadastrarClientePj() {
        System.out.println("Insira razão social:");
        var razaoSocial = scanner.nextLine();

        System.out.println("Insira CNPJ:");
        var cnpj = scanner.nextLine();

        var cliente = new ClientePJ();
        cliente.setRazaoSocial(razaoSocial);
        cliente.setCnpj(cnpj);
        cliente.abrirContaCorrente();

        System.out.println("Cliente cadastrado com sucesso\n");

        return cliente;
    }

    public void abrirConta(Cliente cliente) {
        System.out.println("Escolha tipo de conta:");

        if (cliente.getContaInvestimento() == null) {
            System.out.println("1 - Conta investimento");
        }
        if (cliente instanceof ClientePF && ((ClientePF) cliente).getContaPoupanca() == null) {
            System.out.println("2 - Conta poupança");
        }
        System.out.println("0 - Voltar");

        var operacao = scanner.nextInt();

        if (operacao == 1) {
            cliente.abrirContaInvestimento();
            System.out.println("Conta criada com sucesso\n");
        } else if (operacao == 2 && cliente instanceof ClientePF) {
            ((ClientePF) cliente).abrirContaPoupanca();
            System.out.println("Conta criada com sucesso\n");
        } else {
            if (operacao != 0) {
                operacaoInvalida();
            } else {
                System.out.println();
            }
        }
    }

    private void operacaoInvalida() {
        System.out.println("Operação inválida\n");
    }
}
