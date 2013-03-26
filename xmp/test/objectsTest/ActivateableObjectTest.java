/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objectsTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.objects.ActivateableObject;

/**
 *
 * @author Uskon
 */
public class ActivateableObjectTest {

    private ActivateableObject ao;

    public ActivateableObjectTest() {
    }

    @Before
    public void setUp() {
        ao = new ActivateableObject(0, 0, 1, 1);
    }

    @Test
    public void template() {
    }
}
