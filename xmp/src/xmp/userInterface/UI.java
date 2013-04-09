/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.userInterface;

/**
 *
 * @author Uskon
 */

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import xmp.puzzles.Puzzle;

/**
 * Käyttöliittymän määrittelevä luokka.
 */
public class UI implements Runnable {
    /**
     * Käytettävissä olevat puzzlet.
     */
    private ArrayList<Puzzle> pl;
    /**
     * UIContents joka määrittelee käyttöliittymän sisältöä.
     */
    private UIContents uic;
    /**
     * Käyttöliittymän JFrame.
     */
    private JFrame frame;
    /**
     * Käytettävissä oleva GraphicsPanel.
     */
    private GraphicsPanel graphicsPanel = new GraphicsPanel();

    public UI(ArrayList<Puzzle> pl) {
        this.pl = pl;
    }

    @Override
    public void run() {
        frame = new JFrame("xmP");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Asettaa UIContentsin ja luo käynnistysvalikon.
     * @param container 
     */
    private void createComponents(Container container) {
        uic = new UIContents(this);
        uic.startMenu();
    }
    
    public void setUIC(UIContents uic) {
        this.uic = uic;
    } 

    public JFrame getFrame() {
        return frame;
    }

    public GraphicsPanel getGraphicsPanel() {
        return graphicsPanel;
    }

    public void setGraphicsPanel(GraphicsPanel graphicsPanel) {
        this.graphicsPanel = graphicsPanel;
    }
    
    public UIContents getUIContents() {
        return this.uic;
    }
    
    public ArrayList<Puzzle> getPuzzles() {
        return this.pl;
    }
}
