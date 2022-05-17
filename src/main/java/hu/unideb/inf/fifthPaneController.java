package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import javafx.scene.image.Image;

public class fifthPaneController {
    @FXML
    private Button foglalasButton;

    @FXML
    private Button backButton;

    @FXML
    private TextArea MyTextArea;

    public static TextArea MytextAreaStatic;

    @FXML
    private Label CheckInLabel;

    public static Label CheckInLabelStatic;

    @FXML
    private Label CheckOutLabel;

    public static Label CheckOutLabelStatic;

    @FXML
    public void initialize() {
        MytextAreaStatic = MyTextArea;
        CheckOutLabelStatic = CheckOutLabel;
        CheckInLabelStatic = CheckInLabel;
    }

    @FXML
    void pushedFoglalas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/6th_pane.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                foglalasButton.getScene().getWindow();
        stage2.close();
        stage.setTitle("Hotel Menthol!");
        Image image = new Image("/fxml/logo-removebg-preview.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        MyTextArea.clear();
    }

    @FXML
    void pushedBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/4th_pane.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                backButton.getScene().getWindow();
        stage2.close();
        stage.setTitle("Hotel Menthol");
        Image image = new Image("/fxml/logo-removebg-preview.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }


}
