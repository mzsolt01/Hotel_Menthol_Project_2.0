package hu.unideb.inf.model;

import java.util.List;

public interface RoomDAO extends AutoCloseable{
    public void saveRoom(Room a); //C
    public void deleteRoom(Room a); //D
    public void updateRoom(Room a); //U
    public List<Room> getRoom(); //R
}
