/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.objects;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * ClickableObjectin alaluokka, jonka tehtävänä on mahdollistaa tietyissä tilanteissa vaihtuvien kuvien toteutus.
 * 
 * @see xmp.objects.ClickableObject
 */
public class StaticObject extends ClickableObject {
    /**
     * Lista imageista joihin on mahdollista vaihtaa.
     */
    private ArrayList<Image> images = new ArrayList<>();
    /**
     * Indeksi, jonka image on tällä hetkellä piirrettävissä.
     */
    private int currentImage = 0;

    public StaticObject(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    /**
     * Vaihtaa seuraavan imagen piirrettäväksi.
     */
    public void nextImage() {
        currentImage++;
        if (currentImage >= images.size()) {
            currentImage = 0;
        }
        super.image = images.get(currentImage);
    }
    
    /**
     * Vaihtaa aiemman imagen piirrettäväksi.
     */
    public void previousImage() {
        currentImage--;
        if (currentImage < 0) {
            currentImage = images.size()-1;
        }
        super.image = images.get(currentImage);
    }
    
    /**
     * Lisää StaticObjectille uuden imagen aiempien jatkoksi.
     * @param img 
     */
    public void addImage(Image img) {
        if (super.image == null) {
            super.image = img;
        }
        images.add(img);
    }
    
    /**
     * Uuden imagen voi lisätä myös suoraan Filenä.
     * @param file 
     */
    public void addImageAsFile(File file) {
        try {
            Image img = ImageIO.read(file);
            addImage(img);
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
    
    /**
     * Palauttaa Integer-arvona StaticObjectin tämänhetkisen kohdan imagelistalla.
     * @return 
     */
    public int getState() {
        return this.currentImage;
    }
    
    public void setState(int state) {
        this.currentImage = state;
    }
}
