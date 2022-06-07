package Opgave5;

public class Copier {

    //Fields
    private int paper;
    private boolean paperStuck;

    //Constructors
    public Copier() {
        paper = 0;
    }

    public Copier(int paper) {
        this.paper = paper;
    }

    //Methods
    public void insertPaper(int paper) {
        if ((this.paper + paper) <= 500) {
            this.paper = this.paper + paper;
        } else {
            System.out.println("Not enough space for that much paper!");
        }

    }

    public int getPaper() {
        return paper;
    }

    public void makeCopy() {
        if (paperStuck) {
            System.out.println("There is a paperjam!");
        } else if (paper == 0) {
            System.out.println("Missing Paper");
        } else {
            paper--;
        }
    }

    public void makeCopy(int copies) {
        if (paperStuck) {
            System.out.println("There is a paperjam!");
        } else if (paper == 0) {
            System.out.println("Missing Paper");
        } else {
            paper = paper - copies;
        }
    }

    public void makePaperJam () {
        paperStuck = true;
    }

    public void fixJam () {
        paperStuck = false;
    }
}
