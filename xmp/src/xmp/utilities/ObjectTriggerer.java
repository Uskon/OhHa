/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.utilities;

import xmp.activateableTriggers.TriggerSequence;
import xmp.objects.ActivateableObject;

/**
 *  Työkalu ActivateableObjectien triggereitten käyttämiseen ja niiden tilan tarkistamiseen.
 */
public class ObjectTriggerer {

    /**
     * Käyttää annetun ActivateableObjectin triggerObject-metodia
     * 
     * @param ao Triggerattava ActivateableObject
     * 
     * @see xmp.objects.ActivateableObject#activateObject() 
     */
    public void triggerObject(ActivateableObject ao) {
        ao.triggerObject();
    }
    
    
    /**
     * Palauttaa parametrina annetun ActivateableObjectin triggerin tilan.
     * @param ao Tutkittava ActivateableObject
     * @return Triggerin tila boolean-arvona
     */
    public boolean checkStatus(ActivateableObject ao) {
        return ao.getTrigger().checkStatus();
    }
}
