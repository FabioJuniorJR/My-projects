public class Nota {
    
    private int note1;
    private int note2;
    private int note3;
    private double average;

    public Nota() {
        //Nãao tem paraametros iniciais
        //Não é necessário começar com notas
        //A NOTAS SÃO ADICIONADAAS COM O TEMPO
    }

    public int getNote1() {
        return note1;
    }

    public void setNote1(int note1) {
        this.note1 = note1;
    }

    public int getNote2() {
        return note2;
    }

    public void setNote2(char note2) {
        this.note2 = note2;
    }

    public int getNote3() {
        return note3;
    }

    public void setNote3(int note3) {
        this.note3 = note3;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        average = ((note1 / 3.5) + (note2/3.5) + (note3/3));
    }

    

    
}
