package E5_7;

public class Increasing {

    public String IsIncreasing (int input1, int input2, int input3) {
        if (input1 < input2 && input2 < input3) {
            return "increasing";
        } else if (input1 > input2 && input2 > input3) {
            return "decreasing";
        } else {
            return "neither increasing nor decreasing";
        }

    }
}
