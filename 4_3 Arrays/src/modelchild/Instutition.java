package modelchild;

public class Instutition {
    //Fields
    String navn;
    String adresse;
    Child[] tilmeldteBørn = new Child[100];
    int nuværendeTilmeldte = 0;


    //Constructor
    public Instutition (String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    //Methods - Get & Set
    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    //Methods - Others
    public void addChild (Child child) {
        tilmeldteBørn[nuværendeTilmeldte] = child;
        nuværendeTilmeldte++;
    }

    public double averageAge () {
        double ageSum = 0;
        for (int i = 0; i < nuværendeTilmeldte; i++) {
            ageSum = ageSum + tilmeldteBørn[i].getAge();
        }
        return ageSum / nuværendeTilmeldte;
    }

    public int numberOfGirls () {
        int numGirls = 0;
        for (int i = 0; i < nuværendeTilmeldte; i++) {
            if (!tilmeldteBørn[i].isBoy()) {
                numGirls++;
            }
        }
        return  numGirls;
    }

    public int numberOfBoys () {
        int numBoys = 0;
        for (int i = 0; i < nuværendeTilmeldte; i++) {
            if (tilmeldteBørn[i].isBoy()) {
                numBoys++;
            }
        }
        return  numBoys;
    }
}
