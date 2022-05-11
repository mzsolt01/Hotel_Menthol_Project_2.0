package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CheckInAndCheckOut implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String CheckIn;
    private String CheckOut;

    public String getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(String checkIn) {
        CheckIn = checkIn;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(String checkOut) {
        CheckOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
