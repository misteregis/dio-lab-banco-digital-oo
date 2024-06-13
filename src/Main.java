public class Main {
    public static void main(String[] args) {
        Cliente venilton = criarCliente(
                "Venilton",
                "12345678910",
                "Rua A, 123",
                "123456789",
                "venilton@example.com");

        Cliente washington = criarCliente(
                "Washington",
                "12345678910",
                "Rua B, 456",
                "123456789",
                "washington@example.com");

        Conta contaCorrente = new ContaCorrente(venilton);
        Conta contaPoupanca = new ContaPoupanca(washington);

        limparConsole();

        System.out.println(washington);
        System.out.println("Realizando operações...");

        realizarOperacoes(contaCorrente, contaPoupanca);

        imprimirDetalhesConta(contaCorrente, venilton);
        imprimirDetalhesConta(contaPoupanca, washington);
    }

    private static void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static Cliente criarCliente(String nome, String cpf, String endereco, String telefone, String email) {
        return new Cliente(nome, cpf, endereco, telefone, email);
    }

    private static void realizarOperacoes(Conta contaCorrente, Conta contaPoupanca) {
        contaCorrente.depositar(100);
        contaCorrente.transferir(100, contaPoupanca);
    }

    private static void imprimirDetalhesConta(Conta conta, Cliente cliente) {
        conta.imprimirExtrato();
        cliente.exibirInformacoes();
        System.out.println();
    }
}
