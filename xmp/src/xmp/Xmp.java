/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp;

import java.util.HashMap;
import javax.swing.SwingUtilities;
import xmp.activateableTriggers.Trigger;
import xmp.activateableTriggers.TriggerSequence;
import xmp.clickables.SwappableObject;
import xmp.utilities.ObjectPlaceSwapper;


/**
 *
 * @author Uskon
 */
public class Xmp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //UI ui = new UI();
        //SwingUtilities.invokeLater(ui);

        Trigger t1 = new Trigger();
        Trigger t2 = new Trigger();
        TriggerSequence ts = new TriggerSequence();
        HashMap<Integer, Trigger> tlist = new HashMap<>();
        tlist.put(1, t2);
        tlist.put(2, t1);
        ts.newSequence(tlist);
        t1.activateTrigger();
        ts.activateInCorrectOrder(t1);
        ts.printStatus();
        ts.activateInCorrectOrder(t2);
        ts.activateInCorrectOrder(t1);
        ts.printStatus();
        
    }
}
