public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    // Construtor
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    // Getters
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Métodos de operação
    public void sacar(double valor) {
        if (valor <= saldo && valor > 0) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso.\n", valor);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso na conta %d (%s).\n", valor, this.numero,
                    this.cliente.getNome());
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor <= saldo && valor > 0) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.printf("Transferência de R$ %.2f para conta %d (%s) realizada com sucesso.\n", valor,
                    contaDestino.numero, contaDestino.cliente.getNome());
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }

    // Métodos abstratos
    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public abstract void imprimirExtrato();
}
