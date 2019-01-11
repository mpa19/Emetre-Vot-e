/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.Party;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Marc
 */
public class VoteCounter {
   
    private int tot = 0;
    private int votsNull = 0;
    private int votsBlank = 0;
    private Set<Party> validParties;
    private int[] votsPartys;
    
    public VoteCounter(Set<Party> validParties) throws Exception {
        this.validParties = validParties;
        votsPartys = new int[validParties.size()];
        Arrays.fill(votsPartys, 0);
    }
    

    public void countParty(Party party) throws Exception {
        partyValid(party);
        votsPartys[encontrarParty(party)]++;
        tot++;
    }          
        
    public void countNull() { 
        votsNull++;
        tot++;
    } 
    public void countBlank() {
        votsBlank++;
        tot++;
    } 
    public void scrutinize(Party party) throws Exception { 
        partyValid(party);
        //  ¿?¿?
        
    }
    public int getVotesFor(Party party) throws Exception { 
        partyValid(party);
        return votsPartys[encontrarParty(party)];
    }
    public int getNulls() { 
        return votsNull; 
    }
    public int getBlanks() { 
        return votsBlank; 
    }
    public int getTotal() {
        return tot; 
    }
    
    public boolean partyValid(Party party) throws Exception{
        if(this.validParties.contains(party)){
            return true;
        }
        throw new Exception("Party no valid");
    }
    
    public int encontrarParty(Party party){
        Iterator i = validParties.iterator();
        int position = 0;
        while(i.hasNext()){
            if(i.next().equals(party)){
                return position;
            }
            position++;
        }
        return position;
    }
}
