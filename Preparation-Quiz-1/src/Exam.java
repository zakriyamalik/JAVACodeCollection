public class Exam {
    private int id;
    private int marks;
    private String name;


    public Exam() {
    }

    public Exam(int var1) {
        this.setId(var1);
    }

    public Exam(int var1, int var2) {
        this(var1);
        this.marks = var2;
    }

    public Exam(int var1, int var2, String var3) {
        this(var1, var2);
        this.name = var3;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int var1) {
        if (var1 > 0) {
            this.id = var1;
        } else {
            this.id = -1;
        }

    }

    public int getMarks() {
        return this.marks;
    }

    public void setMarks(int var1) {
        this.marks = var1;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String var1) {
        this.name = var1;
    }

    void print() {
        System.out.println(this.toString());
    }

    public String toString() {
        return "Test Information\nID : " + this.id + "\nNAME : " + this.name + "\nMarks : " + this.marks + "\n";
    }
    @Override
    protected void finalize()
    {
        System.out.println("This message is from finalize");
    }
}

