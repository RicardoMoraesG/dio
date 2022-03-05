public class ContaCorrente extends Conta {

    private static int SEQUENCIAL = 0;
    private double limite;//somente a Conta Corrente oferece essa opção.



    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        if (this.limite > 0)
            System.out.println(String.format("Limite - %.2f", getLimite()));
        imprimirInfosComuns();
        System.out.println("==============================");
    }

    public double getLimite() {
        return this.limite;
    }

    /**
     * Altera o limite de Saque além do saldo da Conta Corrente.
     * @param limite
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }

    /**
     * Na classe Conta Corrente, é verificado o limite de saque.
     * @param valor
     */
    @Override
    public void sacar(double valor) {
        double disponivel = this.getSaldo() + this.getLimite();
        if (valor > disponivel) {//se tentar sacar além do limite:
            System.out.println(" Tentativa de saque (" + String.format("%.2f", valor) + ") além do limite. ");
            System.out.println("Saldo disponível: " + String.format("%.2f", disponivel));
            System.out.println("limite: -" + String.format("%.2f", this.getLimite()));
        } else { // senão, saca normalmente:
            System.out.println(String.format("->Saque: %.2f ", valor));
            this.saldo -= valor;
        }
    }


}
