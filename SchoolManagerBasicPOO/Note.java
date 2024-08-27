public class Note {
    
    private int note1;
    private int note2;
    private int note3;
    private double average;

   

    public Note(int note1, int note2, int note3) {
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
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

    @Override
    public String toString() {
        return "Note [average=" + average + ", getNote1()=" + getNote1() + ", getNote2()=" + getNote2()
                + ", getNote3()=" + getNote3() + average + "]";
    }
    
    
    

    
}
