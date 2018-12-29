/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import Service.Cens;
import Service.ElectoralOrganism;
import data.NIF;
import data.Party;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author Marc
 */
public class VotingKioskTest {
    
    public VotingKioskTest() {
    }
    
    @Test
    public void Test1() throws Exception{
        Party party1 = new Party("a");
        Party party2 = new Party("b");
        Party party3 = new Party("c");
        
        Set<Party> partys = new HashSet<Party>();
        NIF nif1 = new NIF("1");
        NIF nif2 = new NIF("2");
        NIF nif3 = new NIF("3");
        NIF nif4 = new NIF("4");
        
        ArrayList<NIF> cens = new ArrayList<>();
        cens.add(nif1);
        cens.add(nif2);
        cens.add(nif3);
        cens.add(nif4);
        
        partys.add(party1);
        partys.add(party2);
        partys.add(party3);
        
        VoteCounter vc = new VoteCounter(partys);
        Cens eO = new Cens(cens);
        
        VotingKiosk vk = new VotingKiosk();
        vk.setVoteCounter(vc);
        vk.setElectoralOrganism(eO);
        vk.setNIF(nif4);
        vk.vote(party3);
        
        vk.setNIF(nif3);
        vk.vote(party3);          
    }
    
    @Test //votar dos veces error!
    public void Test2() throws Exception{
        Party party1 = new Party("a");
        Party party2 = new Party("b");
        Party party3 = new Party("c");
        
        Set<Party> partys = new HashSet<Party>();
        NIF nif1 = new NIF("1");
        NIF nif2 = new NIF("2");
        NIF nif3 = new NIF("3");
        NIF nif4 = new NIF("4");
        
        ArrayList<NIF> cens = new ArrayList<>();
        cens.add(nif1);
        cens.add(nif2);
        cens.add(nif3);
        cens.add(nif4);
        
        partys.add(party1);
        partys.add(party2);
        partys.add(party3);
        
        VoteCounter vc = new VoteCounter(partys);
        Cens eO = new Cens(cens);
        
        VotingKiosk vk = new VotingKiosk();
        vk.setVoteCounter(vc);
        vk.setElectoralOrganism(eO);
        vk.setNIF(nif4);
        vk.vote(party3);
        vk.vote(party2);
        
        vk.setNIF(nif3);
        vk.vote(party3);          
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
