/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.activateableTriggers;

import java.util.HashMap;

/**
 *
 * @author Uskon
 */
public class TriggerSequence {
    private HashMap<Integer, Trigger> triggerList;
    
    public TriggerSequence() {
        triggerList = new HashMap<>();
    }
    
    public void newSequence(HashMap<Integer,Trigger> newList) {
        triggerList = newList;
    }
    
    public void activateInCorrectOrder(Trigger trigger) {
        for (int k = 1; k <= triggerList.size(); k++) {
            if (triggerList.get(k).equals(trigger)) {
                trigger.activateTrigger();
                break;
            }   else {
                if (triggerList.get(k).checkStatus() == false) {
                    deactivateAllTriggers();
                    break;
                }
            }
        }
    }
    
    public void deactivateAllTriggers() {
        for (int k = 1; k <= triggerList.size(); k++) {
            triggerList.get(k).deactivateTrigger();
        }
    }
    
    public void printStatus() {
        for (int k = 1; k <= triggerList.size(); k++) {
            System.out.println(triggerList.get(k).checkStatus());
        }
    }
}
