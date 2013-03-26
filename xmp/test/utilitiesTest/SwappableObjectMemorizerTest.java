/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitiesTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xmp.objects.SwappableObject;
import xmp.utilities.SwappableObjectMemorizer;

/**
 *
 * @author Uskon
 */
public class SwappableObjectMemorizerTest {

    private SwappableObjectMemorizer memo;
    private SwappableObject so1;
    private SwappableObject so2;

    public SwappableObjectMemorizerTest() {
    }

    @Before
    public void setUp() {
        memo = new SwappableObjectMemorizer();
        so1 = new SwappableObject(0, 0, 1, 1);
        so2 = new SwappableObject(5, 5, 5, 5);
    }

    @Test
    public void bothMemorizedObjectsAreNullByDefault() {
        assertTrue(memo.getSwappable1() == null && memo.getSwappable2() == null);
    }

    @Test
    public void whenMemorizedObjectsAreNullGivenObjectWillBeSetToSlot1() {
        memo.setSwappable1(so1);
        assertTrue(memo.getSwappable1() == so1);
    }

    @Test
    public void ifGivenObjectEqualsObjectsInSlot1ThenSlot2WillRemainNull() {
        memo.manageSwappables(so1);
        memo.manageSwappables(so1);
        assertTrue(memo.getSwappable2() == null);
    }

    @Test
    public void ifSlot1ContainsObjectAndGivenObjectIsUniqueObjectPlacesWillBeSwapped() {
        memo.manageSwappables(so1);
        memo.manageSwappables(so2);
        assertTrue(so1.getX() == 5 && so1.getY() == 5 && so2.getX() == 0 && so2.getY() == 0);
    }
}
