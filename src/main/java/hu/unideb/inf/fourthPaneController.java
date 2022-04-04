package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class fourthPaneController {
    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    void pushedNext(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/5th_pane.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                nextButton.getScene().getWindow();
        stage2.close();
        stage.setTitle("Foglalás");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void pushedBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/3rd_pane.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                backButton.getScene().getWindow();
        stage2.close();
        stage.setTitle("Foglalás");
        stage.setScene(scene);
        stage.show();
    }
}
