/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.Party;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;


/**
 *
 * @author Marc
 */
public class VoteCounterTest {
    
    public VoteCounterTest() {
    }
    
   @Test
    public void Test1() throws Exception{
        Party party1 = new Party("a");
        Party party2 = new Party("b");
        Party party3 = new Party("c");
        
        Set<Party> partys = new HashSet<Party>();
        
        
        partys.add(party1);
        partys.add(party2);
        partys.add(party3);
        
        VoteCounter vc = new VoteCounter(partys);
        vc.countParty(party1);
        System.out.println(vc.getVotesFor(party1));
        System.out.println(vc.getVotesFor(party2));
        vc.countBlank();
        System.out.println(vc.getTotal());


        

        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
