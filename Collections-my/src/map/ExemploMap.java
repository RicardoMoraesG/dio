package map;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os modelos ");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 14.4);
            put("mobi", 14.4);
            put("hb20", 14.4);
            put("kwid", 14.4);
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
        /*
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();//
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }
        */



    }

}
