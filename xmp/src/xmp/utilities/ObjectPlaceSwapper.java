/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.utilities;

import xmp.clickables.SwappableObject;

/**
 *
 * @author Uskon
 */
public class ObjectPlaceSwapper {

    public void swapPlaces(SwappableObject swo, SwappableObject swo2) {
        int swoCoordinateX = swo.getX();
        int swoCoordinateY = swo.getY();

        int swo2CoordinateX = swo2.getX();
        int swo2CoordinateY = swo2.getX();

        swo.setX(swo2CoordinateX);
        swo.setY(swo2CoordinateY);

        swo2.setX(swoCoordinateX);
        swo2.setY(swoCoordinateY);
    }
}
