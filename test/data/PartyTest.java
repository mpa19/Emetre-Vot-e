/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.junit.Test;


/**
 *
 * @author Marc
 */
public class PartyTest {
    
    
    public PartyTest() throws Exception {

    }
     
    @Test (expected = Exception.class)
    public void Test1() throws Exception{
        Party party1 = new Party(null);
    }
    
    @Test
    public void Test2() throws Exception{
        Party party1 = new Party("hola");
        System.out.println(party1.getName());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
