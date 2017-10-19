package main.java.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by pierre on 18/10/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Proposal {
    private String id;
    private VoteType type;
    private String libelle;
    private String[] choices;
    private List<Choice> choiceItems;
    private ProposalState state;
    private Choice choiceWin;
    private Integer totalVotes;
    private enum VoteType {
        REFERENDUM,
        ELECTION,
        OTHER
    }
    private enum ProposalState {
        ONGOING,
        ENDED
    }

    public Proposal(String id, VoteType type, String libelle, String[] choices, ProposalState state, Choice choiceWin) {
        this.id = id;
        this.type = type;
        this.libelle = libelle;
        this.choices = choices;
        this.state = state;
        this.choiceWin = choiceWin;
    }

    public Proposal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VoteType getType() {
        return type;
    }

    public void setType(VoteType type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public List<Choice> getChoiceItems() {
        return choiceItems;
    }

    public void setChoiceItems(List<Choice> choiceItems) {
        this.choiceItems = choiceItems;
    }

    public ProposalState getState() {
        return state;
    }

    public void setState(ProposalState state) {
        this.state = state;
    }

    public Choice getChoiceWin() {
        return choiceWin;
    }

    public void setChoiceWin(Choice choiceWin) {
        this.choiceWin = choiceWin;
    }

    public Boolean isOnGoing() {
        return getState().equals(ProposalState.ONGOING);
    }

    public Boolean isEnded() {
        return getState().equals(ProposalState.ENDED);
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Integer totalVotes) {
        this.totalVotes = totalVotes;
    }
}
