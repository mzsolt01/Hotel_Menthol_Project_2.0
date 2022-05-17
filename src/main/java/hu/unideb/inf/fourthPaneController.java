package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fourthPaneController {
    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox Takaritas;

    @FXML
    private CheckBox Minibar;

    @FXML
    private CheckBox Szef;

    @FXML
    private CheckBox Szobaszerviz;

    @FXML
    private CheckBox Reggeli;

    @FXML
    private CheckBox Ebed;

    @FXML
    private CheckBox Vacsora;

    @FXML
    void pushedNext(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/5th_pane.fxml"));
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
        CheckBoxHandler();
        nextPageSum();
        nextPaneLabelSetter();
    }

    @FXML
    void pushedBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/3rd_pane.fxml"));
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

    public void CheckBoxHandler() {
        //try-with-resources
        try (ExtraDAO aDAO = new JpaExtraDAO();) {
            Extra extra = new Extra();

            extra.setMinibar(Minibar.isSelected());
            extra.setTakaritas(Takaritas.isSelected());
            extra.setSzef(Szef.isSelected());
            extra.setSzobaszerviz(Szobaszerviz.isSelected());
            extra.setEbed(Ebed.isSelected());
            extra.setReggeli(Reggeli.isSelected());
            extra.setVacsora(Vacsora.isSelected());

            aDAO.saveExtra(extra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void nextPageSum() {
        try (ExtraDAO aDAO = new JpaExtraDAO();) {
            List<Extra> extras = new ArrayList<>();
            extras = aDAO.getExtra();
            String text = "";

            for (int i = 0; i < extras.size(); i++) {
                if(extras.get(i).getMinibar()) {
                    String minibar = "Minibar   10.000Ft\n";
                    text += minibar;
                }
                if(extras.get(i).getTakaritas()) {
                    String takaritas = "Takarítás   1500Ft\n";
                    text += takaritas;
                }
                if(extras.get(i).getSzef()) {
                    String szef = "Széf   4000Ft\n";
                    text += szef;
                }
                if(extras.get(i).getSzobaszerviz()) {
                    String szobaszerviz = "Szobaszervíz   1000Ft\n";
                    text += szobaszerviz;
                }
                if(extras.get(i).getReggeli()) {
                    String reggeli = "Reggeli   1500Ft\n";
                    text += reggeli;
                }
                if(extras.get(i).getEbed()) {
                    String ebed = "Ebéd   2500Ft\n";
                    text += ebed;
                }
                if(extras.get(i).getVacsora()) {
                    String vacsora = "Vacsora   2500Ft\n";
                    text += vacsora;
                }
            }

            fifthPaneController.MytextAreaStatic.setText(text);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void nextPaneLabelSetter() {
        try (CheckInAndCheckOutDAO aDAO = new JpaCheckInAndCheckOutDAO();) {
            List<CheckInAndCheckOut> datas = new ArrayList<>();
            datas = aDAO.getCheckInAndCheckOut();

            String checkInTEXT = datas.get(0).getCheckIn();
            String checkOutTEXT = datas.get(0).getCheckOut();

            fifthPaneController.CheckInLabelStatic.setText(checkInTEXT);
            fifthPaneController.CheckOutLabelStatic.setText(checkOutTEXT);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
