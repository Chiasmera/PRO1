package opgave4barchart;

public class BarLine {
    String title;
    int value;

    public BarLine (String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
