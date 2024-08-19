import java.util.List;

public class Student{
    private char id;
    private String name;
    private int CPF;
    private List<Nota>notas;

    public Student(char id, String name, int cPF) {
        this.id = id;
        this.name = name;
        CPF = cPF;
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

    public void setCPF(int cPF) {
        CPF = cPF;
    }
    
    public List<Nota> getNotas() {
        return notas;
    }
    //lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll
    /*public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }*/

    
}