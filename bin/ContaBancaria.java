import java.util.ArrayList;
import java.util.List;

// Classe base ContaBancaria
abstract class ContaBancaria {
    private String numeroConta;
    private String titular;
    protected double saldo;
    protected List<String> transacoes;

    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.transacoes = new ArrayList<>();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        transacoes.add("Depósito de: " + valor);
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            transacoes.add("Saque de: " + valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    public boolean transferir(ContaBancaria destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            transacoes.add("Transferência de: " + valor + " para a conta: " + destino.getNumeroConta());
            return true;
        }
        return false;
    }

    public void exibirExtrato() {
        System.out.println("Extrato da conta: " + numeroConta);
        for (String transacao : transacoes) {
            System.out.println(transacao);
        }
    }

    public abstract void aplicarJuros();
}