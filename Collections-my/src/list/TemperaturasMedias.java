package list;

import java.util.*;

/**
 * Exercício Proposto nº1 na Aula de Listas Ordenadas.
 */

public class TemperaturasMedias {

    //Atributos da temperatura mensal.
    private Mes mes;
    private int temperatura;

    //Construtor
    public TemperaturasMedias(Mes mes, int temperatura) {
        this.mes = mes;
        this.temperatura = temperatura;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public static void main(String[] args) {
        //Utiliza essa opção de lista para não alterar os MESES.
        final List<Mes> MESES = Arrays.asList(
                new Mes(1, "Janeiro"),
                new Mes(2, "Fevereiro"),
                new Mes(3, "Março"),
                new Mes(4, "Abril"),
                new Mes(5, "Maio"),
                new Mes(6, "Junho"),
                new Mes(7, "Julho"),
                new Mes(8, "Agosto"),
                new Mes(9, "Setembro"),
                new Mes(10, "Outubro"),
                new Mes(11, "Novembro"),
                new Mes(12, "Dezembro")
        );

        /*
         * A tentativa de incrementar essa lista
         * MESES.add(new Mes(13,"Saturno"));
         * gera uma Exceção e finaliza a execução:
         * Exception in thread "main" java.lang.UnsupportedOperationException
         * 	at java.base/java.util.AbstractList.add(AbstractList.java:153)
         * 	at java.base/java.util.AbstractList.add(AbstractList.java:111)
         * 	at list.TemperaturasMedias.main(TemperaturasMedias.java:35)
         */

        /*
        //Essa opção poderia ser manipulada.
        List<Mes> MESES = new ArrayList<>() {{
            add(new Mes(1, "Janeiro"));
            add(new Mes(2, "Fevereiro"));
            add(new Mes(3, "Março"));
            add(new Mes(4, "Abril"));
            add(new Mes(5, "Maio"));
            add(new Mes(6, "Junho"));
            add(new Mes(7, "Julho"));
            add(new Mes(8, "Agosto"));
            add(new Mes(9, "Setembro"));
            add(new Mes(10, "Outubro"));
            add(new Mes(11, "Novembro"));
            add(new Mes(12, "Dezembro"));
        }};
        */
        //Cria a lista que guarda as temperaturas mensais.
        List<TemperaturasMedias> anual = new ArrayList<>();

        //a iteração que faz a composição da lista criada acima.
        int soma = 0;
        int index = 0;
        Iterator<Mes> iteratorAno2021 = MESES.iterator();
        while (iteratorAno2021.hasNext()) {
            Mes mesAtual = iteratorAno2021.next();
            anual.add(new TemperaturasMedias(mesAtual, temperaturaRegistrada()));
            soma += anual.get(index).getTemperatura();
            index += 1;
        }
        int mediaTemperaturas = soma /= index + 1;
        Iterator<Mes> AnoCorrente = MESES.iterator();
        System.out.println("Meses acima da média: ("+ mediaTemperaturas + "ºC)");
        while ((AnoCorrente.hasNext())) {
            int mesAtual = AnoCorrente.next().getOrdem() - 1;
            if ((anual.get(mesAtual).getTemperatura()) > mediaTemperaturas) {
                System.out.println(anual.get(mesAtual));
            }
        }
    }

    /**
     * Simulando que a temperatura venha de uma entrada.
     *
     * @return int. Um número aleatório entre 0 e 42.
     */
    public static int temperaturaRegistrada() {
        Random dados = new Random();
        int minima = dados.nextInt(20);//varia de 0 a 20.
        int maxima = 42;
        int temperatura = dados.nextInt((maxima - minima) + 1) + minima;
        return temperatura;
    }

    /**
     * Exibição limpa. Exemplo: 1 - Janeiro: 28ºC.
     *
     * @return String
     */
    @Override
    public String toString() {
        return mes +
                ": " + temperatura + "ºC";
    }
}

/**
 * Organiza os atributos do mês em um unico objeto.
 */
class Mes {
    int ordem;
    String nome;

    public Mes(int ordem, String nome) {
        this.ordem = ordem;
        this.nome = nome;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return ordem + " - " + nome;
    }
}

