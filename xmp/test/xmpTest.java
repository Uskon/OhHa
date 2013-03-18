/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.activateableTriggers.Trigger;
import xmp.activateableTriggers.TriggerSequence;
import xmp.objects.ActivateableObject;
import xmp.objects.ClickableObject;
import xmp.objects.MoveableObject;
import xmp.objects.SwappableObject;
import xmp.utilities.ObjectPlaceSwapper;

/**
 *
 * @author Uskon
 */
public class xmpTest {

    private MoveableObject mo;
    private SwappableObject so;
    private ActivateableObject ao;
    private ObjectPlaceSwapper ops = new ObjectPlaceSwapper();
    private Trigger trigger;
    private Trigger trigger2;
    private TriggerSequence emptySeq;
    private TriggerSequence testSeq;
    private HashMap<Integer, Trigger> testList;
    private HashMap<Integer, Trigger> triggerList;

    public xmpTest() {
    }

    @Before
    public void setUp() {
        mo = new MoveableObject(0, 0);
        so = new SwappableObject(0, 0);
        ao = new ActivateableObject(0, 0);
        trigger = new Trigger();
        trigger2 = new Trigger();
        testList = new HashMap<>();
        triggerList = new HashMap<>();
        emptySeq = new TriggerSequence();
        testSeq = new TriggerSequence();

        triggerList.put(1, trigger);
        triggerList.put(2, trigger2);

        testSeq.newSequence(triggerList);
    }

    @Test
    public void objectCoordinateXGetterIsWorking() {
        mo.moveObject(5, 0);
        assertTrue(mo.getX() == 5);
    }

    @Test
    public void objectCoordinateYGetterIsWorking() {
        mo.moveObject(0, 5);
        assertTrue(mo.getY() == 5);
    }

    @Test
    public void moveableObjectCanBeMoved() {
        mo.moveObject(2, 3);
        assertTrue(mo.getX() == 2 && mo.getY() == 3);
    }

    @Test
    public void moveableObjectCannotBeMovedToNegativeCoordinates() {
        try {
            mo.moveObject(-1, -6);
        } catch (Exception e) {
        }
        assertTrue(mo.getX() == 0 && mo.getY() == 0);
    }

    @Test
    public void objectsCanBeSwappedCorrectly() {
        SwappableObject swaptest = new SwappableObject(10, 5);
        ops.swapPlaces(so, swaptest);
        assertTrue((so.getX() == 10 && so.getY() == 5) && (swaptest.getX() == 0 && swaptest.getY() == 0));
    }

    @Test
    public void triggerCanBeActivated() {
        trigger.activateTrigger();
        assertTrue(trigger.checkStatus());
    }

    @Test
    public void triggerCanBeDeactivated() {
        trigger.deactivateTrigger();
        assertFalse(trigger.checkStatus());
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
        assertTrue(emptySeq.getList() == null);
    }

    @Test
    public void triggerSequenceAcceptsCorrectSequences() {
        emptySeq.newSequence(triggerList);
        assertTrue(emptySeq.getList().equals(triggerList));
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
