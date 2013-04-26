/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp;

import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import xmp.puzzles.LocationPuzzle;
import xmp.puzzles.Puzzle;
import xmp.puzzles.SequencePuzzle;
import xmp.puzzles.StaticStatePuzzle;
import xmp.sampleObjectsForTesting.LocationPuzzleSampleObjects;
import xmp.sampleObjectsForTesting.SequencePuzzleSampleObjects;
import xmp.sampleObjectsForTesting.StaticStatePuzzleSampleObjects;
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
        SequencePuzzleSampleObjects so = new SequencePuzzleSampleObjects();
        LocationPuzzleSampleObjects so2 = new LocationPuzzleSampleObjects();
        StaticStatePuzzleSampleObjects so3 = new StaticStatePuzzleSampleObjects();
        ArrayList<Puzzle> pl = new ArrayList<>();
        SequencePuzzle p = new SequencePuzzle("SequenceTestPuzzle");
        LocationPuzzle lp = new LocationPuzzle("LocationTestPuzzle");
        StaticStatePuzzle ssp = new StaticStatePuzzle("StaticStateTestPuzzle");
        p.setHint("1,5,7,3 Myötäpäivään rotaatio");
        lp.setHint("Värit ylös");
        ssp.setHint("x y z \n x - y = z \n x,y % 2 = 1 \n y > 2z");
        File bg = new File("images/background_wood.png");
        lp.setBackground(bg);
        p.setTseq(so.getTSeq());
        p.setObjectList(so.getList());
        lp.setObjectList(so2.getList());
        lp.setTargetLocations(so2.getHM());
        ssp.setCorrectStates(so3.getCorrectStates());
        ssp.setObjectList(so3.getObjects());
        pl.add(p);
        pl.add(lp);
        pl.add(ssp);
        UI ui = new UI(pl);
        SwingUtilities.invokeLater(ui);
        //--TEST CODE
        // TODO code application logic here

        //Currently only used for testing. Actual functionality will be implemented on a later date.
    }
}
