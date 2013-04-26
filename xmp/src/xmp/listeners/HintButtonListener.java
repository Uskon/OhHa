/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import xmp.puzzles.Puzzle;
import xmp.userInterface.UIContents;

/**
 *  HintButtonin kuuntelija.
 * @author Uskon
 */
public class HintButtonListener implements ActionListener{
    private JLabel text;
    private Puzzle puzzle;
    private UIContents uic;
    
    public HintButtonListener(JLabel text, Puzzle puzzle, UIContents uic) {
        this.text = text;
        this.puzzle = puzzle;
        this.uic = uic;
    }
    
    /**
     * Näyttää Puzzlelle asetetun vihjetekstin.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        text.setText(puzzle.getHint());
        uic.refresh();
    }
    
}
