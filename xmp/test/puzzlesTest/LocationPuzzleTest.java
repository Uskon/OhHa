/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesTest;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import xmp.objects.ClickableObject;
import xmp.objects.SwappableObject;
import xmp.puzzles.LocationPuzzle;
import xmp.utilities.Location;

/**
 *
 * @author Uskon
 */
public class LocationPuzzleTest {

    private LocationPuzzle lp;
    private ArrayList<ClickableObject> list;
    private HashMap<ClickableObject, Location> hm = new HashMap<>();
    SwappableObject o1;
    SwappableObject o2;
    Location o1target;
    Location o2target;

    public LocationPuzzleTest() {
    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        o1 = new SwappableObject(10, 10, 70, 70);
        o2 = new SwappableObject(400, 400, 70, 70);
        list.add(o1);
        list.add(o2);
        o1target = o2.getLocation();
        o2target = o1.getLocation();
        hm.put(o1, o1target);
        hm.put(o2, o2target);
        lp = new LocationPuzzle("testLocationPuzzle");
        lp.setObjectList(list);
        lp.setTargetLocations(hm);
    }

    @Test
    public void targetLocationsHashMapIsProperlySet() {
        assertTrue(lp.getTargetLocations().equals(hm));
    }

    @Test
    public void originalLocationsAreStoredSeparateFromTargetAndCurrentLocations() {
        o1.setLocation(new Location(99,1));
        hm.remove(o2);
        assertTrue(lp.getOriginalLocations().containsKey(o2) && lp.getOriginalLocations().get(o1).equals(new Location(10,10)));
    }
    
    @Test
    public void clearStatusWillChangeIfCompletedCorrectly() {
        o1.setLocation(o1target);
        o2.setLocation(o2target);
        lp.clearCheck();
        assertTrue(lp.isCleared());
    }
    
    @Test
    public void resettingWillChangeObjectLocationsBackToOriginal() {
        o1.setLocation(new Location(0,0));
        o2.setLocation(new Location(500,90));
        lp.reset();
        assertTrue(o1.getLocation().equals(new Location(10,10)) && o2.getLocation().equals(new Location(400,400)));
    }
}
