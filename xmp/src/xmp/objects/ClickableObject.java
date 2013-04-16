package xmp.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Kaikkien puzzlemekaanisesti oleellisten graafisten elementtien abstrakti
 * yläluokka.
 */
public abstract class ClickableObject {

    Image image = null;
    int coordinateX;
    int coordinateY;
    int width;
    int height;

    /**
     * Luo olion, jos annetut parametrit ovat oikeanlaiset.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param w objektin leveys
     * @param h objektin korkeus
     */
    public ClickableObject(int x, int y, int w, int h) {
        if (x >= 0 && y >= 0) {
            this.coordinateX = x;
            this.coordinateY = y;
        } else if (x < 0 || y < 0) {
            throw new IllegalArgumentException("All values must be non-negative");
        }
        if (w < 1 || h < 1) {
            throw new IllegalArgumentException("Objects dimensions must be positive");
        } else if (w > 0 && h > 0) {
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

    public void setImage(File imagefile) {
        try {
            this.image = ImageIO.read(imagefile);
        } catch (Exception e) {
        }
    }

    /**
     * Kaikki objektit voivat piirtää itselleen jonkinlaisen testigrafiikan.
     *
     * @param graphics
     */
    public void drawTestGraphics(Graphics graphics) {
        graphics.fillOval(coordinateX, coordinateY, width, height);
    }
    
    public void drawImage(Graphics graphics) {
        if (image != null) {
        graphics.drawImage(image, coordinateX, coordinateY, width, height, null);
        } else {
            drawTestGraphics(graphics);
        }
    }
}
