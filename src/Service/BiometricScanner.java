/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Marc
 */
public interface BiometricScanner {
 
    public long scanFace();
    public long scanFingerprint();
}
