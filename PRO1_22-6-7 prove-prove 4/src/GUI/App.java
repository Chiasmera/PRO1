package GUI;

import Application.Controller.Controller;
import Storage.Storage;
import javafx.application.Application;

public class App {
    public static void main(String[] args) {
        try {
            Controller.initStorage();
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }


        System.out.println(Controller.holdUdenTutorer());

        System.out.println(Storage.getUddannelser().get(0).tutorOversigt());

        Controller.tutorOversigtTilFil("C:\\Users\\Julius Larsen Seerup\\IdeaProjects\\PRO1\\PRO1_22-6-7 prove-prove 4\\src\\Tutorer1.txt");

        Application.launch(MainWindow.class);

    }
}
