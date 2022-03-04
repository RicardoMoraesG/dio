import java.io.IOException;
import java.util.Scanner;

public class AumentoPercentagem {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        double A = leitor.nextDouble();
        double B = leitor.nextDouble();
//        double A = 10.00;
//        double B = 10.00;
        //Escreva aqui a sua lógica
        double porcentagem = (B/A-1)*100;
        System.out.printf("%.2f%%", porcentagem);

    }

}
