public class Main {
    public static void main(String[] args) {

        Cliente Rafael = new Cliente("Rafael de Moraes Gonçalves");
        Conta cc = new ContaCorrente(Rafael);//
        cc.depositar(100);

        Conta poupanca = new ContaPoupanca(Rafael);

        cc.transferir(60, poupanca);



        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
