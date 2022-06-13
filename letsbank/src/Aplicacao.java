import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) throws Exception {
        System.out.println("Bem vindo ao Let's Bank");

        System.out.println("Escolha a operação:");
        System.out.println("1 - Criar conta");

        var scanner = new Scanner(System.in);
        var operation = scanner.nextInt();
        if (operation == 1) {
            System.out.println("Conta criada com sucesso");
        } else {
            System.out.println("Operação inválida");
        }
    }
}
