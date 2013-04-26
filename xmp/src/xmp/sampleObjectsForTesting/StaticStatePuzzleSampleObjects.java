/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.sampleObjectsForTesting;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import xmp.objects.ClickableObject;
import xmp.objects.StaticLinkedObject;
import xmp.objects.StaticObject;

/**
 *
 * @author Uskon
 */
public class StaticStatePuzzleSampleObjects {
    private HashMap<ClickableObject, Integer> correctStates = new HashMap<>();
    private ArrayList<ClickableObject> objects = new ArrayList<>();
    
    public StaticStatePuzzleSampleObjects() {
        StaticObject so1 = new StaticObject(50, 240, 80, 80);
        StaticObject so2 = new StaticObject(250, 240, 80, 80);
        StaticObject so3 = new StaticObject(450, 240, 80, 80);
        
        StaticLinkedObject slo1a = new StaticLinkedObject(so1, 60, 150, 60, 60);
        StaticLinkedObject slo1b = new StaticLinkedObject(so1, 60, 350, 60, 60);
        slo1b.setDirectionForward(false);
        StaticLinkedObject slo2a = new StaticLinkedObject(so2, 260, 150, 60, 60);
        StaticLinkedObject slo2b = new StaticLinkedObject(so2, 260, 350, 60, 60);
        slo2b.setDirectionForward(false);
        StaticLinkedObject slo3a = new StaticLinkedObject(so3, 460, 150, 60, 60);
        StaticLinkedObject slo3b = new StaticLinkedObject(so3, 460, 350, 60, 60);
        slo3b.setDirectionForward(false);
        
        File img1 = new File("images/one.png");
        File img2 = new File("images/two.png");
        File img3 = new File("images/three.png");
        File img4 = new File("images/four.png");
        File img5 = new File("images/five.png");
        File img6 = new File("images/six.png");
        File img7 = new File("images/seven.png");
        File img8 = new File("images/eight.png");
        File img9 = new File("images/nine.png");
        
        
        ArrayList<File> imagefiles= new ArrayList<>();
        imagefiles.add(img1);
        imagefiles.add(img2);
        imagefiles.add(img3);
        imagefiles.add(img4);
        imagefiles.add(img5);
        imagefiles.add(img6);
        imagefiles.add(img7);
        imagefiles.add(img8);
        imagefiles.add(img9);
        
        
        for (File file : imagefiles) {
            so1.addImageAsFile(file);
            so2.addImageAsFile(file);
            so3.addImageAsFile(file);
        }
       
        File up = new File("images/Red_Arrow_Up.png");
        File down = new File("images/Red_Arrow_Down.png");
        
        slo1a.setImage(up);
        slo1b.setImage(down);
        slo2a.setImage(up);
        slo2b.setImage(down);
        slo3a.setImage(up);
        slo3b.setImage(down);
        
        objects.add(so1);
        objects.add(so2);
        objects.add(so3);
        objects.add(slo1a);
        objects.add(slo1b);
        objects.add(slo2a);
        objects.add(slo2b);
        objects.add(slo3a);
        objects.add(slo3b);
        
        correctStates.put(so1, 6);
        correctStates.put(so2, 4);
        correctStates.put(so3, 1);
    }

    public HashMap<ClickableObject, Integer> getCorrectStates() {
        return correctStates;
    }

    public ArrayList<ClickableObject> getObjects() {
        return objects;
    }
    
    
}
