package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class firstPaneController {
    @FXML
    private Button nextButton;

    @FXML
    void next(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/2nd_pane.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                nextButton.getScene().getWindow();
        stage2.close();
        stage.setTitle("Hotel Menthol");
        stage.setScene(scene);
        stage.show();
    }
}
