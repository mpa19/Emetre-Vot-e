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
public class DigitalSignatureTest {
    
    public DigitalSignatureTest() {
    }
    
    @Test
    public void Test1() throws Exception{
        DigitalSignature digital1 = new DigitalSignature(null);
        digital1.getSignature();
    }
    
    @Test
    public void Test2() throws Exception{
        byte[] a = {(byte)0x03, (byte)0x00, (byte)0x00, (byte)0x00};
        DigitalSignature digital1 = new DigitalSignature(a);
        System.out.println(digital1.getSignature());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
