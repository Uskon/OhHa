/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import xmp.userInterface.UI;
import xmp.userInterface.UIContents;

/**
 * Kuuntelija joka on vastuussa siirtymisestä puzzlenvalitsemisnäkymään.
 */

public class SelectionButtonListener implements ActionListener{
    /**
     * Käytettävä UIContents-olio.
     */
    private UIContents uic;
    
    public SelectionButtonListener(UIContents uic) {
        this.uic = uic;
    }
    
    /**
     * Luo UIContentsin metodeja käyttämällä valintanäkymän. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        uic.puzzleSelection();
        uic.refresh();
    }
    
}
