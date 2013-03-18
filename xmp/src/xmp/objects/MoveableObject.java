package xmp.objects;

public class MoveableObject extends ClickableObject {

    public MoveableObject(int x, int y) {
        super(x, y);
    }

    public void moveObject(int x, int y) {
        if (x >= 0 && y >= 0) {
            super.setX(x);
            super.setY(y);
        } else {
            throw new IllegalArgumentException("Object cannot be moved to negative coordinates");
        }
    }
    }
