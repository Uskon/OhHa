/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.objects;

import java.awt.Image;
import java.util.ArrayList;

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
        if (currentImage == images.size()) {
            currentImage = 0;
        }
        super.image = images.get(currentImage);
    }
    
    public void previousImage() {
        currentImage--;
        if (currentImage == 0) {
            currentImage = images.size()-1;
        }
        super.image = images.get(currentImage);
    }
    
    
    public void addImage(Image img) {
        images.add(img);
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
    
}
