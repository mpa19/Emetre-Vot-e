/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Marc
 */
final public class NIF {
    private final String NIF;

    public NIF(String NIF) throws Exception { 
        if(NIF == null){
           throw new Exception("NIF invalid");
        } 
        this.NIF = NIF; }
    public String getNIF() { return NIF; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NIF NIF1 = (NIF) o;
        return NIF.equals(NIF1.NIF);
    }
 
    @Override
    public int hashCode() { return NIF.hashCode(); }
 
    @Override
    public String toString() {
       return "NIF='" + NIF + '\'' + '}';
    } 
}
