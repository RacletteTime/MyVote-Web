package main.java.actions;

import main.java.beans.Proposal;
import main.java.services.ProposalService;

import java.util.List;

/**
 * Created by Romain on 19/10/2017.
 */
public class ProposalActions extends Action {
    public List<Proposal> onGoingProposals;

    public List<Proposal> getOnGoingProposals() {
        return onGoingProposals;
    }

    public void setOnGoingProposals(List<Proposal> onGoingProposals) {
        this.onGoingProposals = onGoingProposals;
    }

    public String displayProposals() {
        ProposalService proposalService = new ProposalService();
        setOnGoingProposals(proposalService.getOnGoingProposals());

        return SUCCESS;
    }
}
