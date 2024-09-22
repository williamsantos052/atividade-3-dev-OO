public class BancoDeItabaiana {
    public static void main(String[] args) {
        // Criação de uma conta corrente
        ContaCorrente contaCorrente = new ContaCorrente("12345", "João Silva", 1000.0, 500.0, 0.02);
        contaCorrente.depositar(500.0);
        contaCorrente.sacar(2000.0);
        contaCorrente.aplicarJuros();
        contaCorrente.exibirExtrato();

        // Criação de uma conta poupança
        ContaPoupanca contaPoupanca = new ContaPoupanca("67890", "Maria Oliveira", 1500.0, 0.01);
        contaPoupanca.depositar(300.0);
        contaPoupanca.aplicarJuros();
        contaPoupanca.exibirExtrato();

        // Transferência entre contas
        contaCorrente.transferir(contaPoupanca, 100.0);
        contaCorrente.exibirExtrato();
        contaPoupanca.exibirExtrato();
    }
}
