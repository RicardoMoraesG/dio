import com.sun.security.jgss.GSSUtil;

public class ControleDeFluxo {

    public static void main(String[] args) {

        ifFlecha();
        ifSemFlecha();
        ifFerias();
        ifMenor();

        switchSemana();
        switchNumero();
        switchFerias();

    }

    /*
     * Não recomendado. Atrapalha a leitura.
     */
    private static void ifFlecha() {
        int mes = 9;
        if (mes == 1) {
            System.out.println("Janeiro");
        } else {
            if (mes == 2) {
                System.out.println("Fevereiro");
            } else {
                if (mes == 3) {
                    System.out.println("Março");
                } else {
                    System.out.println("...");
                }
            }
        }

    }

    /*
     * Melhor que o Flecha. Melhora o entendimento do codigo.
     */
    private static void ifSemFlecha() {

        int mes = 9;
        if (mes == 1) {
            System.out.println("Janeiro");
        } else if (mes == 2) {
            System.out.println("Fevereiro");
        } else if (mes == 3) {
            System.out.println("Março");
        } else if (mes == 4) {
            System.out.println("...");
        }
    }

    /*
     *Não recomendado  uso do if quando tem um valor exato. O melhor é utilizar o switch.
     */
    private static void ifFerias() {

        String mes = "Julho";
        if (mes == "Julho" || mes == "Dezembro" || mes == "Janeiro") {
            System.out.println("Férias");
        }
    }

    /**
     * Torna mais legível a expressão através de variáveis intermediárias.
     */
    private static void ifMenor() {
        double salarioMensal = 11893.58d;
        double mediaSalario = 10500d;

        int quantidadeDependentes = 4;
        int mediaDependentes = 2;

        /**
         * deve ser evitado. Recomenda utilizar variaveis intermediarias.
         */
        if ((salarioMensal < mediaSalario) && (quantidadeDependentes >= mediaDependentes)) {
            System.out.println("Funcionário deve receber auxilio.");
        }

        boolean salarioBaixo = salarioMensal < mediaSalario;
        boolean muitosDependentes = quantidadeDependentes >= mediaDependentes;

        if ((salarioBaixo) && (muitosDependentes)) {
            System.out.println("Funcionário dever receber auxílio.");
        }

        boolean recebeAuxilio = (salarioBaixo) && (muitosDependentes);
        if (recebeAuxilio) {
            System.out.println("Funcionário deve receber auxílio.");
        } else {
            System.out.println("Funcionário não deve receber auxílio. ");
        }
    }

    /**
     * Recomendado para substituir  if no caso de um unico valor a trabalhar.
     */
    private static void switchSemana() {
        String dia = "Terça";
        switch (dia) {
            case "Segunda":
                System.out.println(2);
                break;
            case "Terça":
                System.out.println(3);
                break;
            case "Quarta":
                System.out.println(4);
                break;
        }
    }


    /**
     * uma ação para vários casos(1,2 e 3).
     */
    private static void switchNumero() {

        int numero = 4;
        switch (numero){
            case 1:
            case 2:
            case 3:
                System.out.println("Certo");
                break;
            case 4:
                System.out.println("Errado");
                break;
            case 5:
                System.out.println("talvez");
                break;
            default:
                System.out.println("Valor indefinido.");
                break;
        }
    }

    /**
     * utilizando String. Exemplo de Default errado.
     */
    private static void switchFerias() {
        String mes = "Dezembro";
        switch (mes){
            case "Dezembro":
            case "Julhor":
            case "Janeiro":
                System.out.println("Férias");
                break;
            default:
                System.out.println("Mês Indefinido");//Errado: Não usar o Default como comportamento padrão
                break;
        }
    }

}
