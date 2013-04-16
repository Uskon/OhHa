/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitiesTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import xmp.utilities.Location;

/**
 *
 * @author Uskon
 */
public class LocationTest {
    private Location l1 = new Location(10,5);
    private Location l2 = new Location(10,5);
    
    public LocationTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void equalsMethodReturnsTrueForLocationsWithIdenticalCoordinates() {
        assertTrue(l1.equals(l2));
    }
}
