package GUI;


import Application.Controller.Controller;
import Application.Model.Festival;
import Application.Model.Frivillig;
import Application.Model.Job;
import Application.Model.Vagt;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HovedVindue extends Application {
    Stage stage = new Stage(StageStyle.UTILITY);

    @Override
    public void start(Stage primaryStage) {
        stage.setTitle("Festival Administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    ListView<Festival> lwFestivaller;
    ListView<Job> lwJobs;
    ListView<Frivillig> lwFrivillige;
    TextArea txaPersondetaljer;
    TextField txtTimetal;


    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblFestivaller = new Label("Festivaller");
        pane.add(lblFestivaller, 0, 0);

        lwFestivaller = new ListView<>();
        pane.add(lwFestivaller, 0, 1, 2, 1);
        lwFestivaller.prefWidth(100);

        Label lblJobs = new Label("Jobs");
        pane.add(lblJobs, 2, 0);

        lwJobs = new ListView<>();
        pane.add(lwJobs, 2, 1, 2, 1);
        lwJobs.prefWidth(100);

        Label lblFrivillige = new Label("Frivillige");
        pane.add(lblFrivillige, 4, 0);

        lwFrivillige = new ListView<>();
        pane.add(lwFrivillige, 4, 1, 2, 1);
        lwFrivillige.prefWidth(100);

        Label lblVagter = new Label("Vagter");
        pane.add(lblVagter, 6, 0);

        txaPersondetaljer = new TextArea();
        pane.add(txaPersondetaljer, 6, 1, 2, 1);
        txaPersondetaljer.prefWidth(100);

        Label lblTimer = new Label("Timer");
        pane.add(lblTimer, 4, 3);

        txtTimetal = new TextField();
        pane.add(txtTimetal, 5, 3);

        Button btnTagVagt = new Button("Tag Vagt");
        pane.add(btnTagVagt, 6, 3);
        btnTagVagt.setOnAction(event -> tagVagtEvent());

        Controller.initStorage();
        updateListViews();

        ChangeListener<Festival> festivalListener = (ov, oldFestival, newFestival) -> this.updateJobs();
        lwFestivaller.getSelectionModel().selectedItemProperty().addListener(festivalListener);

        ChangeListener<Frivillig> frivilligListener = (ov, oldFrivillig, newFrivillig) -> this.updateFrivilligInfo();
        lwFrivillige.getSelectionModel().selectedItemProperty().addListener(frivilligListener);


    }

    public void tagVagtEvent() {
        try {
            int timetal = Integer.parseInt(txtTimetal.getText());
            Job job = lwJobs.getSelectionModel().getSelectedItem();
            Frivillig frivillig = lwFrivillige.getSelectionModel().getSelectedItem();

            Controller.tagVagt(job,frivillig,timetal);

            updateFrivilligInfo();
        } catch (RuntimeException runtimeException) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(runtimeException.getMessage());
            alert.showAndWait();
        }
    }

    public void updateListViews() {
        lwFestivaller.getItems().setAll(Controller.getAllFestivaller());
        lwFrivillige.getItems().setAll(Controller.getAllFrivilige());

    }

    public void updateJobs() {
        if (lwFestivaller.getSelectionModel().getSelectedItem() != null) {
            lwJobs.getItems().setAll(lwFestivaller.getSelectionModel().getSelectedItem().getJobs());
        } else {
            lwFestivaller.getItems().clear();
        }
    }

    public void updateFrivilligInfo() {
        if (lwFrivillige.getSelectionModel().getSelectedItem() != null) {
            Frivillig frivillig = lwFrivillige.getSelectionModel().getSelectedItem();

            String infoText = frivillig.getNavn() + "\n"
                    + "Max timer:\t" + frivillig.getMaksAntalTimer() + "\n"
                    + "Timer ledige:\t" + frivillig.ledigeTimer() + "\n"
                    + "Vagter:" + "\n";

            for (Vagt vagt : frivillig.getVagter()) {
                infoText = infoText + vagt.getTimer() + " timer på vagt: " + vagt.getJob().getKode() + "\n";
            }


            txaPersondetaljer.setText(infoText);
        } else {
            txaPersondetaljer.clear();
        }
    }


}
