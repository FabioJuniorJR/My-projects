import java.util.List;

public class Student{
    //private char id;
    private String name;
    private int CPF;
    private String birth;
    private List<Nota>notas;

    public Student(/*char id*/ String name, int CPF, String birth) {
        //this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.birth = birth;
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
    
    public List<Nota> getNotas() {
        return notas;
    }
    /*public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }*/
    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public String getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "Student [ Name = " + name + ", CPF = " + CPF + ", birth = " + birth + ", notas = " + notas + " ]";
    }

    
}