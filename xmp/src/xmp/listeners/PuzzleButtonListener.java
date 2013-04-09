/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import xmp.puzzles.Puzzle;
import xmp.userInterface.GraphicsPanel;
import xmp.userInterface.UIContents;

/**
 *  Puzzlen valinnassa käytettävien JButtonia extendaavien PuzzleButtonien kuuntelija.
 * 
 */
public class PuzzleButtonListener implements ActionListener{
    /**
     * Luonnin yhteydessä PuzzleButtonilta saatu Puzzle-olio.
     */
    private Puzzle p;
    /**
     * Luonnin yhteydessä PuzzleButtonilta saatu UIContents-olio.
     */
    private UIContents uic;
    /**
     * Luonnin yhteydessä PuzzleButtonilta saatu GraphicsPanel-olio.
     */
    private GraphicsPanel gp;
    
    public PuzzleButtonListener(Puzzle p, UIContents c, GraphicsPanel g) {
        this.p = p;
        this.uic = c;
        this.gp = g;
    }
    
    
    /**
     * Kun PuzzleButtonListenerin buttonia klikataan, se asettaa sisältämänsä Puzzlen GraphicsPanelille ja sitten UIContentsin kautta siirtää ohjelman puzzle-näkymään.
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        gp.setPuzzle(p);
        uic.puzzleScreen();
        uic.refresh();
    }
    
}
