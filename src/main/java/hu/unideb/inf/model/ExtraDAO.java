package hu.unideb.inf.model;

import java.util.List;

public interface ExtraDAO extends AutoCloseable{
    public void saveExtra(Extra a); //C
    public void deleteExtra(Extra a); //D
    public void updateExtra(Extra a); //U
    public List<Extra> getExtra(); //R
}
