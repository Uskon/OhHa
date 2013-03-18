package xmp.utilities;

import xmp.objects.SwappableObject;

public class ObjectPlaceSwapper {

    public void swapPlaces(SwappableObject swo, SwappableObject swo2) {
        int swoCoordinateX = swo.getX();
        int swoCoordinateY = swo.getY();

        int swo2CoordinateX = swo2.getX();
        int swo2CoordinateY = swo2.getY();

        swo.setX(swo2CoordinateX);
        swo.setY(swo2CoordinateY);

        swo2.setX(swoCoordinateX);
        swo2.setY(swoCoordinateY);
    }
}
