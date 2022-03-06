package list;

import java.util.*;

public class DiasDaSemanaList {

    public static void main(String[] args) {
        List<String> diasDaSemana = new ArrayList<>();
        diasDaSemana.add("Domingo");
        diasDaSemana.add("Segunda");
        diasDaSemana.add("Terça");
        diasDaSemana.add("Quarta");
        diasDaSemana.add("Quinta");
        diasDaSemana.add("Sexta");
        diasDaSemana.add("Sábado");
        //Informar todos os dias da semana (usando interator)
        Iterator<String> semanaInteira = diasDaSemana.iterator();
        while (semanaInteira.hasNext()) {
            System.out.println(semanaInteira.next());
        }


        System.out.println(diasDaSemana);
        //exiba "Quarta é dia de folga":
        System.out.println(diasDaSemana.get(3) + " é dia de folga!");
        //Quantos dia têm na semana:
        System.out.println("A semana têm " + diasDaSemana.size() + " dias.");
        //Qual o primeiro dia da semana:
        System.out.println("Primeiro dia da semana: " + diasDaSemana.get(0));
        //Adiciona um elemento no meio da lista:
        diasDaSemana.add(1, "Feriado-extra");
        System.out.println(diasDaSemana.get(1));
        System.out.println(diasDaSemana);
        //Substitua Sexta por sextou:
        diasDaSemana.set(6, "sextou");
        diasDaSemana.set(7, "sabadinho");
        System.out.println(diasDaSemana.get(6));
        //Confira se Quinta está na lista: note que faz diferença entre maiúsculas e minúsculas.
        System.out.println("quinta está na lista " + diasDaSemana.contains("quinta"));
        System.out.println("Quinta está na lista " + diasDaSemana.contains("Quinta"));
        diasDaSemana.remove("Feriado-extra");
        System.out.println("Max dia da semana: " + Collections.max(diasDaSemana));
        System.out.println("Min dia da semana: " + Collections.min(diasDaSemana));

        System.out.println("Lista final: ");
        System.out.println(diasDaSemana);
        //Cria uma lista com os dias úteis:
        Iterator<String> iterator = diasDaSemana.iterator();
        List<String> diasUteis = new ArrayList<>();
        while ((iterator.hasNext())) {
            String dia = iterator.next();
            if ( (!dia.equals("Domingo")) && (!dia.equals("sabadinho")) )
                diasUteis.add(dia);
        }
        System.out.println("Dias úteis: " + diasUteis);
    }

}
