/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import data.BiometricData;

/**
 *
 * @author Marc
 */
public class Biometric implements BiometricReader, BiometricSoftware, BiometricScanner {
    BiometricData a;
    @Override
    public BiometricData readBiometricData() {
        return a;
    }
    
    public void setBiometric(long b) {
        a = new BiometricData(b);
    }
    
    @Override
    public boolean verifyBiometricData(long face, long empremta, BiometricData pasport) {
        String s1 = Long.toString(face);
        String s2 = Long.toString(empremta);
        String s3 = s1 + s2;
        long crea = Long.valueOf(s3).longValue();
        BiometricData scan = new BiometricData(crea);
        if(scan.equals(pasport)){
            return true;
        } else return false;
    }

    @Override
    public long scanFace() {
        return 1;
    }

    @Override
    public long scanFingerprint() {
        return 1;
    }
    
}
