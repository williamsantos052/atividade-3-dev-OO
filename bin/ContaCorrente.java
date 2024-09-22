class ContaCorrente extends ContaBancaria {
    private double limiteCredito;
    private double taxaJurosLimite;

    public ContaCorrente(String numeroConta, String titular, double saldoInicial, double limiteCredito, double taxaJurosLimite) {
        super(numeroConta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
        this.taxaJurosLimite = taxaJurosLimite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo + limiteCredito) {
            saldo -= valor;
            transacoes.add("Saque de: " + valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente, incluindo limite de crédito.");
            return false;
        }
    }

    @Override
    public void aplicarJuros() {
        if (saldo < 0) {
            saldo -= saldo * taxaJurosLimite;
            transacoes.add("Cobrança de juros sobre saldo negativo.");
        }
    }
}