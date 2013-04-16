/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesTest;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import xmp.activateableTriggers.Trigger;
import xmp.activateableTriggers.TriggerSequence;
import xmp.objects.ActivateableObject;
import xmp.objects.ClickableObject;
import xmp.puzzles.SequencePuzzle;

/**
 *
 * @author Uskon
 */
public class SequencePuzzleTest {

    SequencePuzzle sp;
    TriggerSequence tseq;
    HashMap<Integer, Trigger> seq;
    ArrayList<ClickableObject> list;
    ActivateableObject o1;
    ActivateableObject o2;
    ActivateableObject o3;
    ActivateableObject o4;
    Trigger t1;
    Trigger t2;
    Trigger t3;
    Trigger t4;

    public SequencePuzzleTest() {
    }

    @Before
    public void setUp() {
        o1 = new ActivateableObject(10, 10, 70, 70);
        o2 = new ActivateableObject(400, 400, 70, 70);
        o3 = new ActivateableObject(10, 400, 70, 70);
        o4 = new ActivateableObject(400, 10, 70, 70);
        t1 = new Trigger();
        t2 = new Trigger();
        t3 = new Trigger();
        t4 = new Trigger();
        tseq = new TriggerSequence();
        seq = new HashMap<>();
        seq.put(1, t4);
        seq.put(2, t2);
        seq.put(3, t1);
        seq.put(4, t3);
        tseq.newSequence(seq);
        o1.setTrigger(t4);
        o2.setTrigger(t2);
        o3.setTrigger(t1);
        o4.setTrigger(t3);
        list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        sp = new SequencePuzzle("testSequencePuzzle");
        sp.setTseq(tseq);
        sp.setObjectList(list);
    }

    @Test
    public void puzzleToStringPrintsName() {
        assertTrue(sp.toString().equals("testSequencePuzzle"));
    }

    @Test
    public void triggerSequnceIsSetCorrectly() {
        assertTrue(sp.getTseq().equals(tseq));
    }

    @Test
    public void objectListIsSetCorrectly() {
        assertTrue(sp.getObjectList().equals(list));
    }

    @Test
    public void clearStatusWillChangeIfCompletedCorrectly() {
        o1.triggerObject();
        o2.triggerObject();
        o3.triggerObject();
        o4.triggerObject();
        sp.clearCheck();
        assertTrue(sp.isCleared() == true);
    }

    @Test
    public void resettingWillSetAllTriggersToFalse() {
        sp.reset();
        assertTrue(!t1.checkStatus() && !t2.checkStatus() && !t3.checkStatus() && !t4.checkStatus());
    }
}
