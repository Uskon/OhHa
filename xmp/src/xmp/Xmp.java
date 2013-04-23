/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.SwingUtilities;
import xmp.objects.ClickableObject;
import xmp.objects.MoveableObject;
import xmp.sampleObjectsForTesting.SequencePuzzleSampleObjects;
import xmp.sampleObjectsForTesting.LocationPuzzleSampleObjects;
import xmp.objects.SwappableObject;
import xmp.puzzles.LocationPuzzle;
import xmp.puzzles.Puzzle;
import xmp.puzzles.SequencePuzzle;
import xmp.userInterface.UI;
import xmp.utilities.Location;


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
        SequencePuzzleSampleObjects so = new SequencePuzzleSampleObjects();
        LocationPuzzleSampleObjects so2 = new LocationPuzzleSampleObjects();
        ArrayList<Puzzle> pl = new ArrayList<>();
        SequencePuzzle p = new SequencePuzzle("SequenceTestPuzzle");
        LocationPuzzle lp = new LocationPuzzle("LocationTestPuzzle");
        File bg = new File("images/background_wood.png");
        lp.setBackground(bg);
        ArrayList<ClickableObject> list = new ArrayList<>();
        list.add(o1);
        p.setTseq(so.getTSeq());
        p.setObjectList(so.getList());
        lp.setObjectList(so2.getList());
        lp.setTargetLocations(so2.getHM());
        pl.add(p);
        pl.add(lp);
        UI ui = new UI(pl);
        SwingUtilities.invokeLater(ui);
        //--TEST CODE
        // TODO code application logic here

        //Currently only used for testing. Actual functionality will be implemented on a later date.
    }
}
