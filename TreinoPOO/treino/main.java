package treino;
public class main{

    public static void main(String []args){
        Pessoa p1 = new Pessoa();//Instancia o objeto Pessoa com nome p1
        Pessoa p2 = new Pessoa();
        System.out.println("-------------------------------------------------");
        p1.setNome("Gabriela");
        p1.setCpf("327.123.546-Y");
        p1.setSexo("Feminino");
        System.out.println(p1.toString());
        System.out.println();
        System.out.println("Nome: " + p1.getNome());
        System.out.println("CPF: " + p1.getCpf());
        System.out.println("Sexo: " + p1.getSexo());
        System.out.println("-------------------------------------------------");
        p2.setNome("Fabio");
        p2.setCpf("657.928.734-X");
        p2.setSexo("Masculino");
        System.out.println(p2.toString());
        System.out.println();
        System.out.println("Nome: " + p2.getNome());
        System.out.println("CPF: " + p2.getCpf());
        System.out.println("Sexo: " + p2.getSexo());
        System.out.println("-------------------------------------------------");
        System.out.println();
    }
}