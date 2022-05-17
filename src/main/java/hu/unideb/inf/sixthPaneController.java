package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class sixthPaneController {
    @FXML
    private Button nextButton;

    @FXML
    void pushedNext(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FirstPane.fxml"));
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
    }

    public void textHandler() {
        //try-with-resources
        try (GuestDAO aDAO = new JpaGuestDAO();) {
            List<Guest> list = new ArrayList<>();
            list = aDAO.getGuest();

            for (int i = 0; i < list.size(); i++) {
                aDAO.deleteGuest(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (ExtraDAO aDAO = new JpaExtraDAO();) {
            List<Extra> list = new ArrayList<>();
            list = aDAO.getExtra();

            for (int i = 0; i < list.size(); i++) {
                aDAO.deleteExtra(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (CheckInAndCheckOutDAO aDAO = new JpaCheckInAndCheckOutDAO();) {
            List<CheckInAndCheckOut> list = new ArrayList<>();
            list = aDAO.getCheckInAndCheckOut();

            for (int i = 0; i < list.size(); i++) {
                aDAO.deleteCheckInAndCheckOut(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
