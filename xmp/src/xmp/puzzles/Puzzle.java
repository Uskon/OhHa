/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.puzzles;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
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
    /** 
     * Puzzlen tausta
     * 
     */
    private Image background = null;
    /**
     * Mahdollinen vihje, sillä tällä hetkellä puzzlet ovat poissa kontekstista.
     */
    private String hint = "";
    
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
    
    public void setBackground(File imagefile) {
        try {
            this.background = ImageIO.read(imagefile);
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }
    
    public Image getBackground() {
        return this.background;
    }
    
    public String getHint() {
        return this.hint;
    }
    
    public void setHint(String hint) {
        this.hint = hint;
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
    
    /**
     * Puzzleilla käytettävissä oleva metodi, joka palauttaa Puzzlen käytännössä alkuperäiseen tilaansa.
     */
    public void reset() {
    }
}
