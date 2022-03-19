package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        /*

        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
        System.out.println("Imprima todos os elementos dessa lista de String: ");

         */
        /*classe anônima:
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
         */
        //utilizando lambda:
        //numerosAleatorios.stream().forEach(s -> System.out.println(s));
        //Utilizando reference method
        //numerosAleatorios.forEach(System.out::println);
        System.out.println("Pegue os  primeiros elementos dessa lista de String: ");
        //Obs. Elementos repetidos são omitidos pelo metodo Set.
       /*
       numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        */
        /*System.out.println("Transforme esta lista de String em uma lista de numeros inteiros");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(integer -> (integer % 2 == 0 && integer > 2))
                .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);

        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores impares: ");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numerosAleatoriosInteger.removeIf( integer ->(integer % 2 != 0));
        System.out.println(numerosAleatoriosInteger);*/


    }

}

