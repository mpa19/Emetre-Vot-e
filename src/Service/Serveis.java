/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import data.DigitalSignature;
import data.MailAdress;
import data.NIF;
import data.Party;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc
 */
public class Serveis implements ElectoralOrganism, MailerService {
    
    ArrayList<NIF> cens;
    ArrayList<NIF> votat;
    
    public Serveis(ArrayList<NIF> nifs){
        cens = nifs;
        votat = new ArrayList<>();
    }
    
    @Override
    public boolean canVote(NIF nif) {
        for(int a = 0; a < votat.size(); a++){
            if(nif.equals(votat.get(a))) return false;
        }
        
        for(int i = 0; i<cens.size(); i++){
            if(nif.equals(cens.get(i))) return true;
        }
        return false;
    }

    @Override
    public void disableVoter(NIF nif) {
        votat.add(nif);
    }

    @Override
    public DigitalSignature askForDigitalSignature(Party party) {
        DigitalSignature a = null;
        try {
            a = new DigitalSignature(party.toString().getBytes());
        } catch (Exception ex) {
            Logger.getLogger(Serveis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    @Override
    public void send(MailAdress address, DigitalSignature signature) {
        System.out.println("Email enviado correctamente a: " + address.toString());
    } 
}
