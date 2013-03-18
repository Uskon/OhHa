package xmp.objects;

public abstract class ClickableObject {

    int coordinateX;
    int coordinateY;

    public ClickableObject(int x, int y) {
        if (x >= 0 && y >= 0) {
            this.coordinateX = x;
            this.coordinateY = y;
        } else if (x < 0 || y < 0) {
            throw new IllegalArgumentException("All values must be non-negative");
        }
    }

    public void setX(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Value cannot be changed to negative");
        }
        coordinateX = x;
    }

    public void setY(int y) {
        if (y < 0) {
            throw new IllegalArgumentException("Value cannot be changed to negative");
        }
        coordinateY = y;
    }

    public int getX() {
        return this.coordinateX;
    }

    public int getY() {
        return this.coordinateY;
    }
}
