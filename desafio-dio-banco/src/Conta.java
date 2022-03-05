import javax.sound.midi.Soundbank;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected double limite;


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor > this.saldo){
            System.out.print("Tentativa de saque ");
            System.out.print(String.format("(%.2f)", valor));
            System.out.println(" Saldo Indisponível.");
        } else {
            System.out.println(String.format("->Saque: %.2f ", valor));
            this.saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        System.out.println(String.format("->Depósito: %.2f ", valor));
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        System.out.println(String.format("->Transferência %.2f ", valor) + " Beneficiário " + contaDestino.cliente.getNome());
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public double getSaldo() {
        return saldo;
    }

    public void setLimite(double limite) {
        //somente a Classe Conta Corrente.
    }

}
