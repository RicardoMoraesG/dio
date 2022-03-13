package map;

import java.util.*;

public class ExemploOrdenacaoMap {

    public static void main(String[] args) {

        System.out.println("Ordem aleatória ");
        Map<String, Livro> meusLivros = new HashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhig, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros.entrySet()) {
            System.out.println(livro.getKey() + "-" + livro.getValue().getNome());
        }
        System.out.println("ordem de inserção: ");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhig, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro1 : meusLivros1.entrySet()) {
            System.out.println(livro1.getKey() + "-" + livro1.getValue().getNome());
        }

        System.out.println("Ordem alfabética Autores");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros);
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("Ordem Alfabética dos livros: ");
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro3 : meusLivros3) {
            System.out.println(livro3.getKey() + " - " + livro3.getValue().getNome());
        }

        System.out.println("Ordem por numero de páginas: ");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNumeroPaginas());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros4) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " Páginas: " + livro.getValue().getPaginas() );
        }


    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}
class ComparatorNome implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
    }
}
class ComparatorNumeroPaginas implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return livro1.getValue().getPaginas().compareTo(livro2.getValue().getPaginas());
    }
}