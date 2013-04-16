/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.sampleObjectsForTesting;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import xmp.activateableTriggers.Trigger;
import xmp.activateableTriggers.TriggerSequence;
import xmp.objects.ActivateableObject;
import xmp.objects.ClickableObject;

/**
 * Väliaikainen luokka ActivateableObjekteja käyttävän SequencePuzzlen testausta varten.
 * @author Uskon
 */
public class SequencePuzzleSampleObjects {
    private ArrayList<ClickableObject> list;
    private TriggerSequence tseq;
    
    public SequencePuzzleSampleObjects() {
        list = new ArrayList<>();
        File img = new File("images/redbutton.png");
        File alt = new File("images/greenbutton.png");
        ActivateableObject o1 = new ActivateableObject(10,10,70,70);
        ActivateableObject o2 = new ActivateableObject(400,400,70,70);
        ActivateableObject o3 = new ActivateableObject(10,400,70,70);
        ActivateableObject o4 = new ActivateableObject(400,10,70,70);
        o1.setImage(img);
        o1.setAltImage(alt);
        o2.setImage(img);
        o2.setAltImage(alt);
        o3.setImage(img);
        o3.setAltImage(alt);
        o4.setImage(img);
        o4.setAltImage(alt);
        Trigger t1 = new Trigger();
        Trigger t2 = new Trigger();
        Trigger t3 = new Trigger();
        Trigger t4 = new Trigger();
        tseq = new TriggerSequence();
        HashMap<Integer, Trigger> seq = new HashMap<>();
        seq.put(1, t4);
        seq.put(2, t2);
        seq.put(3, t1);
        seq.put(4, t3);
        tseq.newSequence(seq);
        o1.setTrigger(t4);
        o2.setTrigger(t2);
        o3.setTrigger(t1);
        o4.setTrigger(t3);
        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
    }
    
    public ArrayList<ClickableObject> getList() {
        return this.list;
    }
    
    public TriggerSequence getTSeq() {
        return this.tseq;
    }
}
