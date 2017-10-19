package main.java.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by pierre on 18/10/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Choice {
    private String id;
    private String libelle;
    private String nbVotes;
    private Integer percentage;

    public Choice(String id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Choice() {
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

    public String getNbVotes() {
        return nbVotes;
    }

    public void setNbVotes(String nbVotes) {
        this.nbVotes = nbVotes;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
