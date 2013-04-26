package xmp.activateableTriggers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hallitsee triggereitten oikeaa aktivointia.
 */
public class TriggerSequence {
    
    /**
     * Lista triggereistä ja niiden oikeasta järjestyksestä.
     */
    private HashMap<Integer, Trigger> triggerList;

    public TriggerSequence() {
        triggerList = null;
    }

    /**
     * Asettaa uuden listan triggereistä, jos se on oikeaa muotoa.
     * @param newList Uusi triggerjärjestys
     */
    public void newSequence(HashMap<Integer, Trigger> newList) {

        for (int k = 1; k <= newList.size(); k++) {
            if (!newList.containsKey(k)) {
                throw new IllegalArgumentException("For n entries the key values must include every number from 1 to n");
            }
        }
        triggerList = newList;
        for (int k = 1; k <= triggerList.size(); k++) {
            triggerList.get(k).setTSeq(this);
        }
    }

    /**
     * Aktivoi triggerin jos sitä järjestyksessä edeltävät triggerit on aktivoitu, muulloin resettaa kaikkien sisältämiensä triggereitten tilan alkuperäiseen false-arvoon.
     * 
     * @see xmp.activateableTriggers.Trigger#forceActivate()
     * 
     * @param trigger Trigger, jota yritetään aktivoida.
     */
    public void activateInCorrectOrder(Trigger trigger) {
        for (int k = 1; k <= triggerList.size(); k++) {
            if (triggerList.get(k).equals(trigger)) {
                trigger.forceActivate();
                break;
            } else {
                if (triggerList.get(k).checkStatus() == false) {
                    deactivateAllTriggers();
                    break;
                }
            }
        }
    }
    
    /**
     * Tarkistaa onko kaikki Triggerit aktivoitu.
     * @return TriggerSequencen tila
     */
    public boolean checkIfSequenceIsCompleted() {
        for (int k = 1; k <= triggerList.size(); k++) {
            if (triggerList.get(k).checkStatus() == false) {
                return false;
            }
        }   return true;
    }

    /**
     * Resettaa kaikkien sisältyvien triggereitten tilan.
     */
    public void deactivateAllTriggers() {
        for (int k = 1; k <= triggerList.size(); k++) {
            triggerList.get(k).deactivateTrigger();
        }
    }

    public HashMap<Integer, Trigger> getTriggerList() {
        return this.triggerList;
    }
}
