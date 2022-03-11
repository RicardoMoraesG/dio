package list;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
 * "Telefonou para a vítima?"
 * "Esteve no local do crime?"
 * "Mora perto da vítima?"
 * "Devia para a vítima?"
 * "Já trabalhou com a vítima?"
 * Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita",
 * entre 3 e 4 como "Cúmplice"
 * e 5 como "Assassina".
 * Caso contrário, ela será classificado como "Inocente".
 */

public class Inquerito {

    public static void main(String[] args) {
        List<Pergunta> listaDePerguntas = new ArrayList<>();
        listaDePerguntas.add(new Pergunta("Telefonou para a vítima?"));
        listaDePerguntas.add(new Pergunta("Esteve no local do crime?"));
        listaDePerguntas.add(new Pergunta("Mora perto da vítima?"));
        listaDePerguntas.add(new Pergunta("Devia para a vítima?"));
        listaDePerguntas.add(new Pergunta("Já trabalhou com a vítima?"));

        listaDePerguntas.forEach(Pergunta::setResposta);//recebe as respostas
        Inquerito suspeito = new Inquerito(0);//inicia com zero pontos.

        listaDePerguntas.forEach(resposta -> suspeito.setAvaliacao(resposta.getResposta()));//metodo setAvaliacao é iterativo.
        System.out.println(suspeito.getClassificacao());//avalia a soma das resposta e classifica conforme a regra.
    }

    private int avaliacao;
    private String classificacao;

    public Inquerito(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao += avaliacao;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    /**
     * regra de classificação.
     * @return
     */
    public String getClassificacao() {
        switch (this.getAvaliacao()) {
            case 2:
                this.classificacao = "Suspeita";
                break;
            case 3:
            case 4:
                this.classificacao = "Cúmplice";
                break;
            case 5:
                this.classificacao = "Assassina";
                break;
            default:
                this.classificacao = "Inocente";
        }
        return this.classificacao;
    }


}

class Pergunta {
    private String pergunta;
    private int resposta;


    public Pergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta() {
        //Este JOption retorna 0 para YES e 1 para NO.
        int opcao = JOptionPane.showConfirmDialog(null, this.getPergunta(), "Opção", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) { //inverti para a lógica do exercicio.
            this.resposta = 1;
        } else this.resposta = 0;
    }

    @Override
    public String toString() {
        return pergunta + '\'' +
                ", resposta=" + resposta;
    }
}
