package Opgave4;

public class Kvadrat extends Figur {
    //Fields
    private int length;


    //Constructor
    public Kvadrat (int x, int y, int length) {
        super(x,y);
        this.length = length;
    }

    //Methods
    @Override
    public double calcArea () {
        double area = length * length;
        return area;
    }


}
