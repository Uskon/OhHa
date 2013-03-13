/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.clickables;

/**
 *
 * @author Uskon
 */
public abstract class ClickableObject {
    int coordinateX;
    int coordinateY;
    
    public ClickableObject(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }
    
    public void setX(int x) {
        coordinateX = x;
    }
    
    public void setY(int y) {
        coordinateY = y;
    }
    
    public int getX() {
        return this.coordinateX;
    }
    
    public int getY() {
        return this.coordinateY;
    }
    
}
