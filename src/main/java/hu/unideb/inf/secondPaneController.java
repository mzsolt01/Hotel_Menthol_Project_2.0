package hu.unideb.inf;

import hu.unideb.inf.model.Guest;
import hu.unideb.inf.model.GuestDAO;
import hu.unideb.inf.model.JpaGuestDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.regex.Pattern;

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
        if(isValidLName(LastName.getText()) == true && isValidFName(FirstName.getText()) == true && isValidTel(Tel.getText()) == true
        && isValidId(SzemIgSzam.getText()) == true && isValidEmail(Email.getText()) == true) {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/3rd_pane.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            Stage stage2 = (Stage)
                    nextButton.getScene().getWindow();
            stage2.close();
            stage.setTitle("Hotel Menthol");
            Image image = new Image("/fxml/logo-removebg-preview.png");
            stage.getIcons().add(image);
            stage.setScene(scene);
            stage.show();
            textHandler();
        } else if(isValidLName(LastName.getText()) == false || isValidFName(FirstName.getText()) == false || isValidTel(Tel.getText()) == false
                || isValidId(SzemIgSzam.getText()) == false || isValidEmail(Email.getText()) == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Hibás adatok!");
            alert.setContentText("Próbálja meg újra megadni az adatokat.");
            alert.showAndWait();
            Email.clear();
            LastName.clear();
            FirstName.clear();
            SzemIgSzam.clear();
            Tel.clear();
        }

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
        Image image = new Image("/fxml/logo-removebg-preview.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    public boolean isValidEmail(String mail) {
        boolean valid = false;

        final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i< mail.length(); i++)
        {
            if (mail.matches(regex)) {
                valid = true;
            }
        }

        return valid;

    }

    public boolean isValidId(String id) {
        boolean valid = false;

        final String regex = "^[0-9]{6}+[a-zA-Z]{2}$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < id.length(); i++) {
            if (id.matches(regex)) {
                valid = true;
            }
        }
        return valid;
    }

    public boolean isValidTel(String tel) {

        boolean valid = false;

        final String regex = "^[+]?+[0-9]{6,14}$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < tel.length(); i++) {
            if (tel.matches(regex)) {
                valid = true;
            }
        }
        return valid;
    }

    public boolean isValidFName(String fname) {
        boolean valid = false;

        final String regex = "^[A-Z]++[a-z]+$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < fname.length(); i++) {
            if (fname.matches(regex)) {
                valid = true;
            }
        }
        return valid;
    }

    public boolean isValidLName(String lname) {
        boolean valid = false;

        final String regex = "^[A-Z]++[a-z]+$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < lname.length(); i++) {
            if (lname.matches(regex)) {
                valid = true;
            }
        }
        return valid;
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
