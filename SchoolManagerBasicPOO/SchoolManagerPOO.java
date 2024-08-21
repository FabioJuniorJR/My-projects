
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class SchoolManagerPOO {

    private static ArrayList<Student> listStudent = new ArrayList<>();
    private static Scanner io = new Scanner(System.in);// io - Output and Input

    // METHOD ADD Student
    public static void addStudent() {
        // ArrayList listAuxStudent = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter the Student name: ");
        String name = io.next();

        System.out.println("Enter the CPF Student: ");
        int cpf = io.nextInt();

        System.out.println("Enter the Birth Srudent dd/mm/aaaa: ");
        String birth = io.next();

        Student student = new Student(/* Passar parametros peios aqui */ name, cpf, birth);
        listStudent.add(student);

        // Date birthFormated = dateFormat.parse(birth);

        /*
         * 
         * Criar Método ID
         * Descriçao: Pasta melhorias:
         * https://github.com/FabioJuniorJR/My-projects/blob/
         * 18e17e847018ea3e40ce445cd2796b4a4649c6c3/SchoolManagerBasicPOO/melhorias.txt
         */

        // listAuxStudent.add(student);
        // listStudent.add(listAuxStudent);

    }

    // METHOD REMOVE Student
    public void removeStudent() {

    }

    // METHOD CHANGE Student
    public static void changeStudent() {
        for (Student listStudent : listStudent) {
            System.out.println(listStudent.toString());
        }
    }

    // Choose Student
    // Procurar utilizaando ID do aluno em um loop
    public static void chooseStudent() {

    }

    public static int mainMenu(){
        int option;
        System.out.println();
        System.out.println("|----------------------------------|");
        System.out.println("|what do you want to do now ???    |");
        System.out.println("|----------------------------------|");
        System.out.println("|0 - finish                        |");
        System.out.println("|1 - register stuednt              |");
        System.out.println("|2 - remove student                |");
        System.out.println("|3 - search for student            |");
        System.out.println("|4 - chooseStudent                 |");
        System.out.println("|5 - realod                        |");
        System.out.println("|----------------------------------|");
        System.out.println();
        option = io.nextInt();
        return option;
    }

    public static void main(String[] args) {
        int optionMain;
        optionMain = mainMenu();

        while (optionMain != 0) {

            switch (optionMain) {
                case 1:
                    addStudent();
                    optionMain = mainMenu();
                    break;
                case 2:
                    // removeStudent();
                    break;
                case 3:
                    changeStudent();
                    break;
                case 4:
                    //chooseStudent();
                    break;
                default:
                    System.out.println("option invalid !!!");
                    System.out.println("Choice other option");
                    break;
            }
        }
        io.close();

    }
}
