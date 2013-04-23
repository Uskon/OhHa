/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import xmp.objects.ClickableObject;
import xmp.utilities.Location;

/**
 * Puzzleluokka, jonka suorittaminen perustuu SwappableObjectien tai MoveableObjectien saamiseen oikeisiin sijainteihin.
 * @see xmp.puzzles.Puzzle
 * @see xmp.objects.SwappableObject
 * @see xmp.objects.MoveableObject
 * @see xmp.utilities.Location
 */
public class LocationPuzzle extends Puzzle{
    /**
     * ClickableObjektien halutut kohdesijainnit.
     */
    private HashMap<ClickableObject, Location> targetLocations = new HashMap<>();
    /**
     * ClickableObjectien alkuperäiset sijainnit.
     */
    private HashMap<ClickableObject, Location> originalLocations = new HashMap<>();
    
    public LocationPuzzle(String name) {
        super(name);
    }

    public HashMap<ClickableObject, Location> getTargetLocations() {
        return targetLocations;
    }

    public void setTargetLocations(HashMap<ClickableObject, Location> targetLocations) {
        this.targetLocations = targetLocations;
        setOriginalLocations(super.getObjectList());
    }
    
    /**
     * Luo listan, joka säilyttää tiedot Puzzleen kuuluvien ClickableObjectien alkuperäisistä Locationeista.
     * @param oLoc 
     */
    private void setOriginalLocations(ArrayList<ClickableObject> oLoc) {
        for (ClickableObject o : oLoc) {
            this.originalLocations.put(o, o.getLocation());
        }
    }
    
    public HashMap<ClickableObject, Location> getOriginalLocations() {
        return this.originalLocations;
    }
    
    /**
     * Tarkistaa, ovatko kaikki objektit halutuissa sijainneissa.
     */
    @Override
    public void clearCheck() {
        boolean doLocationsMatch = true;
        for (ClickableObject o : getObjectList()) {
            if (!((targetLocations.get(o).getCoordinateX() == o.getX()) && (targetLocations.get(o).getCoordinateY() == o.getY()))) {
                doLocationsMatch = false;
            }
        }   if (doLocationsMatch) {
            super.setCleared(true);
        }
    }
    
    /**
     * Palauttaa puzzlen alkuperäiseen tilaansa.
     */
    @Override
    public void reset() {
        for (ClickableObject o : getObjectList()) {
            o.setLocation(originalLocations.get(o));
        }
        super.setCleared(false);
    }
}
