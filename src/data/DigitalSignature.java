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
final public class DigitalSignature {
    private final byte[] signature;

    public DigitalSignature(byte[] signature) throws Exception { 
        if(signature == null){
           throw new Exception("DigitalSignature error");
        } 
        this.signature = signature; }
    public byte[] getSignature() { return signature;}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature signature1 = (DigitalSignature) o;
        return signature.equals(signature1.signature);
    }
 
    @Override
    public int hashCode() { return signature.hashCode(); }
 
    @Override
    public String toString() {
       return "DigitalSignature='" + signature.toString() + '\'' + '}';
    } 
}
