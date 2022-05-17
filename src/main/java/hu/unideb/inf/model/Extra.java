package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Extra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Boolean Takaritas;
    private Boolean Szef;
    private Boolean Minibar;
    private Boolean Szobaszerviz;
    private Boolean Reggeli;
    private Boolean Ebed;
    private Boolean Vacsora;

    public Boolean getTakaritas() {
        return Takaritas;
    }

    public void setTakaritas(Boolean takaritas) {
        Takaritas = takaritas;
    }

    public Boolean getSzef() {
        return Szef;
    }

    public void setSzef(Boolean szef) {
        Szef = szef;
    }

    public Boolean getMinibar() {
        return Minibar;
    }

    public void setMinibar(Boolean minibar) {
        Minibar = minibar;
    }

    public Boolean getSzobaszerviz() {
        return Szobaszerviz;
    }

    public void setSzobaszerviz(Boolean szobaszerviz) {
        Szobaszerviz = szobaszerviz;
    }

    public Boolean getReggeli() {
        return Reggeli;
    }

    public void setReggeli(Boolean reggeli) {
        Reggeli = reggeli;
    }

    public Boolean getEbed() {
        return Ebed;
    }

    public void setEbed(Boolean ebed) {
        Ebed = ebed;
    }

    public Boolean getVacsora() {
        return Vacsora;
    }

    public void setVacsora(Boolean vacsora) {
        Vacsora = vacsora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}