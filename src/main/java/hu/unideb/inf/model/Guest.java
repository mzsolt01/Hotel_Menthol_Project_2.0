package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Guest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lastName;
    private String firstName;
    private String szemIgSzam;
    private String tel;
    private String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSzemIgSzam() {
        return szemIgSzam;
    }

    public void setSzemIgSzam(String szemIgSzam) {
        this.szemIgSzam = szemIgSzam;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
