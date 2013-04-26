/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package activateableTriggersTest;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.activateableTriggers.Trigger;
import xmp.activateableTriggers.TriggerSequence;

/**
 *
 * @author Uskon
 */
public class TriggerSequenceTest {
    
    private TriggerSequence testSeq;
    private TriggerSequence emptySeq;
    private HashMap<Integer, Trigger> triggerList;
    private HashMap<Integer, Trigger> testList;
    private Trigger trigger;
    private Trigger trigger2;
    
    public TriggerSequenceTest() {
    }
    
    @Before
    public void setUp() {
        testSeq = new TriggerSequence();
        emptySeq = new TriggerSequence();
        trigger = new Trigger();
        trigger2 = new Trigger();
        triggerList = new HashMap<>();
        testList = new HashMap<>();
        
        triggerList.put(1, trigger);
        triggerList.put(2, trigger2);
        testSeq.newSequence(triggerList);
        
    }
    
    @Test
    public void checkIfSequenceIsCompletedReturnsCorrectValueWhenTrue() {
        trigger.activateTrigger();
        trigger2.activateTrigger();
        assertTrue(testSeq.checkIfSequenceIsCompleted());
    }

    @Test
    public void checkIfSequenceIsCompletedReturnsCorrectValueWhenFalse() {
        trigger.activateTrigger();
        assertFalse(testSeq.checkIfSequenceIsCompleted());
    }

    @Test
    public void triggerSequenceDeniesIncorrectSequencesWhenTryingToSetNewSequence() {
        testList.put(2, trigger);
        try {
            emptySeq.newSequence(testList);
        } catch (Exception e) {
        }
        assertTrue(emptySeq.getTriggerList() == null);
    }

    @Test
    public void triggerSequenceAcceptsCorrectlyFormedSequences() {
        try {
            emptySeq.newSequence(triggerList);
        } catch (Exception e) {
        }
        assertTrue(emptySeq.getTriggerList().equals(triggerList));
    }

    @Test
    public void triggersResetWhenActivatedInWrongOrder() {
        trigger2.activateTrigger();
        testSeq.activateInCorrectOrder(trigger2);
        assertTrue(trigger.checkStatus() == false && trigger2.checkStatus() == false);

    }

    @Test
    public void triggersActivateWhenUsedInCorrectOrder() {
        testSeq.activateInCorrectOrder(trigger);
        testSeq.activateInCorrectOrder(trigger2);
        assertTrue(testSeq.checkIfSequenceIsCompleted());
    }
}
