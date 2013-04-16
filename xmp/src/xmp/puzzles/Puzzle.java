/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.puzzles;

import java.util.ArrayList;
import xmp.objects.ClickableObject;

/**
 * Abstrakti yläluokka mihin kaikki puzzlet kuuluvat.
 */
public abstract class Puzzle {
    /**
     * Puzzlen näytettävä nimi.
     */
    private String name;
    /**
     * Onko puzzle suoritettu onnistuneesti.
     */
    boolean cleared = false;
    /**
     * Puzzlen sisältämät ClickableObjectit.
     * @see xmp.objects.ClickableObject
     */
    private ArrayList<ClickableObject> objectList;
    private ArrayList<ClickableObject> originalState = new ArrayList<>();
    
    public Puzzle(String name) {
        this.name = name;
    }

    /**
     * Palauttaa tiedon puzzlen suoritustilanteesta.
     * @return boolean
     */
    public boolean isCleared() {
        return cleared;
    }

    /**
     * Asettaa puzzlen suoritetuksi tai keskeneräiseksi.
     * @param isCleared 
     */
    public void setCleared(boolean isCleared) {
        this.cleared = isCleared;
    }

    public ArrayList<ClickableObject> getObjectList() {
        return objectList;
    }
    
    public void setObjectList(ArrayList<ClickableObject> objectList) {
        this.objectList = objectList;
        
    }
    
    public ArrayList<ClickableObject> getOriginalState() {
        return this.originalState;
    }
    
    /**
     * Alaluokilla on omat metodinsa suoritustilanteen selvittämistä varten.
     */
    public void clearCheck() {
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public void reset() {
    }
}
