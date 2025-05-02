package treino_Array;
import java.util.Scanner;

public class Array{
    private int lengthArray = 3;
    private int array[] = new int[lengthArray];//começa com 3 posições

    public Array(){ //Construtor
        //vazio Não precimos usar
        //Apenas para garantir a inicalização correta dos atributos com valor padrao caso algo de errado
    }
    Scanner teclado = new Scanner(System.in);

    public void incluirValor(){
        int valor = 0;
        int posFim = 0;
        while(posFim < array.length)
        if(posFim == array.length){
        System.out.print("Digite o valor que deseja incluir: ");
        array[valor] = teclado.nextInt();
        }
    }

    public void pesquisaValor(){

    }

    public void alterarValor(){

    }

    public void excluirValor(){

    }

    public void oredenarArray(){

    }

    public void aumenatarTamanhoArray(){
        verificaCheio();
    }

    public void verificaCheio(){
        int cheio;
        int vazio;
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                vazio = 1; //Se o vetor estiver vazio a variavel vazio recebe 1 para processguir com o set. O numero 1 server para dizer que cabe mais valores.
            }else{
                cheio = 0;//Se o vetor estiver cheio a variavel cheio recebe 0 para nao processguir com o set. O numero 0 server para dizer que nao cabe mais valores.
            }
        }
    }

    public void imprimiArray(){
        System.out.print("[");
        for(int valorIndice = 0 ; valorIndice < array.length; valorIndice++){
            if(array[valorIndice] == 0){
            System.out.print("null, ");
            }else{
                System.out.print(array[valorIndice] + ", ");
            }
            
           
        }
        System.out.print("]");
    }
    


}
//int array[] = new int[n];