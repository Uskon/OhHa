/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import xmp.objects.ClickableObject;
import xmp.objects.MoveableObject;
import xmp.objects.SampleObjects;
import xmp.objects.SwappableObject;
import xmp.puzzles.Puzzle;
import xmp.puzzles.SequencePuzzle;
import xmp.userInterface.UI;


/**
 *
 * @author Uskon
 */
public class Xmp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TEST CODE--
        MoveableObject o1 = new MoveableObject(50,50, 20, 20);
        SwappableObject s1 = new SwappableObject(10, 20, 10, 40);
        SwappableObject s2 = new SwappableObject(40, 160, 60, 20);
        /*ArrayList<ClickableObject> list = new ArrayList<>();
        list.add(o1);
        list.add(s1);
        list.add(s2);*/
        SampleObjects so = new SampleObjects();
        ArrayList<Puzzle> pl = new ArrayList<>();
        SequencePuzzle p = new SequencePuzzle("TestPuzzle");
        p.setTseq(so.getTSeq());
        p.setObjectList(so.getList());
        pl.add(p);
        UI ui = new UI(pl);
        SwingUtilities.invokeLater(ui);
        //--TEST CODE
        // TODO code application logic here

        //Currently only used for testing. Actual functionality will be implemented on a later date.
    }
}
