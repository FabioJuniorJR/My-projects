import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
    
    public class SchoolManagerPOO {        
        private ArrayList<Student> student = new ArrayList<>();

        //METHOD ADD Student
        public void addStudent(){

            System.out.println("Enter the Student name: ");
            String name = io.next();
            
            System.out.println("Enter the CPF Student: ");
            iny cpf = io.nextInt();

            /*
             * Criar Método ID
             * Descriçao: Pasta melhorias: https://github.com/FabioJuniorJR/My-projects/blob/18e17e847018ea3e40ce445cd2796b4a4649c6c3/SchoolManagerBasicPOO/melhorias.txt
             */

            Student student = new Student(/*Passar parametros peios aqui*/ name, cpf);
        }

        //METHOD REMOVE Student
        public void removeStudent(){


        }

        //METHOD CHANGE Student
        public void changeStudent(){
           
            
        }

        //Choose Student
            //Procurar utilizaando ID do aluno em um loop
        public void chooseStudent(){
          
            
        }

        public static void main(String[] args) {
            Scanner io = new Scanner(System.in);//io - Output and Input
            int option;

            System.out.println();
            System.out.println("|----------------------------------|");
            System.out.println("|what do you want to do now ???    |");
            System.out.println("|----------------------------------|");
            System.out.println("|1 - finish                        |");
            System.out.println("|2 - register stuednt              |");
            System.out.println("|3 - remove student                |");
            System.out.println("|4 - search for student            |");
            System.out.println("|----------------------------------|");
            System.out.println();


            option = io.nextInt();

            while(option != 0){

                switch (option) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        changeStudent();
                        break;
                    case 4:
                        chooseStudent();
                        break;
                
                    default:
                    System.out.println("option invalid !!!");
                    System.out.println("Choice other option");
                        break;
                }
            }  


        }
    }
