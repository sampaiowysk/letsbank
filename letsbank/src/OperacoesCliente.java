import java.util.Scanner;

public class OperacoesCliente {
    public static Cliente cadastrarClientePf() {
        var scanner = new Scanner(System.in);

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

    public static Cliente cadastrarClientePj() {
        var scanner = new Scanner(System.in);

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
}
