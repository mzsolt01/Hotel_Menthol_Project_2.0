package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rooms {

    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String lastName;
}
