package hu.unideb.inf.model;

import java.util.List;

public interface GuestDAO extends AutoCloseable{
    //CRUD methods
    public void saveGuest(Guest a); //C
    public void deleteGuest(Guest a); //D
    public void updateGuest(Guest a); //U
    public List<Guest> getGuest(); //R
}
