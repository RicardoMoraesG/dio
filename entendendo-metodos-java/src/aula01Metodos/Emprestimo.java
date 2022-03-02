package aula01Metodos;

public class Emprestimo {

    public static void calcular(double valor, int parcelas) {
        if (parcelas == 2) {
            double valorFinal = valor + ( valor + getTaxaDuasParcelas());
            System.out.println("Valor final do empréstimo para 2 parcelas: " + valorFinal);
        } else if (parcelas == 3) {
            double valorFinal = valor + (valor * getTaxaTresParcelas());
            System.out.println("Valor final de empr[estimo para 3 parcelas: " + valorFinal);
        } else {
            System.out.println("Quantidade de parcelas não aceita.");
        }
    }

    private static double getTaxaDuasParcelas() {
        return 0.3;
    }

    private static double getTaxaTresParcelas() {
        return 0.45;
    }

    public static int getDuasParcelas() {
        return 2;
    }

    public static int getTresParcelas() {
        return 3;
    }
}


