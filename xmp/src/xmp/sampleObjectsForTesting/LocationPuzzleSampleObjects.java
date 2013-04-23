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
        File img1 = new File("images/greenpog.png");
        File img2 = new File("images/bluepog.png");
        File img3 = new File("images/whitepog.png");
        File img4 = new File("images/steelpog.png");
        SwappableObject o1 = new SwappableObject(10,10,70,70);
        SwappableObject o2 = new SwappableObject(400,400,70,70);
        SwappableObject o3 = new SwappableObject(400,10,70,70);
        SwappableObject o4 = new SwappableObject(10,400,70,70);
        o1.setImage(img1);
        o2.setImage(img2);
        o3.setImage(img3);
        o4.setImage(img4);

        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        Location o1target = o3.getLocation();
        Location o2target = o1.getLocation();
        Location o3target = o4.getLocation();
        Location o4target = o2.getLocation();
        hm.put(o1, o1target);
        hm.put(o2, o2target);
        hm.put(o3, o3target);
        hm.put(o4, o4target);
    }
    
    public ArrayList<ClickableObject> getList() {
        return this.list;
    }
    
    public HashMap<ClickableObject, Location> getHM() {
        return hm;
    }

}

