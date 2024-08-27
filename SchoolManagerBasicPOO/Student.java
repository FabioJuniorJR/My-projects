import java.util.ArrayList;
import java.util.List;

public class Student{
    //private char id;
    private String name;
    private int CPF;
    private String birth;
    private List<Note>notas;

    
   
    public Student(String name, int cPF, String birth) {
        this.name = name;
        CPF = cPF;
        this.birth = birth;
        this.notas = new ArrayList<>(); 
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }
    
    public List<Note> getNotas() {
        return notas;
    }
    /*public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }*/
    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setNotas(List<Note> notas) {
        this.notas = notas;
    }

    public String getBirth() {
        return birth;
    }

    public void addNote(Note notas){
        this.notas.add(notas);
    }

    public List<Note> getNote(){
        return notas;
    } 

    @Override
    public String toString() {
        return "Student [ Name = " + name + ", CPF = " + CPF + ", birth = " + birth + ", notas =[ " + notas.toString() + " ]";
    }

    
}