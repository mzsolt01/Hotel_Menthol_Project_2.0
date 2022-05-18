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
    String szallasAr = "";
    int rawSzallasAr = 0;

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
        nextPaneLabelSetter();
        nextPageSum();
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
        CheckInAndCheckOutDelet();
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

    public void nextPageSum() {
        try (ExtraDAO aDAO = new JpaExtraDAO();) {
            List<Extra> extras = new ArrayList<>();
            extras = aDAO.getExtra();
            String text = "";
            int Sum = 0;

            for (int i = 0; i < extras.size(); i++) {
                if(extras.get(i).getMinibar()) {
                    String minibar = "Minibar   10000Ft/teljes feltöltése(korlátlan fogy.)\n";
                    Sum += 10000;
                    text += minibar;
                }
                if(extras.get(i).getTakaritas()) {
                    String takaritas = "Takarítás   1500Ft/nap\n";
                    Sum += 1500;
                    text += takaritas;
                }
                if(extras.get(i).getSzef()) {
                    String szef = "Széf   4000Ft\n";
                    Sum += 4000;
                    text += szef;
                }
                if(extras.get(i).getSzobaszerviz()) {
                    String szobaszerviz = "Szobaszervíz   1000Ft/alkalom\n";
                    Sum += 1000;
                    text += szobaszerviz;
                }
                if(extras.get(i).getReggeli()) {
                    String reggeli = "Reggeli   1500Ft/nap\n";
                    Sum += 1500;
                    text += reggeli;
                }
                if(extras.get(i).getEbed()) {
                    String ebed = "Ebéd   2500Ft/nap\n";
                    Sum += 2500;
                    text += ebed;
                }
                if(extras.get(i).getVacsora()) {
                    String vacsora = "Vacsora   2500Ft/nap\n";
                    Sum += 2500;
                    text += vacsora;
                }
            }

            Sum += rawSzallasAr;
            String s = Integer.toString(Sum);
            text += szallasAr + "Összesen: " + s + "Ft\n";

            fifthPaneController.MytextAreaStatic.setText(text);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nextPaneLabelSetter() {
        int checkInDate = 0;
        int checkOutDate = 0;
        int normal = 20000;
        int premium = 39000;
        int naszutas = 50000;

        try (CheckInAndCheckOutDAO aDAO = new JpaCheckInAndCheckOutDAO();) {
            List<CheckInAndCheckOut> datas = new ArrayList<>();
            datas = aDAO.getCheckInAndCheckOut();

            String roomType = datas.get(0).getSzoba();
            String checkInTEXT = datas.get(0).getCheckIn();
            String checkOutTEXT = datas.get(0).getCheckOut();

            fifthPaneController.CheckInLabelStatic.setText(checkInTEXT);
            fifthPaneController.CheckOutLabelStatic.setText(checkOutTEXT);

            if(roomType.contains("Normál")) {

                checkInTEXT = checkInTEXT.replace("-","");
                checkOutTEXT = checkOutTEXT.replace("-","");
                checkInDate = Integer.parseInt(checkInTEXT);
                checkOutDate = Integer.parseInt(checkOutTEXT);

                rawSzallasAr = normal*(checkOutDate - checkInDate);
                szallasAr = "Normál lakosztály: " + Integer.toString(rawSzallasAr) + "Ft\n";
            } else if(roomType.contains("Prémium")) {

                checkInTEXT = checkInTEXT.replace("-","");
                checkOutTEXT = checkOutTEXT.replace("-","");
                checkInDate = Integer.parseInt(checkInTEXT);
                checkOutDate = Integer.parseInt(checkOutTEXT);

                rawSzallasAr = premium*(checkOutDate - checkInDate);
                szallasAr = "Prémium lakosztály: " + Integer.toString(rawSzallasAr) + "Ft\n";
            } else if(roomType.contains("Nászutas")) {

                checkInTEXT = checkInTEXT.replace("-","");
                checkOutTEXT = checkOutTEXT.replace("-","");
                checkInDate = Integer.parseInt(checkInTEXT);
                checkOutDate = Integer.parseInt(checkOutTEXT);

                rawSzallasAr = naszutas*(checkOutDate - checkInDate);
                szallasAr = "Nászutas lakosztály: " + Integer.toString(rawSzallasAr) + "Ft\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CheckInAndCheckOutDelet() {
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
