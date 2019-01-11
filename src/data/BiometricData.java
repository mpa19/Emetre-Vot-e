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
public class BiometricData {
    private final long Bio;

    public BiometricData(long Bio) { 
        this.Bio = Bio;
    }
    public long getBio() { return Bio; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiometricData Bio1 = (BiometricData) o;
        return Bio == Bio1.Bio;
    }
     @Override
    public String toString() {
       return "BiometricData='" + Bio + '\'' + '}';
    } 
}
