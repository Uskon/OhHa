/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package activateableTriggersTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.activateableTriggers.Trigger;

/**
 *
 * @author Uskon
 */
public class TriggerTest {
    
    private Trigger trigger;
    
    public TriggerTest() {
    }
    
    @Before
    public void setUp() {
        trigger = new Trigger();
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
}
