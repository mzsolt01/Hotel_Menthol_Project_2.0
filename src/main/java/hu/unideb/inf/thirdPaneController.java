package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class thirdPaneController implements Initializable {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    private DatePicker checkIN;

    @FXML
    private DatePicker checkOUT;

    @FXML
    private ChoiceBox<String> roomTypeBox;

    private String[] roomTypes = {"Normál lakosztály", "Prémium lakosztály", "Nászutas lakosztály"};

    @FXML
    void getDateIN(ActionEvent event) throws IOException {
        checkInDate = checkIN.getValue();
    }

    @FXML
    void getDateOUT(ActionEvent event) throws IOException {
        checkOutDate = checkOUT.getValue();
    }

    @FXML
    void pushedNext(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/4th_pane.fxml"));
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
        datePickerHandler();
    }

    @FXML
    void pushedBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/2nd_pane.fxml"));
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

    public void datePickerHandler() {
        //try-with-resources
        try (CheckInAndCheckOutDAO aDAO = new JpaCheckInAndCheckOutDAO();) {
            CheckInAndCheckOut data = new CheckInAndCheckOut();
            data.setCheckIn(checkInDate.toString());
            data.setCheckOut(checkOutDate.toString());
            data.setSzoba(roomTypeBox.getValue());

            aDAO.saveCheckInAndCheckOut(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomTypeBox.getItems().addAll(roomTypes);
    }
}
