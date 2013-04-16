/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.utilities;

/**
 * Objektien sijaintien tehokkaamman käsittelyn vuoksi luotu apuluokka.
 * 
 */
public class Location {
    private int coordinateX;
    private int coordinateY;
    
    public Location(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    
    /**
     * Tarkistaa, ovatko sijainnit samat.
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        if (getClass() != object.getClass()) {
            return false;
        }   else {
            Location l2 = (Location) object;
            if (this.coordinateX == l2.getCoordinateY() && this.coordinateY == l2.getCoordinateY()) {
                return true;
            }   else {
                return false;
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

}
