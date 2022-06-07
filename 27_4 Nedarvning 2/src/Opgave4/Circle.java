package Opgave4;

public class Circle extends Figur{
    //fields
    private int radius;

    //Constructor
    public Circle (int x, int y, int radius) {
        super(x,y);
        this.radius = radius;
    }

    //Methods
    @Override
    public double calcArea () {
        double area = Math.PI * radius * radius;
        return area;
    }

    public int getRadius() {
        return radius;
    }
}
