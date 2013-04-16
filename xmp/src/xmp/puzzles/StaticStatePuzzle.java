/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.puzzles;

import java.util.HashMap;
import xmp.objects.ClickableObject;
import xmp.objects.StaticObject;

/**
 * Puzzletyyppi, missä on tarkoituksena StaticLinkedObjectien avulla saada
 * puzzlen StaticObjectit oikeaan tilaan.
 *
 * @see xmp.puzzles.Puzzle
 * @see xmp.objects.StaticLinkedObject
 * @see xmp.objects.StaticObject
 */
public class StaticStatePuzzle extends Puzzle {

    private HashMap<ClickableObject, Integer> correctStates;

    public StaticStatePuzzle(String name) {
        super(name);
    }

    @Override
    public void clearCheck() {
        boolean doStatesMatch = true;
        StaticObject so = null;
        for (ClickableObject o : super.getObjectList()) {
            try {
                so = (StaticObject) o;
            } catch (Exception e) {
            }
            if (so != null) {
                if (!(correctStates.get(o) == so.getState())) {
                    doStatesMatch = false;
                }
                }
            }
        if (doStatesMatch) {
            super.setCleared(true);
        }
        }
    
    @Override
    public void reset() {
        super.setCleared(false);
    }
    
    }
