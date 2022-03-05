import java.util.Calendar;

public class ContaPoupanca extends Conta {

    private Calendar aniversario;//Armazena a data de criação da Conta Poupança.

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.aniversario = Calendar.getInstance();
        this.limite = 0;//conta poupança não dará opção de limite.
    }

    /**
     * Aplicado sobre o saldo da conta poupança,
     * porém, parece fazer sentido ele ser de responsabilidade de outra classe
     * pois no mundo real a alíquota seria definida pelo Banco
     * e não cada conta.
     */
    public void rendimento() {
        if (comparaDia()) { //se for o mesmo dia do mês, aplica o rendimento.
            double rendimento = this.saldo * Aliquotas.RENDIMENTO;// rendimento = saldo * aliquota.
            System.out.println("Rendimento do mês: " + String.format("%.2f ", rendimento));
            this.saldo += rendimento; // soma o rendimento ao saldo.
        } else {
            int dia = this.aniversario.get(Calendar.DAY_OF_MONTH);//dia do aniversario.
            int mes = (Calendar.MONTH) + 1;//próximo mês.
            System.out.println("Próxima data de rendimentos: " + dia + "/" + mes);
        }

    }

    @Override
    public void setLimite(double limite) {
        System.out.println("Indisponível para Poupança.");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        this.exibeAniversario();
        imprimirInfosComuns();
        //Somente nesta classe:
        this.rendimento();
        System.out.println(String.format("Saldo Atual: %.2f " ,this.getSaldo()));
        System.out.println("==============================");
    }

    /**
     * Informa o dia de abertura da Conta Poupança.
     */
    private void exibeAniversario() {
        int dia = this.aniversario.get(Calendar.DAY_OF_MONTH);
        int mes = this.aniversario.get(Calendar.MONTH);
        int ano = this.aniversario.get(Calendar.YEAR);
        System.out.println("Conta Poupança aberta em: " + dia + "/" + mes + "/" + ano);
    }

    /**
     * Compara o dia atual com o dia de abertura da Conta Poupança.
     * @return
     */
    private boolean comparaDia() {
        Calendar dataAtual = Calendar.getInstance();//recebe a data atual.
        int diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);//recebe o dia do mês.
        int diaAniversario = this.aniversario.get(Calendar.DAY_OF_MONTH);//compara.
        if (diaAtual == diaAniversario)//se for igual
            return true;//retorna verdadeiro.
        return false;//senão retorna falso.
    }


}
