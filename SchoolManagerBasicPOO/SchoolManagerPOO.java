
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class SchoolManagerPOO {

    static ArrayList<Student> listStudent = new ArrayList<>();
 
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
    }

    
    public void removeStudent() {

    }

    public static void changeStudent(){

    }

    public static void printStudent() {
        for (Student listStudentPrint : listStudent) {
            System.out.println(listStudentPrint.toString());
        }
    }

    public static void chooseStudent() {
        System.out.println("Enter CPF to the Student: ");
        double cpfSearch = io.nextDouble();
         for(Student listStudentSearch : listStudent){
            if(listStudentSearch.getCPF() == cpfSearch){
                /*
                 * IMPLEMENTS
                 * 
                 * Altera:
                 * nome
                 * nascimento
                 * cpf
                 */

            }
         }
    }

    public static void addNote(){
        
    }

    public static void NoteStudent(){
        Note note = new Note();
        System.out.println("Enter the Student note1: ");
        int note1 = io.nextInt();
        note.setNote1(note1);
        System.out.println("Enter the Student note2: ");
        int note2 = io.nextInt();
        note.setNote2(note2);
        System.out.println("Enter the Student note3: ");
        int note3 = io.nextInt();
        note.setNote3(note3);
    }

    public static int mainMenu(){
        int option;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
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
        System.out.print("|Option: ");
        option = io.nextInt();
        System.out.println("|----------------------------------|");
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
                    printStudent();
                    optionMain = mainMenu();
                    break;
                case 4:
                    chooseStudent();
                    optionMain = mainMenu();
                    break;
                default:
                    System.out.println("option invalid !!!");
                    System.out.print("Choice other option");
                    optionMain = mainMenu();
                    break;
            }
        }
        io.close();

    }
}
