package map;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os modelos ");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares);
        System.out.println("Substitua o consumo do gol por 15.2 km/l");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);
        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tuckson"));
        System.out.println("Confira se o modelo uno está no dicionário: " + carrosPopulares.containsKey("uno"));
        System.out.println("Exiba o consumo do uno " + carrosPopulares.get("uno"));
        System.out.println("Exiba os modelos: ");
        // carrosPopulares.keySet();
        // retorna uma lista Set<> para exibir apenas as chaves(keys) ignorando os valores
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);
        System.out.println("Exiba o consumo dos carros: ");
        //carrosPopulares.values();
        //retorna uma lista Collection, e exibe os valores associados às keys.
        Collection<Double> values = carrosPopulares.values();
        System.out.println(values);
        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());//essa variável recebe os valores
        String modeloMaisEficiente = "";
        /*
        Uma entrada de mapa (par chave-valor).
        O método Map.entrySet retorna uma exibição de coleção do mapa,
        cujos elementos são dessa classe.
        A única maneira de obter uma referência a uma entrada de mapa é do iterador dessa exibição de coleção.
        Esses objetos Map.Entry são válidos apenas pela duração da iteração;
        mais formalmente, o comportamento de uma entrada de mapa é indefinido se
        o mapa de apoio foi modificado após a entrada ser retornada pelo iterador,
        exceto por meio da operação setValue na entrada de mapa.
        * */
        Set<Map.Entry<String, Double>> entradas = carrosPopulares.entrySet();//iterador
        for (Map.Entry<String, Double> entrada : entradas) {
            if (entrada.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entrada.getKey();
                System.out.println("modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }
        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }
        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("Exiba a media de consumo deste dicionario de carros: " + soma / carrosPopulares.size());
        System.out.println("Remova os modelos com o sonumo igual a 15,6 km/l: ");
        //carrosPopulares.values().removeIf(aDouble -> aDouble.equals(15.6));//metodo sugerido através da IDE.
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next().equals(15.6))
                iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba os carros na ordem em que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);

        System.out.println("Exiba o dicionario ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares2);

        System.out.println("Apague o dicionario de carros: ");
        carrosPopulares.clear();
        System.out.println("Confira se o dicionario esta vazio: " + carrosPopulares.isEmpty());
    }

}
