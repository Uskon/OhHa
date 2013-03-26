/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objectsTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.activateableTriggers.Trigger;
import xmp.objects.ActivateableObject;

/**
 *
 * @author Uskon
 */
public class ActivateableObjectTest {

    private ActivateableObject ao;
    private Trigger t;

    public ActivateableObjectTest() {
    }

    @Before
    public void setUp() {
        ao = new ActivateableObject(0, 0, 1, 1);
        t = new Trigger();
    }

    @Test
    public void triggerCanBeActivatedIfSet() {
        ao.setTrigger(t);
        ao.triggerObject();
        assertTrue(ao.getTrigger().checkStatus());
    }
    
    @Test
    public void nothingHappensIfTriggerIsNotSet() {
        try {
            ao.activateObject();
        } catch (Exception e) {
            fail("An error occurred while trying to activate the object");
        }
    }
}
