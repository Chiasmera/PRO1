package Opgave4;

public class Rectangle extends Kvadrat {
    //Fields
    private int length;
    private int width;


    //Constructor
    public Rectangle (int x, int y, int length, int width) {
        super(x,y, length);
        this.width = width;
    }

    //Methods
    @Override
    public double calcArea () {
        double area = length * width;
        return area;
    }

}
