package Opgave4_C;

public class Stars {
    final int MAX_ROWS = 10;

    public void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int space = 0; space <= row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 11 - row; star++) {
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
