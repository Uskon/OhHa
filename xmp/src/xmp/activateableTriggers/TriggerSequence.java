package xmp.activateableTriggers;

import java.util.ArrayList;
import java.util.HashMap;

public class TriggerSequence {

    private HashMap<Integer, Trigger> triggerList;

    public TriggerSequence() {
        triggerList = null;
    }

    public void newSequence(HashMap<Integer, Trigger> newList) {

        for (int k = 1; k <= newList.size(); k++) {
            if (!newList.containsKey(k)) {
                throw new IllegalArgumentException("For n entries the key values must include every number from 1 to n");
            }
        }
        triggerList = newList;
    }

    public void activateInCorrectOrder(Trigger trigger) {
        for (int k = 1; k <= triggerList.size(); k++) {
            if (triggerList.get(k).equals(trigger)) {
                trigger.activateTrigger();
                break;
            } else {
                if (triggerList.get(k).checkStatus() == false) {
                    deactivateAllTriggers();
                    break;
                }
            }
        }
    }
    
    public boolean checkIfSequenceIsCompleted() {
        for (int k = 1; k <= triggerList.size(); k++) {
            if (triggerList.get(k).checkStatus() == false) {
                return false;
            }
        }   return true;
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

    public HashMap<Integer, Trigger> getList() {
        return this.triggerList;
    }
}
