package Opgave4;

public abstract class Figur {
    //Fields
    private int x;
    private int y;

    //constructor
    public Figur (int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Methods

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translateX (int value) {
        x += value;
    }

    public void translateY (int value) {
        y += value;
    }

    public void translateXY (int xValue, int yValue) {
        translateX(xValue);
        translateY(yValue);
    }

    public abstract double calcArea ();
}
