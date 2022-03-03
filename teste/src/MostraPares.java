import java.io.IOException;
import java.util.Scanner;

public class MostraPares {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int numero;
        System.out.println("Até qual número.. ");//recebe o número.
        numero = scan.nextInt();
        int count = 0; // começa no zero.
        while (count <= numero) {//enquanto a contagem for menor que o número.
            if (count % 2 == 0) {//se for par
                System.out.print(" " + count);//exibe a saída.
            }
            count++;//incrementa.
        }
    }
}
