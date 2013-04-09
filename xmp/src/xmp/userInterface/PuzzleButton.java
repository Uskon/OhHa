/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.userInterface;

import javax.swing.JButton;
import xmp.listeners.PuzzleButtonListener;
import xmp.puzzles.Puzzle;

/**
 * JButtonin alaluokka, jota käytetään kokeiltavan puzzlen valitsemiseen.
 */
public class PuzzleButton extends JButton{
    /**
     * Buttonille määritetty puzzle.
     */
    private Puzzle p;
    /**
     * Käytettävä UIContents.
     */
    private UIContents uic;
    /**
     * Käytettävä GraphicsPanel.
     */
    private GraphicsPanel gp;
    
    public PuzzleButton(String name, Puzzle p, UIContents uic, GraphicsPanel gp) {
        super(name);
        this.p = p;
        this.uic = uic;
        this.gp = gp;
        super.addActionListener(new PuzzleButtonListener(p, uic, gp));
    }

    public Puzzle getP() {
        return p;
    }

    public void setP(Puzzle p) {
        this.p = p;
    }

    public UIContents getUic() {
        return uic;
    }

    public void setUic(UIContents uic) {
        this.uic = uic;
    }

    public GraphicsPanel getGp() {
        return gp;
    }

    public void setGp(GraphicsPanel gp) {
        this.gp = gp;
    }
    
    
}
