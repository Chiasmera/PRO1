package Opgave5;

public class CopierApp {
    public static void main(String[] args) {
        Copier kopimaskine = new Copier();

        kopimaskine.makeCopy();
        kopimaskine.insertPaper(1000);
        kopimaskine.insertPaper(400);
        kopimaskine.makeCopy();
        kopimaskine.makePaperJam();
        kopimaskine.makeCopy();
        kopimaskine.fixJam();
        kopimaskine.makeCopy();
        System.out.println("There is :"+kopimaskine.getPaper()+"paper left");
    }
}
