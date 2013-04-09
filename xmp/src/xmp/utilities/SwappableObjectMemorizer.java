/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.utilities;

import xmp.objects.SwappableObject;

/**
 * Työkalu SwappableObjectien oikeanlaiseen paikkojenvaihtamiseen.
 * 
 */
public class SwappableObjectMemorizer {
    private SwappableObject swappable1 = null;
    private SwappableObject swappable2 = null;
    /**
     * ObjectPlaceSwapper joka hoitaa varsinaisen työn.
     * @see xmp.utilities.ObjectPlaceSwapper
     */
    private ObjectPlaceSwapper swapper = new ObjectPlaceSwapper();

    public SwappableObjectMemorizer() {
    }

    /**
     * Asettaa private-muuttujiin annetun SwappableObjectin oikein ehdoin ja suorittaa paikkojenvaihdon kun molemmat on asetettu, samaa SwappableObjectia ei voi asettaa molempiin muuttujiin.
     * @param sw Muuttujaksia asetettava SwappableObject
     */
    public void manageSwappables(SwappableObject sw) {
        if (swappable1 == null) {
            swappable1 = sw;
        } else if (swappable1 == sw && swappable2 == null) {
        }
        else if (swappable1 != null && swappable1 != sw && swappable2 == null ) {
            swappable2 = sw;
            swapper.swapPlaces(swappable1, swappable2);
            swappable1 = null;
            swappable2 = null;
        }
    }
    
    public SwappableObject getSwappable1() {
        return swappable1;
    }

    public void setSwappable1(SwappableObject swappable1) {
        this.swappable1 = swappable1;
    }

    public SwappableObject getSwappable2() {
        return swappable2;
    }

    public void setSwappable2(SwappableObject swappable2) {
        this.swappable2 = swappable2;
    }
}
