package main.java.beans;

/**
 * Created by pierre on 18/10/2017.
 */

public class Choice {
    private String id;
    private String libelle;

    public Choice(String id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
