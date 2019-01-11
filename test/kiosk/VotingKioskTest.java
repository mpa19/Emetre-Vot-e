/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import Service.Biometric;
import Service.Serveis;
import data.MailAdress;
import data.NIF;
import data.Party;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Marc
 */
public class VotingKioskTest {
         
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
        Serveis eO = new Serveis(cens);
        
        VotingKiosk vk = new VotingKiosk();
        vk.setVoteCounter(vc);
        vk.setElectoralOrganism(eO);
        vk.setMailerService(eO);
        vk.votingProcess(party3, nif4, null,false);        
        vk.votingProcess(party3, nif3, null,false);  
    }
    
    @Test (expected = Exception.class) /* VoteError intento de votar 2 veces */
    public void Test2() throws Exception{
        Party party1 = new Party("a");
        Party party2 = new Party("b");
        Party party3 = new Party("c");
        
        Set<Party> partys = new HashSet<Party>();
        NIF nif1 = new NIF("1");
        NIF nif2 = new NIF("2");
        NIF nif3 = new NIF("3");
        NIF nif4 = new NIF("4");
        
        MailAdress address = new MailAdress("marcperezarnaiz@gmail.com");
        
        ArrayList<NIF> cens = new ArrayList<>();
        cens.add(nif1);
        cens.add(nif2);
        cens.add(nif3);
        cens.add(nif4);
        
        partys.add(party1);
        partys.add(party2);
        partys.add(party3);
        
        VoteCounter vc = new VoteCounter(partys);
        Serveis eO = new Serveis(cens);
        
        VotingKiosk vk = new VotingKiosk();
        vk.setVoteCounter(vc);
        vk.setElectoralOrganism(eO);
        vk.setMailerService(eO);

        vk.votingProcess(party3, nif4, address, false);        
        vk.votingProcess(party2, nif4, address, false);       
    }
    
    @Test /* Votar con biometric */
    public void Test3() throws Exception{
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
        Serveis eO = new Serveis(cens);
        Biometric a = new Biometric();
        a.setBiometric(11);
        VotingKiosk vk = new VotingKiosk();
        vk.setBiometricSystem(a);
        vk.setVoteCounter(vc);
        vk.setElectoralOrganism(eO);
        vk.setMailerService(eO);
        vk.votingProcess(party3, nif3, null, true);
        System.out.println(vc.getTotal());
    }
    
    @Test (expected = Exception.class)/* Votar con biometric con error de autentificacion */
    public void Test4() throws Exception{
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
        Serveis eO = new Serveis(cens);
        Biometric a = new Biometric();
        a.setBiometric(101);
        VotingKiosk vk = new VotingKiosk();
        vk.setBiometricSystem(a);
        vk.setVoteCounter(vc);
        vk.setElectoralOrganism(eO);
        vk.setMailerService(eO);
        vk.votingProcess(party3, nif3, null, true);
        System.out.println(vc.getTotal());
    }
    
    @Test (expected = Exception.class)/* Votar con NIF pero no esta al cens  */
    public void Test5() throws Exception{
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
        
        
        partys.add(party1);
        partys.add(party2);
        partys.add(party3);
        
        VoteCounter vc = new VoteCounter(partys);
        Serveis eO = new Serveis(cens);
        Biometric a = new Biometric();
        a.setBiometric(11);
        VotingKiosk vk = new VotingKiosk();
        vk.setBiometricSystem(a);
        vk.setVoteCounter(vc);
        vk.setElectoralOrganism(eO);
        vk.setMailerService(eO);
        vk.votingProcess(party3, nif4, null, false);
        assertTrue(vk.email);
    }
    
    @Test (expected = Exception.class)/* Votar con biometric con error del NIF no esta al cens */
    public void Test6() throws Exception{
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
        
        partys.add(party1);
        partys.add(party2);
        partys.add(party3);
        
        VoteCounter vc = new VoteCounter(partys);
        Serveis eO = new Serveis(cens);
        Biometric a = new Biometric();
        a.setBiometric(11);
        VotingKiosk vk = new VotingKiosk();
        vk.setBiometricSystem(a);
        vk.setVoteCounter(vc);
        vk.setElectoralOrganism(eO);
        vk.setMailerService(eO);
        vk.votingProcess(party3, nif4, null, true);
    }
}
