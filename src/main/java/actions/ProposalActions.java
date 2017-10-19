package main.java.actions;

import com.opensymphony.xwork2.ActionContext;
import main.java.beans.Proposal;
import main.java.services.ProposalService;

import java.util.List;

/**
 * Created by Romain on 19/10/2017.
 */
public class ProposalActions extends Action {
    public List<Proposal> onGoingProposals;

    public Proposal proposal;

    public List<Proposal> getOnGoingProposals() {
        return onGoingProposals;
    }

    public void setOnGoingProposals(List<Proposal> onGoingProposals) {
        this.onGoingProposals = onGoingProposals;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public String displayProposals() {
        ProposalService proposalService = new ProposalService();
        setOnGoingProposals(proposalService.getOnGoingProposals());

        return SUCCESS;
    }

    public String displayProposal() {
        ProposalService proposalService = new ProposalService();
        setProposal(proposalService.getById(getParamValue("id")));

        return SUCCESS;
    }
}
