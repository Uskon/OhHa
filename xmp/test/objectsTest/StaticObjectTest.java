/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objectsTest;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import xmp.objects.StaticObject;

/**
 *
 * @author Uskon
 */
public class StaticObjectTest {
    StaticObject s1;
    Image img1;
    Image img2;
    File imagefile = new File("/images/redbutton.png");
    File altfile = new File("/images/greenbutton.png");
    
    
    public StaticObjectTest() {
    }
    
    @Before
    public void setUp() {
        s1 = new StaticObject(1,1,1,1);
        try {
            img1 = ImageIO.read(imagefile);
            img2 = ImageIO.read(altfile);
        }   catch (Exception e) {
        }
        s1.addImage(img1);
    }
    
    @Test
    public void superImageWillBeSetWhenAddingIfNull() {
        assertTrue(s1.getImage() == img1);
    }
    
    @Test
    public void imagesWillBeAddedToAList() {
        assertTrue(s1.getImages().contains(img1));
    }
    
    @Test
    public void nextImageCanBeSet() {
        s1.nextImage();
        assertTrue(s1.getImage() == img2);
    }
    
    @Test
    public void previousImageCanBeSet() {
        s1.addImage(img2);
        s1.nextImage();
        s1.previousImage();
        assertTrue(s1.getImage() == img1);
    }
}
