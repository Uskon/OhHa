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
 * Puzzleluokka, jonka suorittaminen perustuu objektien saamiseen oikeisiin sijainteihin.
 * 
 */
public class LocationPuzzle extends Puzzle{
    /**
     * ClickableObjektien halutut kohdesijainnit.
     */
    private HashMap<ClickableObject, Location> targetLocations = new HashMap<>();
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
    
    private void setOriginalLocations(ArrayList<ClickableObject> oLoc) {
        for (ClickableObject o : oLoc) {
            this.originalLocations.put(o, o.getLocation());
        }
    }
    
    /**
     * Tarkistaa, ovatko kaikki objektit halutuissa sijainneissa.
     */
    @Override
    public void clearCheck() {
        boolean doLocationsMatch = true;
        for (ClickableObject o : getObjectList()) {
            if (!(targetLocations.get(o).getCoordinateX() == o.getX())) {
                doLocationsMatch = false;
            }
        }   if (doLocationsMatch) {
            super.setCleared(true);
        }
    }
    
    @Override
    public void reset() {
        for (ClickableObject o : getObjectList()) {
            o.setLocation(originalLocations.get(o));
        }
        super.setCleared(false);
    }
}
