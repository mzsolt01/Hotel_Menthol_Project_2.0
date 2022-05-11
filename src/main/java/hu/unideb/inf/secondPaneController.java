package hu.unideb.inf;

import hu.unideb.inf.model.Guest;
import hu.unideb.inf.model.GuestDAO;
import hu.unideb.inf.model.JpaGuestDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class secondPaneController {
    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField LastName;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField SzemIgSzam;

    @FXML
    private TextField Tel;

    @FXML
    private TextField Email;

    @FXML
    void pushedNext(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/3rd_pane.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                nextButton.getScene().getWindow();
        stage2.close();
        stage.setTitle("Hotel Menthol");
        stage.setScene(scene);
        stage.show();
        textHandler();
    }

    @FXML
    void pushedBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/firstPane.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                backButton.getScene().getWindow();
        stage2.close();
        stage.setTitle("Hotel Menthol");
        stage.setScene(scene);
        stage.show();
    }

    public void textHandler() {
        //try-with-resources
        try (GuestDAO aDAO = new JpaGuestDAO();) {
            Guest guest = new Guest();
            guest.setLastName(LastName.getText());
            guest.setFirstName(FirstName.getText());
            guest.setSzemIgSzam(SzemIgSzam.getText());
            guest.setTel(Tel.getText());
            guest.setEmail(Email.getText());

            aDAO.saveGuest(guest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
