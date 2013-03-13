/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.activateableTriggers;

/**
 *
 * @author Uskon
 */
public class Trigger {
    private boolean isActivated = false;
    
    public void activateTrigger() {
        this.isActivated = true;
    }
    
    public void deactivateTrigger() {
        this.isActivated = false;
    }
    
    public boolean checkStatus() {
        return this.isActivated;
    }
    
}
