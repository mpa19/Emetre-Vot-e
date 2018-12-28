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
public class NIFTest {
    
    public NIFTest() {
    }
    
    @Test
    public void Test2() throws Exception{
        NIF nif1 = new NIF("12345678T");
        System.out.println(nif1.getNIF());
     
    }
    
    @Test
    public void Test1() throws Exception{
        NIF nif1 = new NIF(null);
    }
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
