class ContaPoupanca extends ContaBancaria {
    private double taxaJuros;

    public ContaPoupanca(String numeroConta, String titular, double saldoInicial, double taxaJuros) {
        super(numeroConta, titular, saldoInicial);
        this.taxaJuros = taxaJuros;
    }

    @Override
    public void aplicarJuros() {
        saldo += saldo * taxaJuros;
        transacoes.add("Juros aplicados: " + (saldo * taxaJuros));
    }
}