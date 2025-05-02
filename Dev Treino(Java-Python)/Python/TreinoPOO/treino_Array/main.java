package treino_Array;

import java.util.Scanner;
public class main{

    public static void main(String []args){
                Array array = new Array();
        Scanner keyb = new Scanner(System.in);
        int opcao_Sistema_Funciona_Sai;
        do{
            System.out.println(" ---------------------");
            System.out.println("|        Menu         |");
            System.out.println(" ---------------------");
            System.out.println("| 1 - Incluir Valor   |");
            System.out.println("| 2 - Pesquisar Valor |");
            System.out.println("| 3 - Alterar Valor   |");
            System.out.println("| 4 - Excluir Valor   |");
            System.out.println("| 5 - Ordenar Array   |");
            System.out.println("| 6 - Imprimir Array  |");
            System.out.println("| 7 - Sair do Sistema |");
            System.out.println(" ---------------------");
            System.out.print(" Opção: ");
            opcao_Sistema_Funciona_Sai = keyb.nextInt();

            switch(opcao_Sistema_Funciona_Sai){
                case 1:
                    array.incluirValor();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    array.imprimiArray();
                    break;
                case 7:

                    break;
            }
            int espacoRetorno = 0;
            while(espacoRetorno != 4){
                System.out.println("");
                espacoRetorno ++;
            }
            
        }while(opcao_Sistema_Funciona_Sai != 7);


    }
}
