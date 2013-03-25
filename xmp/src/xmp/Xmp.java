/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.SwingUtilities;
import xmp.activateableTriggers.Trigger;
import xmp.activateableTriggers.TriggerSequence;
import xmp.objects.ActivateableObject;
import xmp.objects.ClickableObject;
import xmp.objects.MoveableObject;
import xmp.objects.SwappableObject;
import xmp.utilities.ObjectPlaceSwapper;
import xmp.utilities.SwappableObjectMemorizer;


/**
 *
 * @author Uskon
 */
public class Xmp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MoveableObject o1 = new MoveableObject(50,50, 20, 20);
        SwappableObject s1 = new SwappableObject(10, 20, 10, 40);
        SwappableObject s2 = new SwappableObject(40, 160, 60, 20);
        ArrayList<ClickableObject> list = new ArrayList<>();
        list.add(o1);
        list.add(s1);
        list.add(s2);
        GraphicsPanel gpanel = new GraphicsPanel();
        gpanel.setObjectList(list);
        UI ui = new UI(gpanel);
        SwingUtilities.invokeLater(ui);
        // TODO code application logic here

        //Currently only used for testing. Actual functionality will be implemented on a later date.
    }
}
