/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp;

import java.util.HashMap;
import javax.swing.SwingUtilities;
import xmp.activateableTriggers.Trigger;
import xmp.activateableTriggers.TriggerSequence;
import xmp.objects.MoveableObject;
import xmp.objects.SwappableObject;
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

        Trigger trigger = new Trigger();
        TriggerSequence seq = new TriggerSequence();
        
        HashMap<Integer,Trigger> testList = new HashMap<>();
        testList.put(2,trigger);
        seq.newSequence(testList);
    }
}
