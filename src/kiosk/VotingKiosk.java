/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import Service.Biometric;
import Service.ElectoralOrganism;
import Service.MailerService;
import data.Party;
import data.MailAdress;
import data.NIF;

/**
 *
 * @author Marc
 */
public class VotingKiosk {
    VoteCounter vc;
    ElectoralOrganism eO;
    MailerService mService;
    NIF nif;
    boolean email = false;
    Party party;
    Biometric bS;

    
    public VotingKiosk() {
        eO = null;
        mService = null;
        vc = null;
        party = null;
        bS = null;
    }
    public void setElectoralOrganism(ElectoralOrganism eO) {
        this.eO = eO;
    }
    public void setMailerService(MailerService mService){
        this.mService = mService;
    }
       
    public void setVoteCounter(VoteCounter vc){
        this.vc = vc;
    }
        
    public void setBiometricSystem(Biometric bs){
        this.bS = bs;
    }
    
    private void vote(Party party) throws Exception {
        vc.countParty(party);
        this.party = party;
    }
    private void sendeReceipt(MailAdress address) {
        mService.send(address, eO.askForDigitalSignature(party));
    }
    
    public void votingProcess(Party party, NIF nif, MailAdress mail, boolean auto) throws Exception{
        if(auto){
            if(!bS.verifyBiometricData(bS.scanFace(), bS.scanFingerprint(), bS.readBiometricData())) {
                throw new Exception("BiometricVerificationFailedException");
            }
        }
        if(eO.canVote(nif)) vote(party);
        else throw new Exception("VotingRightsFailedException");
        eO.disableVoter(nif);
        if(mail != null) {
            sendeReceipt(mail);
        }
    }
}

