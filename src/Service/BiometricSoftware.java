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
public interface BiometricSoftware {
    public boolean verifyBiometricData(long face, long empremta, BiometricData pasport) throws Exception;
}
