/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import sas.swing.plaf.MultiLineLabelUI;
import xmp.listeners.HintButtonListener;
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
    private Container container;
    /**
     * Käyttöliittymän varsinaisen sisällön pohja.
     */
    private JPanel mainPanel = new JPanel();
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
        this.container = ui.getFrame().getContentPane();
        container.add(mainPanel);
        smemo = new SwappableObjectMemorizer();
        gpl = new GraphicsPanelListener(ui.getGraphicsPanel(), smemo);
    }

    /**
     * Luo käynnistysvalikon.
     */
    public void startMenu() {
        resetPanels();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(Color.black);

        JButton selection = new JButton("Select puzzle");
        JPanel title = new JPanel();
        JLabel titletext = new JLabel("xmP Puzzle platform");

        titletext.setForeground(Color.red);
        title.setBackground(Color.black);
        title.setBorder(new LineBorder(Color.white));
        title.add(titletext);
        title.setMaximumSize(new Dimension(1600, 100));

        selection.setMaximumSize(new Dimension(250, 70));
        selection.addActionListener(new SelectionButtonListener(this));

        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        mainPanel.add(selection);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 100)));
    }

    /**
     * Luo puzzlenvalintanäkymän.
     */
    public void puzzleSelection() {
        resetPanels();
        mainPanel.setLayout(new BorderLayout());
        JPanel filler = new JPanel();
        JPanel puzzles = new JPanel();

        filler.setBackground(Color.black);
        filler.setPreferredSize(new Dimension(800, 80));

        puzzles.setBackground(Color.BLACK);

        mainPanel.add(filler, BorderLayout.NORTH);

        if (this.puzzleList != null) {
            for (Puzzle z : this.puzzleList) {
                puzzles.add(new PuzzleButton(z.toString(), z, this, ui.getGraphicsPanel()));
            }
        }
        mainPanel.add(puzzles);
    }

    /**
     * Päivittää käyttöliittymän ulkonäön.
     */
    public void refresh() {
        mainPanel.repaint();
        mainPanel.revalidate();
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
        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(ui.getGraphicsPanel());
        
        JButton showHint = new JButton("Show Hint");
        HintButtonListener hbl = new HintButtonListener(statustext, ui.getGraphicsPanel().getPuzzle(), this);
        JButton selection = new JButton("Back to selection");
        
        selection.addActionListener(new SelectionButtonListener(this));
        statustext.setPreferredSize(new Dimension(150, 200));
        
        //Käyttää MultiLineLabel-luokkia projektiin liitetystä sas-paketista.
        statustext.setUI(MultiLineLabelUI.labelUI);
        infobar.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        
        showHint.addActionListener(hbl);
        infobar.setLayout(new BorderLayout());
        infobar.add(statustext);
        infobar.add(showHint, BorderLayout.SOUTH);
        menubar.add(selection);
        mainPanel.add(menubar, BorderLayout.SOUTH);
        mainPanel.add(infobar, BorderLayout.EAST);
        
        ui.getFrame().addMouseListener(gpl);
    }

    public JLabel getStatustext() {
        return this.statustext;
    }

    /**
     * Tyhjentää kaikki Frameen kuuluvat oleelliset komponentit, jotta niihin ei
     * kertyisi vanhaa tavaraa.
     */
    public void resetPanels() {
        mainPanel.removeAll();
        infobar.removeAll();
        menubar.removeAll();
        statustext.setText("");
    }
}
