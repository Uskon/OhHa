/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.clickables;

/**
 *
 * @author Uskon
 */
public class MoveableObject extends ClickableObject{
    
    public MoveableObject(int x, int y) {
        super(x, y);
    }
    
    public void moveObject(int x, int y) {
        super.setX(x);
        super.setY(y);
    }
}
