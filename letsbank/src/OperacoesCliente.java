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
}
