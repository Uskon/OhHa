/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.userInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import xmp.objects.ClickableObject;
import xmp.puzzles.Puzzle;

/**
 * JPanelin alaluokka, joka on vastuussa ClickableObjectien graafisesta esittämisestä.
 */
public class GraphicsPanel extends JPanel{
    /**
     * Puzzle, minkä objektit halutaan piirtää.
     * @see xmp.puzzles.Puzzle
     */
    private Puzzle p;
    private UIContents uic;
    
    public GraphicsPanel() {
        super.setBackground(Color.WHITE);
    }
    
/*    public ArrayList<ClickableObject> getObjectList() {
        return this.p.getObjectList();
    }
    
    public void setObjectList(ArrayList<ClickableObject> list) {
        this.p.setObjectList(list);
    }
    */
    
    public void setPuzzle(Puzzle p) {
        this.p = p;
    }
    
    public Puzzle getPuzzle() {
        return this.p;
    }
    
    
    /**
     * Piirtää kaikki puzzleen kuuluvat ClickableObjectit, tällä hetkellä testigrafiikoilla.
     * @see xmp.objects.ClickableObject
     * @param graphics 
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (ClickableObject object : p.getObjectList()) {
            object.drawTestGraphics(graphics);
        }
    }
    
    public void setUIC(UIContents uic) {
        this.uic = uic;
    }
    
    public UIContents getUIC() {
        return this.uic;
    }
}
