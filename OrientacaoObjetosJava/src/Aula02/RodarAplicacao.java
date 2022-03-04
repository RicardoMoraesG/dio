package Aula02;

public class RodarAplicacao {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();

        //trazendo as classes filhas para a classe mae.
        //Upcast - são subtipos elevados ao tipo acima( tipo mais generico)
        Funcionario gerente = new Gerente();
        Funcionario vendedor = new Vendedor();
        Funcionario faxineiro = new Faxineiro();

        //Gerente gerente = new Funcionario();
        //Classe mãe, trazendo para a classe filha.
        //Vendedor vendedor1 = (vendedor) new Funcionario()//Downcast dá erro. EVITE.
    }



}
