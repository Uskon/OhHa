/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.sampleObjectsForTesting;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import xmp.objects.ClickableObject;
import xmp.objects.SwappableObject;
import xmp.utilities.Location;

/**
 *
 * @author Uskon
 */
public class LocationPuzzleSampleObjects {
    
    private ArrayList<ClickableObject> list;
    private HashMap<ClickableObject, Location> hm = new HashMap<>();

    
    public LocationPuzzleSampleObjects() {
        list = new ArrayList<>();
        File img = new File("images/redbutton.png");
        File alt = new File("images/greenbutton.png");
        SwappableObject o1 = new SwappableObject(10,10,70,70);
        SwappableObject o2 = new SwappableObject(400,400,70,70);
        o1.setImage(img);
        o2.setImage(alt);

        list.add(o1);
        list.add(o2);
        Location o1target = o2.getLocation();
        Location o2target = o1.getLocation();
        hm.put(o1, o1target);
        hm.put(o2, o2target);
    }
    
    public ArrayList<ClickableObject> getList() {
        return this.list;
    }
    
    public HashMap<ClickableObject, Location> getHM() {
        return hm;
    }

}

