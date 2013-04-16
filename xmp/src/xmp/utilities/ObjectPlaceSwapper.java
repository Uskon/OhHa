package xmp.utilities;

import xmp.objects.SwappableObject;

/**
 * Työkalu SwappableObjectien paikkojen vaihtamiseen.
 * @see xmp.objects.SwappableObject
 *
 */
public class ObjectPlaceSwapper {

    /**
     * Vaihtaa parametrina annettuiden SwappableObjectien koordinaatit keskenään. Vanha metodi.
     * @param swo
     * @param swo2
     */
    public void swapPlacesOld(SwappableObject swo, SwappableObject swo2) {
        int swoCoordinateX = swo.getX();
        int swoCoordinateY = swo.getY();

        int swo2CoordinateX = swo2.getX();
        int swo2CoordinateY = swo2.getY();

        swo.setX(swo2CoordinateX);
        swo.setY(swo2CoordinateY);

        swo2.setX(swoCoordinateX);
        swo2.setY(swoCoordinateY);
    }
    
    /**
     * Vaihtaa parametrina annettuiden SwappableObjectien koordinaatit keskenään. Uusi Locationeja käyttävä metodi
     * 
     * @param swo
     * @param swo2 
     */
    public void swapPlaces(SwappableObject swo, SwappableObject swo2) {
        Location loc1 = swo.getLocation();
        Location loc2 = swo2.getLocation();
        
        swo.setLocation(loc2);
        swo2.setLocation(loc1);
    }
}
