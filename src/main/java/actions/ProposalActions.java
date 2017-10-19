package main.java.actions;

import com.opensymphony.xwork2.ActionContext;
import main.java.beans.Proposal;
import main.java.services.ProposalService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 19/10/2017.
 */
public class ProposalActions extends Action {
    public List<Proposal> onGoingProposals;

    public List<Proposal> endedProposals;

    public Proposal proposal;

    public List<Proposal> getOnGoingProposals() {
        return onGoingProposals;
    }

    public void setOnGoingProposals(List<Proposal> onGoingProposals) {
        this.onGoingProposals = onGoingProposals;
    }

    public List<Proposal> getEndedProposals() {
        return endedProposals;
    }

    public void setEndedProposals(List<Proposal> endedProposals) {
        this.endedProposals = endedProposals;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public String displayProposals() {
        ProposalService proposalService = new ProposalService();
        onGoingProposals = new ArrayList<>();
        endedProposals = new ArrayList<>();

        for (Proposal proposal : proposalService.getProposals()) {
            if (proposal.isOnGoing()) {
                onGoingProposals.add(proposal);
            }
            else if (proposal.isEnded()) {
                endedProposals.add(proposal);
            }
        }

        return SUCCESS;
    }

    public String displayProposal() {
        ProposalService proposalService = new ProposalService();
        setProposal(proposalService.getById(getParamValue("id")));

        return SUCCESS;
    }
}
