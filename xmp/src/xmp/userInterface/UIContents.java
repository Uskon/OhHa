/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import xmp.listeners.SelectionButtonListener;
import xmp.puzzles.Puzzle;

/**
 * Vastuussa käyttöliittymän sisällön muuttamisesta.
 * @author Uskon
 */
public class UIContents {
    /**
     * Käyttöliittymän mihin vaikutetaan.
     */
    private UI ui;
    /**
     * Käyttöliittymän JFramen Containeri.
     */
    private Container c;
    /**
     * Käyttöliittymän varsinaisen sisällön pohja.
     */
    private JPanel p = new JPanel();
    /**
     * UI:lta saadut puzzlet.
     */
    private ArrayList<Puzzle> puzzleList;
    
    public UIContents(UI ui) {
        this.ui = ui;
        this.puzzleList = ui.getPuzzles();
        this.c = ui.getFrame().getContentPane();
        c.add(p);
    }
   
    /**
     * Luo käynnistysvalikon.
     */
    public void startMenu() {
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBackground(Color.black);
        JButton selection = new JButton("Select puzzle");
        JButton options = new JButton("Options? To-be-implemented");
        JPanel title = new JPanel();
        JLabel titletext = new JLabel("xmP tentative title");
        titletext.setForeground(Color.red);
        title.setBackground(Color.black);
        title.setBorder(new LineBorder(Color.white));
        title.add(titletext);
        selection.addActionListener(new SelectionButtonListener(this));
        title.setMaximumSize(new Dimension(1600, 100));
        selection.setMaximumSize(new Dimension(250, 70));
        options.setMaximumSize(new Dimension(250, 70));
        p.add(title);
        p.add(Box.createRigidArea(new Dimension (0, 50)));
        p.add(selection);
        p.add(Box.createRigidArea(new Dimension (0, 100)));
        p.add(options);
    }
    
    /**
     * Luo puzzlenvalintanäkymän.
     */
    public void puzzleSelection() {
        p.removeAll();
        p.setLayout(new FlowLayout());
        if (this.puzzleList != null) {
        for (Puzzle z : this.puzzleList) {
            p.add(new PuzzleButton(z.toString(),z,this,ui.getGraphicsPanel()));
        }
        }
    }
    
    /**
     * Päivittää käyttöliittymän ulkonäön.
     */
    public void refresh() {
        p.repaint();
        p.revalidate();
    }

    /**
     * Luo puzzlenratkaisunäkymän.
     */
    public void puzzleScreen() {
        p.removeAll();
        p.setLayout(new BorderLayout());
        p.add(ui.getGraphicsPanel());
        JPanel menubar = new JPanel();
        JPanel infobar = new JPanel();
        p.add(menubar, BorderLayout.SOUTH);
        p.add(infobar, BorderLayout.EAST);
        ui.getFrame().addMouseListener(new GraphicsPanelListener(ui.getGraphicsPanel()));
    }
}
