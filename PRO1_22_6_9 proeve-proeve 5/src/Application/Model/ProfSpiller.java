package Application.Model;

public class ProfSpiller extends Spiller{

    private double kampHonorar;

    public ProfSpiller(String navn, int aargang, double kampHonorar) {
        super(navn, aargang);
        this.kampHonorar = kampHonorar;
    }

    public double getKampHonorar() {
        return kampHonorar;
    }

    @Override
    public double kampHonorar () {
        double kampe = 0;
        int afbud = 0;
        for (Deltagelse d : super.getDeltagelser()) {
            if (d.isAfbud()) {
                afbud++;
            }
            kampe++;
        }
        double modifier = 1 - (afbud / kampe);

        return kampHonorar * modifier;
    }
}
