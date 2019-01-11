/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import data.NIF;
import data.DigitalSignature;
import data.Party;
/**
 *
 * @author Marc
 */
public interface ElectoralOrganism {
    boolean canVote(NIF nif);
    void disableVoter(NIF nif);
    DigitalSignature askForDigitalSignature(Party party);
}
