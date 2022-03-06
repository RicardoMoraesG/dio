package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoDeLista {

    public static void main(String[] args) {

        List<Gato> gatos = new ArrayList<>() {{
            add(new Gato("Tom", 62, "Cinza"));
            add(new Gato("Felix", 113, "Preto"));
            add(new Gato("Garfield", 44, "Alaranjado"));
            add(new Gato("Tom", 17, "Azul"));
        }};
        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println(gatos);

        System.out.println("--\tOrdem de Aleatória\t--");
        Collections.shuffle(gatos);//mistura a ordem
        System.out.println(gatos);

        System.out.println("--\tOrdem de Natural (Nome) \t--");
        Collections.sort(gatos);//precisa implementar a interface Comparator na classe gato com o metodo compareTo.
        System.out.println(gatos);

        //pode usar a class Collections ou
        //o metodo sort(). Em ambos, é necessário um objeto que implementa
        // a classe Comparator. Nesse caso, criou a class ComparatorIdade implements Comparator<Gato>
        //retornando um Integer pelo método compare().
        System.out.println("--\tOrdem de Idade  \t--");
        //Collections.sort(gatos, new ComparatorIdade());
        gatos.sort(new ComparatorIdade());
        System.out.println(gatos);
        System.out.println("--\tOrdem de Cor  \t--");
        gatos.sort(new ComparatorCor());
        System.out.println(gatos);

        System.out.println("--\tOrdem de Nome/Cor/Idade \t--");
        gatos.sort(new ComparatorNomeCorIdade());
        System.out.println(gatos);
    }


}


class Gato implements Comparable<Gato> {


    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    /**
     * Método da interface Comparable.
     *
     * @param gato
     * @return
     */
    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato gato1, Gato gato2) {
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato gato1, Gato gato2) {
        return gato1.getCor().compareToIgnoreCase(gato2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato gato1, Gato gato2) {
        int nome = gato1.getNome().compareToIgnoreCase(gato2.getNome());
        if (nome != 0) return nome;
        int cor = gato1.getCor().compareToIgnoreCase(gato2.getCor());
        if (cor != 0) return cor;
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }
}