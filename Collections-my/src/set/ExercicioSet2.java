package set;

import java.util.*;

public class ExercicioSet2 {
    public static void main(String[] args) {

        System.out.println("--A \tOrdem de Inserção\t--");//LinkedHashSet
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>() {{
            add(new LinguagemFavorita("Java", "1991", "IntelliJ"));
            add(new LinguagemFavorita("C++", "1983", "Dev-C++"));
            add(new LinguagemFavorita("PHP", "1995", "Eclipse"));
        }};
        System.out.println(linguagens);

        System.out.println("\n--B \tOrdem de Natural(nome)\t--");
        Set<LinguagemFavorita> ordemPorNomes = new TreeSet<>(linguagens);
        System.out.println(ordemPorNomes);

        System.out.println("\n--C \tOrdem de IDE\t--");
        Set<LinguagemFavorita> ordemPorIde = new TreeSet<>(new ComparatorIDE());
        ordemPorIde.addAll(linguagens);
        System.out.println(ordemPorIde);

        System.out.println("\n--D \tOrdem de Ano e Nome\t--");
        Set<LinguagemFavorita> ordemAnoNome = new TreeSet<>(new ComparatorAnoNome());
        ordemAnoNome.addAll(linguagens);
        System.out.println(ordemAnoNome);

        System.out.println("\n--E \tOrdem de Nome, Ano, IDE\t--");
        Set<LinguagemFavorita> ordemNomeAnoIde = new TreeSet<>(new ComparatorNomeAnoIde());
        ordemNomeAnoIde.addAll(linguagens);
        System.out.println(ordemNomeAnoIde);
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    private String nome;
    private String anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, String anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public String getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public String toString() {
        return " (" + nome + ' ' +
                " " + anoDeCriacao + ' ' +
                " ide:" + ide +
                ") ";
    }

    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        return this.getNome().compareToIgnoreCase(linguagem.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}

class ComparatorAnoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        //se  ano for diferente, compara organiza por ano
        int ano = o1.getAnoDeCriacao().compareToIgnoreCase(o2.getAnoDeCriacao());
        if (ano != 0) return ano; //o método Set<> não mostra iguais.
        //senão, compara por nome
        return o1.getNome().compareToIgnoreCase(o2.getNome());

    }
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if (nome != 0) return nome;
        int ano = o1.getAnoDeCriacao().compareToIgnoreCase(o2.getAnoDeCriacao());
        if (ano != 0) return ano;
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}