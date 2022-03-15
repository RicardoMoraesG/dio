package map;

import java.text.NumberFormat;
import java.util.*;

public class ExercicioPropostoMap1 {
    public static void main(String[] args) {

        //formata de acordo com a regra do exercício. Exemplo: PB - 4.039.277
        NumberFormat n = NumberFormat.getInstance();

        System.out.println("1 - Um dicionário que relacione os estados e suas populações: ");
        Map<String, Integer> estadoMap = new HashMap<>();
        estadoMap.put("PE", 9616621);
        estadoMap.put("AL", 3351543);
        estadoMap.put("CE", 9187103);
        estadoMap.put("RN", 3534265);
        System.out.println("Estado - População");
        //Criei a classe Imprime() para não repetir o método Map.entry para as exibições de lista.
        Imprime.entrada(estadoMap);
        System.out.println("\n2 - Substitua a população do RN por 3.534.165");
        estadoMap.put("RN", 3534165);
        Imprime.entrada(estadoMap);
        System.out.println("\n3 - Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277: "
                + estadoMap.containsKey("PB"));
        estadoMap.put("PB", 4039277);
        Imprime.entrada(estadoMap);
        System.out.println("\n4 - Exiba a população de PE: " + n.format(estadoMap.get("PB")));

        System.out.println("\n5 - Exiba os estados e suas populações na ordem que foi informado: ");
        Map<String, Integer> estadoOrdemInformado = new LinkedHashMap<>();
        estadoOrdemInformado.put("PE", 9616621);
        estadoOrdemInformado.put("AL", 3351543);
        estadoOrdemInformado.put("CE", 9187103);
        estadoOrdemInformado.put("RN", 3534265);
        estadoOrdemInformado.put("PB", 4039277);
        Imprime.entrada(estadoOrdemInformado);

        System.out.println("\n6 - Exiba os estados e suas populações em ordem alfabética: ");
        Map<String, Integer> estadoOrdemAlfabetica = new TreeMap<>(estadoMap);
        Imprime.entrada(estadoOrdemAlfabetica);

        System.out.println("\n7 - Exiba o estado com a menor população e sua quantidade: ");
        Imprime.menor(estadoMap);

        System.out.println("\n7 - Exiba o estado com a menor população e sua quantidade: ");
        Imprime.maior(estadoMap);

        System.out.println("\n8 - Exiba a soma da população deste dicionário de estados: " + n.format(Imprime.soma(estadoMap)));

        //System.out.println("\n8 - Exiba a média da população deste dicionário de estados: " + n.format(Imprime.soma(estadoMap)/estadoMap.size()));
        //Ou mais legível:
        int populacaoTotal = Imprime.soma(estadoMap);
        int totalEstados = estadoMap.size();
        int media = populacaoTotal / totalEstados;
        System.out.println("\n9 - Exiba a média da população deste dicionário de estados: ~" + n.format(media));

        System.out.println("\n10 - Remova os estados com a população menor que 4.000.000: ");
        estadoMap.values().removeIf(integer -> integer < 4000000);
        Imprime.entrada(estadoMap);

        System.out.println("\n11 - Apague o dicinário de estados");
        estadoMap.clear();
        System.out.println("\n12 - Confira se o dicionário de estados está vazio: " + estadoMap.isEmpty());



    }


}

class Imprime {
    /**
     * Imprime a lista utilizando o método Map.Entry<>
     *
     * @param mapList Map<String, Integer>
     */
    static void entrada(Map<String, Integer> mapList) {
        NumberFormat n = NumberFormat.getInstance();
        for (Map.Entry<String, Integer> entrada : mapList.entrySet()) {
            System.out.println(entrada.getKey() + " - \t " + n.format(entrada.getValue()));
        }
    }

    /**
     * @param mapList
     * @return o menor valor de uma lista associado à chave(key).
     */
    static void menor(Map<String, Integer> mapList) {
        Map<String, Integer> min = new HashMap<>();
        Integer menorValor = Collections.min(mapList.values());
        for (Map.Entry<String, Integer> entrada : mapList.entrySet()) {
            if (entrada.getValue().equals(menorValor)) {
                String key = entrada.getKey();
                min.put(key, menorValor);
            }
        }
        Imprime.entrada(min);
    }

    /**
     * @param mapList
     * @return o maior valor de uma lista associado à chave(key).
     */
    static void maior(Map<String, Integer> mapList) {
        Map<String, Integer> max = new HashMap<>();
        Integer menorValor = Collections.max(mapList.values());
        for (Map.Entry<String, Integer> entrada : mapList.entrySet()) {
            if (entrada.getValue().equals(menorValor)) {
                String key = entrada.getKey();
                max.put(key, menorValor);
            }
        }
        Imprime.entrada(max);
    }

    static Integer soma(Map<String, Integer> mapList) {
        Integer soma = 0;
        Iterator<Integer> iterator = mapList.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        return soma;
    }


}