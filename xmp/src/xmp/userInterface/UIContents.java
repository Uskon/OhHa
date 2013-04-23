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
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import xmp.listeners.SelectionButtonListener;
import xmp.puzzles.Puzzle;
import xmp.utilities.SwappableObjectMemorizer;

/**
 * Vastuussa käyttöliittymän sisällön muuttamisesta.
 *
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
    /**
     * Eri näkymiin kuuluva alalaidan valikkopalkki.
     */
    private JPanel menubar = new JPanel();
    /**
     * Eri näkymiin kuuluva oikean laidan infopalkki.
     */
    private JPanel infobar = new JPanel();
    /**
     * Puzzlenäkymässä infobarin tekstisisältö.
     */
    private JLabel statustext = new JLabel();
    
    private GraphicsPanelListener gpl;
    
    private SwappableObjectMemorizer smemo;
    
    public UIContents(UI ui) {
        this.ui = ui;
        this.puzzleList = ui.getPuzzles();
        this.c = ui.getFrame().getContentPane();
        c.add(p);
        smemo = new SwappableObjectMemorizer();
        gpl = new GraphicsPanelListener(ui.getGraphicsPanel(),smemo);
    }
   
    /**
     * Luo käynnistysvalikon.
     */
    public void startMenu() {
        resetPanels();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBackground(Color.black);
        JButton selection = new JButton("Select puzzle");
        //JButton options = new JButton("Options? To-be-implemented");
        JPanel title = new JPanel();
        JLabel titletext = new JLabel("xmP tentative title");
        titletext.setForeground(Color.red);
        title.setBackground(Color.black);
        title.setBorder(new LineBorder(Color.white));
        title.add(titletext);
        selection.addActionListener(new SelectionButtonListener(this));
        title.setMaximumSize(new Dimension(1600, 100));
        selection.setMaximumSize(new Dimension(250, 70));
        //options.setMaximumSize(new Dimension(250, 70));
        p.add(title);
        p.add(Box.createRigidArea(new Dimension (0, 50)));
        p.add(selection);
        p.add(Box.createRigidArea(new Dimension (0, 100)));
        //p.add(options);
    }
    
    /**
     * Luo puzzlenvalintanäkymän.
     */
    public void puzzleSelection() {
        resetPanels();
        p.setLayout(new BorderLayout());
        JPanel filler = new JPanel();
        filler.setBackground(Color.black);
        filler.setPreferredSize(new Dimension(800,80));
        JPanel puzzles = new JPanel();
        puzzles.setBackground(Color.BLACK);
        p.add(filler, BorderLayout.NORTH);
        if (this.puzzleList != null) {
        for (Puzzle z : this.puzzleList) {
            puzzles.add(new PuzzleButton(z.toString(),z,this,ui.getGraphicsPanel()));
        }
        }   p.add(puzzles);
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
        for (Puzzle x : puzzleList) {
            x.reset();
        }
        smemo.reset();
        ui.getFrame().removeMouseListener(gpl);
        resetPanels();
        p.setLayout(new BorderLayout());
        p.add(ui.getGraphicsPanel());
        JButton selection = new JButton("Back to selection");
        selection.addActionListener(new SelectionButtonListener(this));
        statustext.setPreferredSize(new Dimension(200,200));
        infobar.add(statustext);
        infobar.setBorder(new MatteBorder(1,1,1,1, Color.black));
        menubar.add(selection);
        p.add(menubar, BorderLayout.SOUTH);
        p.add(infobar, BorderLayout.EAST);
        ui.getFrame().addMouseListener(gpl);
    }
    
    public JLabel getStatustext() {
        return this.statustext;
    }
    
    /**
     * Tyhjentää kaikki Frameen kuuluvat oleelliset komponentit, jotta niihin ei kertyisi vanhaa tavaraa.
     */
    public void resetPanels() {
        p.removeAll();
        infobar.removeAll();
        menubar.removeAll();
        statustext.setText("");
    }
}
