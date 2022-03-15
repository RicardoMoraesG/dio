package map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class DesafioDado {

    public static void main(String[] args) {
        //Lista que receberá os lançamentos:
        Map<Integer, Integer> rodadas = new LinkedHashMap<>();

        //Lista que informará a quantidade de cada valor:
        Map<String, Integer> historico = new LinkedHashMap<>();

        //variáveis que receberão a quantidade de cada valor:
        int um = 0, dois = 0, tres = 0, quatro = 0, cinco = 0, seis = 0;

        //faz a simulação de lançamento de dados:
        for (int lancamentos = 1; lancamentos <= 100; lancamentos++) {
            rodadas.put(lancamentos, LancarDados.rodada());//guarda o valor na lista.
        }

        //calcula quantas vezes cada valor apareceu.
        for (Map.Entry<Integer, Integer> lancamento : rodadas.entrySet()) {
            System.out.println(lancamento.getKey() + " - \t " + lancamento.getValue());
            switch (lancamento.getValue()) {
                case 1 -> um++;
                case 2 -> dois++;
                case 3 -> tres++;
                case 4 -> quatro++;
                case 5 -> cinco++;
                case 6 -> seis++;
            }
        }

        //Guarda a quantidade no histórico:
        historico.put("Um", um);
        historico.put("Dois", dois);
        historico.put("Três", tres);
        historico.put("Quatro", quatro);
        historico.put("Cinco", cinco);
        historico.put("Seis", seis);

        //Exibe os resultados:
        for (Map.Entry<String, Integer> resultado : historico.entrySet()) {
            System.out.println("O número " + resultado.getKey() + " foi lançado " + resultado.getValue() + " vezes!");
        }
    }
}

class LancarDados {
    /**
     * @return Int. Retorna um número aleatório entre 1 e 6.
     */
    static int rodada() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
