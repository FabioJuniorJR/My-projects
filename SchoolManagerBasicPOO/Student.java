import java.util.List;

public class Student{
    //private char id;
    private String name;
    private int CPF;
    Date birth;
    private List<Nota>notas;

    public Student(/*char id*/ String name, int CPF, String birth) {
        //this.id = id;
        this.name = name;
        CPF = cPF;
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
        CPF = cPF;
    }
    
    public List<Nota> getNotas() {
        return notas;
    }
    /*public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }*/
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    
}