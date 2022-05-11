package hu.unideb.inf.model;

import java.util.List;

public interface CheckInAndCheckOutDAO extends AutoCloseable{
    public void saveCheckInAndCheckOut(CheckInAndCheckOut a); //C
    public void deleteCheckInAndCheckOut(CheckInAndCheckOut a); //D
    public void updateCheckInAndCheckOut(CheckInAndCheckOut a); //U
    public List<CheckInAndCheckOut> getCheckInAndCheckOut(); //R
}
