package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/firstPane.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Hotel Menthol");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws SQLException {
        startDatabase();
        launch(args);

        try (RoomDAO aDAO = new JpaRoomDAO();) {
            Room room1 = new Room();
            Room room2 = new Room();
            Room room3 = new Room();
            Room room4 = new Room();
            Room room5 = new Room();
            Room room6 = new Room();
            Room room7 = new Room();
            Room room8 = new Room();

            List<Room> RoomList = new ArrayList<>(aDAO.getRoom());
            int roomListSize = RoomList.size();

            if(roomListSize != 8) {
                room1.setId(1);
                room1.setType("Normal");
                aDAO.saveRoom(room1);
                room2.setId(2);
                room2.setType("Normal");
                aDAO.saveRoom(room2);
                room3.setId(3);
                room3.setType("Normal");
                aDAO.saveRoom(room3);
                room4.setId(4);
                room4.setType("Normal");
                aDAO.saveRoom(room4);
                room5.setId(5);
                room5.setType("Premium");
                aDAO.saveRoom(room5);
                room6.setId(6);
                room6.setType("Premium");
                aDAO.saveRoom(room6);
                room7.setId(7);
                room7.setType("Naszutas");
                aDAO.saveRoom(room7);
                room8.setId(8);
                room8.setType("Naszutas");
                aDAO.saveRoom(room8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
