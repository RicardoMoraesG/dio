public class Main {
    public static void main(String[] args) {

        //instanciar Clientes
        Cliente cliente1 = new Cliente("Jeff Bezos");
        Cliente cliente2 = new Cliente("Elon Musk");

        //Instanciar Contas
        Conta contaCorrente1 = new ContaCorrente(cliente1);
        Conta poupanca1 = new ContaPoupanca(cliente1);
        Conta contaCorrente2 = new ContaCorrente(cliente2);
        Conta poupanca2 = new ContaPoupanca(cliente2);

        //Movimentações
        contaCorrente1.depositar(1000);//Depósito Conta Corrente
        contaCorrente1.setLimite(400);//Criando Limite Conta Corrente
        contaCorrente1.imprimirExtrato();//Mostra Informações
        contaCorrente1.transferir(500,poupanca1);//Conta Corrente para propria Poupança.
        contaCorrente1.transferir(500,poupanca2);//Conta Corrente para Poupança de outro cliente.
        contaCorrente1.imprimirExtrato();
        poupanca1.imprimirExtrato();//exibe o saldo da Poupança e o rendimento.
        contaCorrente1.sacar(500);//tentativa de saque além do limite é recusada.


        contaCorrente2.imprimirExtrato();
        contaCorrente2.depositar(1000);
        contaCorrente2.setLimite(400);
        contaCorrente2.transferir(500,contaCorrente1);//Transferência para Conta Corrente de outro cliente.
        contaCorrente2.imprimirExtrato();
        poupanca2.imprimirExtrato();//Mostra informações e rendimento da Poupança.
        poupanca2.sacar(1000);//Tentativa de saque acima do saldo é negada.
        poupanca2.imprimirExtrato();






//
//        contaCorrente2.depositar(500000);
//        contaCorrente3.depositar(300000);
//        contaCorrente4.depositar(500500);
//        contaCorrente5.depositar(500099);
//        contaCorrente6.depositar(400400);
//        contaCorrente7.depositar(600800);





    }
}
