/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.objects;

/**
 * ClickableObject johon on liitettynä yksi StaticObject, kykenee vaihtamaan StaticObjectin imagen seuraavaksi tai aiemmaksi.
 * @see xmp.objects.StaticObject
 */
public class StaticLinkedObject extends ClickableObject{
    private StaticObject linkedTo = null;
    private boolean forward = true;
    
    public StaticLinkedObject(StaticObject so, int x, int y, int w, int h) {
        super(x,y,w,h);
        this.linkedTo = so;
    }
    
     /**
      * Asettaa, kumpaan suuntaan liitettyä StaticObjectin imagelistaa käytetään.
      * @param b true = nextImage(), false = previousImage()
      */
    public void setDirectionForward(boolean b) {
        this.forward = b;
    }
    
    /**
     * Muuttaa StaticObjectin imagea riippuen siitä, onko muuttuja forward asetettu trueksi vai falseksi.
     * @see xmp.objects.StaticObject#nextImage()
     * @see xmp.objects.StaticObject#previousImage()
     */
    public void activate() {
        if (forward) {
            linkedTo.nextImage();
        }   else {
            linkedTo.previousImage();
        }
    }
}
