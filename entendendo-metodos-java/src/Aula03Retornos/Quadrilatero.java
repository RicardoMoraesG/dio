package Aula03Retornos;

/**
 * O mesmo exemplo da aula 2, agora com especificando o tipo de retorno.
 */
public class Quadrilatero {

    public static double area(double lado) {

        return lado * lado;
    }

    public static double area(double lado1, double lado2) {
       return lado1 * lado2;
    }

    public static double area(double baseMaior, double baseMenor, double altura) {
        return ((baseMaior + baseMenor) * altura) / 2;
    }

    public static double area(float diagonal1, float diagonal2) {
      return  (diagonal1 * diagonal2) / 2;
    }

}
