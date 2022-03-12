package set;

import java.util.*;

public class ExercicioSet1 {

    public static void main(String[] args) {


        System.out.println("A - Exiba as cores uma abaixo da outra.");
        Set<Cor> arcoIris = new LinkedHashSet<>() {{//exibe em ordem de Inserção
            add(new Cor("Vermelho"));
            add(new Cor("Laranja"));
            add(new Cor("Amarelo"));
            add(new Cor("Verde"));
            add(new Cor("Azul"));
            add(new Cor("Anil"));
            add(new Cor("Violeta"));
        }};
        for (Cor cor : arcoIris) System.out.println(cor.getCor());


        System.out.println("B - A quantidade de cores que o arco-irís tem: " + arcoIris.size());

        System.out.println("C - Exiba as cores em ordem alfabética: ");//precisa implementar Comparator na classe.
        Set<Cor> arcoIrisAlfabetico = new TreeSet<>(arcoIris);
        System.out.println(arcoIrisAlfabetico);

        System.out.println("D - Exiba as cores na ordem inversa da que foi informada.");
        List<Cor> arcoIrisInverso = new ArrayList<>(arcoIris);//passando a lista para o tipo List<>
        Collections.reverse(arcoIrisInverso);//precisa de um tipo List<> como argumento.
        System.out.println("Original: " + arcoIris);
        System.out.println("Inverso:  " + arcoIrisInverso);

        System.out.println("E - Exiba as cores que começam com a letra V: ");
        for (Cor cor : arcoIris) {
            String corV = cor.getCor();
            if (corV.startsWith("V"))
                System.out.println(cor);
        }

        System.out.println("F - Remova todas as cores que não começam com a letra V");
        Iterator<Cor> corIterator = arcoIris.iterator();
        while (corIterator.hasNext()) {
            String nextCor = String.valueOf(corIterator.next());//precisa converter para usar o metodo startsWitch()
            if (nextCor.startsWith("V")) {
                System.out.println("Cor removida: " + nextCor);
                corIterator.remove();
            }
        }
        System.out.println("Arco iris sem as cores: " + arcoIris);

        System.out.println("G - Limpe o conjunto: ");
        arcoIris.clear();
        System.out.println("Conferindo se está vazio: " + arcoIris.isEmpty());


    }
}


class Cor implements Comparable<Cor> {

    private String cor;

    public Cor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cor cor1 = (Cor) o;
        return Objects.equals(cor, cor1.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cor);
    }

    @Override
    public String toString() {
        return cor;
    }

    @Override
    public int compareTo(Cor cor) {
        return this.getCor().compareTo(cor.getCor());
    }
}