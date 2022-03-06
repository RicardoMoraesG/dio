package list;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotasAlunos {

    public static void main(String[] args) {
        List<Double> notas = new ArrayList<>();
        notas.add(4.5);
        notas.add(8.8);
        notas.add(7.5);
        notas.add(10.0);
        notas.add(6.7);
        notas.add(0.0);
        notas.add(9.5);
        notas.add(9.1);
        notas.add(7.8);
        System.out.println(notas);
        //exiba a terceira nota:
        System.out.println("Terceira nota: " + notas.get(2));
        //Adiciona um elemento na lista
        notas.add(2, 8.00);
        System.out.println(notas);
        System.out.println("Terceira nota: " + notas.get(2));
        System.out.println("Menor nota: " + Collections.min(notas));
        System.out.println("Maior nota: " + Collections.max(notas));

        //Soma das notas:
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double proximaNota = iterator.next();
            soma += proximaNota;
        }
        System.out.println("Soma das notas: " + soma);
        System.out.println("Exiba a média das notas: " + soma / notas.size());
        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7: ");
        Iterator<Double> removedor = notas.iterator();
        while (removedor.hasNext()) {
            Double proximo = removedor.next();
            if (proximo < 7) removedor.remove();
        }
        System.out.println(notas);
        System.out.println("Apague toda a lista");
        notas.clear();
        //System.out.println("Notas " + notas);
        if (notas.isEmpty()) {
            System.out.println("Lista vazia");
        } else System.out.println(notas);

    }
}
