/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitiesTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.activateableTriggers.Trigger;
import xmp.objects.ActivateableObject;
import xmp.utilities.ObjectTriggerer;

/**
 *
 * @author Uskon
 */
public class ObjectTriggererTest {

    private ObjectTriggerer ot;
    private Trigger t;
    private ActivateableObject ao;

    public ObjectTriggererTest() {
    }

    @Before
    public void setUp() {
        ao = new ActivateableObject(10, 10, 10, 10);
        t = new Trigger();
        ot = new ObjectTriggerer();
        ao.setTrigger(t);
    }

    @Test
    public void checkStatusReturnsCorrectValueWhenFalse() {
        assertFalse(ot.checkStatus(ao));
    }

    @Test
    public void checkStatusReturnsCorrectValueWhenTrue() {
        t.forceActivate();
        assertTrue(ot.checkStatus(ao));
    }
    
    @Test
    public void triggerObjectChangesTriggerActivationStatus() {
        ot.triggerObject(ao);
        assertTrue(t.checkStatus());
    }
}
