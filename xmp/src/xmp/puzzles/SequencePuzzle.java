/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.puzzles;

import java.util.ArrayList;
import xmp.activateableTriggers.TriggerSequence;
import xmp.objects.ClickableObject;

/**
 * Puzzleluokka, minkä ilmentymien ratkaiseminen perustuu ActivateableObjectien käyttämiseen oikeassa järjestyksessä.
 * 
 */
public class SequencePuzzle extends Puzzle{
    /**
     * Puzzlen ratkaisemisjärjestyksen määrittävä TriggerSequence-olio
     * @see xmp.activateableTriggers.TriggerSequence
     */
    private TriggerSequence tseq;
    /**
     * Lista puzzleen kuuluvista ClickableObjecteista.
     */
    private ArrayList<ClickableObject> objectList;

    public SequencePuzzle(String name) {
        super(name);
    }
    
    public TriggerSequence getTseq() {
        return tseq;
    }

    public void setTseq(TriggerSequence tseq) {
        this.tseq = tseq;
    }
    
    /**
     * Tarkistaa, onko sekvenssi suoritettu onnistuneesti, ja sen mukaan muuttaa suoritustilannetta.
     */
    @Override
    public void clearCheck() {
        if (tseq.checkIfSequenceIsCompleted() == true) {
            super.cleared = true;
        }
    }
    
    @Override
    public void reset() {
        super.setCleared(false);
        tseq.deactivateAllTriggers();
    }
}
