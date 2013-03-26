/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objectsTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.objects.MoveableObject;

/**
 *
 * @author Uskon
 */
public class MoveableObjectTest {

    private MoveableObject mo;

    public MoveableObjectTest() {
    }

    @Before
    public void setUp() {
        mo = new MoveableObject(0, 0, 1, 1);
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
}
