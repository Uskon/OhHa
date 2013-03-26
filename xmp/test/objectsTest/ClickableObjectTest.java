/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objectsTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.objects.ActivateableObject;
import xmp.objects.ClickableObject;
import xmp.objects.MoveableObject;

/**
 *
 * @author Uskon
 */
public class ClickableObjectTest {

    private ClickableObject co;

    public ClickableObjectTest() {
    }

    @Before
    public void setUp() {
        co = new MoveableObject(0, 0, 1, 1);
    }

    @Test
    public void objectCoordinateXGetterIsWorking() {
        co.setX(5);
        assertTrue(co.getX() == 5);
    }

    @Test
    public void objectCoordinateYGetterIsWorking() {
        co.setY(5);
        assertTrue(co.getY() == 5);
    }

    @Test
    public void objectWidthGetterIsWorking() {
        co.setW(5);
        assertTrue(co.getW() == 5);
    }

    @Test
    public void objectHeightGetterIsWorking() {
        co.setH(5);
        assertTrue(co.getH() == 5);
    }

    @Test
    public void objectCoordinateXCannotBeSetNegative() {
        try {
            co.setX(-5);
        } catch (Exception e) {
        }
        assertTrue(co.getX() == 0);
    }

    @Test
    public void objectCoordinateYCannotBeSetNegative() {
        try {
            co.setY(-5);
        } catch (Exception e) {
        }
        assertTrue(co.getY() == 0);
    }

    @Test
    public void objectWidthCannotBeSetNegative() {
        try {
            co.setW(-1);
        } catch (Exception e) {
        }
        assertTrue(co.getW() == 1);
    }

    @Test
    public void objectWidthCannotBeSetZero() {
        try {
            co.setW(0);
        } catch (Exception e) {
        }
        assertTrue(co.getW() == 1);
    }

    @Test
    public void objectHeightCannotBeSetNegative() {
        try {
            co.setH(-1);
        } catch (Exception e) {
        }
        assertTrue(co.getH() == 1);
    }

    @Test
    public void objectHeightCannotBeSetZero() {
        try {
            co.setH(0);
        } catch (Exception e) {
        }
        assertTrue(co.getH() == 1);
    }
}
