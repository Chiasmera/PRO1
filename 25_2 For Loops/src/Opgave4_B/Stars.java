package Opgave4_B;

public class Stars {
    final int MAX_ROWS = 10;

    public void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int space = 1; space <= 11 - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureA() {
        // TODO
    }

    public void starPictureB() {
        // TODO
    }

    public void starPictureC() {
        // TODO
    }

    public void starPictureD() {
        // TODO
    }

}
