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
public class MailAdressTest {
    
    public MailAdressTest() {
    }
    
    @Test
    public void Test2() throws Exception{
        MailAdress mail1 = new MailAdress("marcperezarnaiz@gmail.com");
        System.out.println(mail1.getMail());
     
    }
    
    @Test (expected = Exception.class)
    public void Test1() throws Exception{
        MailAdress mail1 = new MailAdress(null);
    }
    
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
