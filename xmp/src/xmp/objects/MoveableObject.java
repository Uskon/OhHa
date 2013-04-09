package xmp.objects;

/**
 * ClickableObject jota voidaan liikutella vapaasti.
 * @see xmp.objects.ClickableObject
 */
public class MoveableObject extends ClickableObject {

    public MoveableObject(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    /**
     * Liikuttaa objektia olettaen että sen koordinaatit pysyvät sallituissa rajoissa.
     * @param x uusi x-koordinaatti
     * @param y uusi y-koordinaatti
     */
    public void moveObject(int x, int y) {
        if (x >= 0 && y >= 0) {
            super.setX(x);
            super.setY(y);
        } else {
            throw new IllegalArgumentException("Object cannot be moved to negative coordinates");
        }
    }
    }
