package main.java.beans;

/**
 * Created by pierre on 18/10/2017.
 */

public class Proposal {
    private String id;
    private VoteType type;
    private String libelle;
    private Choice[] choices;
    private ProposalState state;
    private Choice choiceWin;
    private enum VoteType {
        REFERENDUM,
        ELECTION,
        OTHER
    }
    private enum ProposalState {
        ONGOING,
        ENDED
    }

    public Proposal(String id, VoteType type, String libelle, Choice[] choices, ProposalState state, Choice choiceWin) {
        this.id = id;
        this.type = type;
        this.libelle = libelle;
        this.choices = choices;
        this.state = state;
        this.choiceWin = choiceWin;
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

    public Choice[] getChoices() {
        return choices;
    }

    public void setChoices(Choice[] choices) {
        this.choices = choices;
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
}
