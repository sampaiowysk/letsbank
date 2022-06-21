public class App {
    public static void main(String[] args) throws Exception {
        Programador prog = new Programador("Oz", "12345678900", 5000);
        GerenteProjetos gest = new GerenteProjetos("Meg", "12345678900", 7000);

        FolhaPagamento.contratarFuncionario(prog);
        try {
            FolhaPagamento.contratarFuncionario(gest);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        gest.setCpf("12345678901");
        FolhaPagamento.contratarFuncionario(gest);
        System.out.println("Salário da Meg: " + FolhaPagamento.buscaFuncionario("12345678901").salarioAPagar());

        System.out.println("Total da folha de pagamento: " + FolhaPagamento.fecharFolha());
        System.out.println("Funcionários: " + FolhaPagamento.getFuncionarios());
    }
}
