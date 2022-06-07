package Opgave4;

public class Elipsis extends Circle{
    //Fields
    private int radius2;

    //constructor
    public Elipsis (int x, int y, int radius, int radius2) {
        super(x,y,radius);
        this.radius2 = radius2;
    }

    //Methods
    @Override
    public double calcArea () {
        double area = Math.PI * getRadius() * radius2;
        return area;
    }

    public int getRadius2() {
        return radius2;
    }
}
