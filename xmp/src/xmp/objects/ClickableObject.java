package xmp.objects;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ClickableObject {

    int coordinateX;
    int coordinateY;
    int width;
    int height;

    public ClickableObject(int x, int y, int w, int h) {
        if (x >= 0 && y >= 0) {
            this.coordinateX = x;
            this.coordinateY = y;
        } else if (x < 0 || y < 0) {
            throw new IllegalArgumentException("All values must be non-negative");
        } if (w < 1 || h < 1) {
            throw new IllegalArgumentException("Objects dimensions must be positive");
        } else if ( w > 0 && h > 0) {
            this.width = w;
            this.height = h;
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
    
    public void setW(int w) {
        if (w > 0) {
            this.width = w;
        }
    }
    
    public void setH(int h) {
        if (h > 0) {
            this.height = h;
        }
    }

    public int getX() {
        return this.coordinateX;
    }

    public int getY() {
        return this.coordinateY;
    }
    
    public int getW() {
        return this.width;
    }
    
    public int getH() {
        return this.height;
    }
    
    public void drawTestGraphics(Graphics graphics) {
        graphics.fillOval(coordinateX, coordinateY, width, height);
    }
    
}
