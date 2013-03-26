/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitiesTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.objects.SwappableObject;
import xmp.utilities.ObjectPlaceSwapper;

/**
 *
 * @author Uskon
 */
public class ObjectPlaceSwapperTest {

    private ObjectPlaceSwapper ops = new ObjectPlaceSwapper();
    private SwappableObject so1;
    private SwappableObject so2;

    public ObjectPlaceSwapperTest() {
    }

    @Before
    public void setUp() {
        so1 = new SwappableObject(0, 0, 1, 1);
        so2 = new SwappableObject(5, 5, 5, 5);
    }

    @Test
    public void objectsCanBeSwappedCorrectly() {
        SwappableObject swaptest = new SwappableObject(10, 5, 1, 1);
        ops.swapPlaces(so1, so2);
        assertTrue((so1.getX() == 5 && so1.getY() == 5) && (so2.getX() == 0 && so2.getY() == 0));
    }
}
