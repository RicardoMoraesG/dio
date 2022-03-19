import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class NotacaoCientifica {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        Float numero = leitor.nextFloat();
        /**
         * Locale.ROOT: troca a virgula pelo ponto
         * "%+5.4E": o sinal + aarece em numeros positivos e não em negativos.
         * "%+5.4E": depois do ponto é a quantidade de casas que serao exibidas.
         * exemplo:
         * entrada: 0,99 saída: +9.9000E-01
         * entrada: -100000 saída: -1.0000E+05
         */
        System.out.printf(Locale.ROOT,"%+5.4E", numero);//


    }

}
