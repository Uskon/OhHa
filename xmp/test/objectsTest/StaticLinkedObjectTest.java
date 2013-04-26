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
import xmp.objects.StaticLinkedObject;
import xmp.objects.StaticObject;

/**
 *
 * @author Uskon
 */
public class StaticLinkedObjectTest {
    private StaticLinkedObject slo;
    private StaticObject s1;
    Image img1;
    Image img2;
    File imagefile = new File("/images/redbutton.png");
    File altfile = new File("/images/greenbutton.png");
    
    
    public StaticLinkedObjectTest() {
    }
    
    @Before
    public void setUp() {
        s1 = new StaticObject(1,1,1,1);
        slo = new StaticLinkedObject(s1, 5, 5, 5, 5);
        try {
            img1 = ImageIO.read(imagefile);
            img2 = ImageIO.read(altfile);
        }   catch (Exception e) {
        }
        s1.addImage(img1);
        s1.addImage(img2);
    }
    
    @Test
    public void staticLinkedObjectCanSetStaticObjectNextImage() {
        slo.activate();
        assertTrue(s1.getImage() == img2);
    }
    
    @Test
    public void staticLinkedObjectCanSetStaticObjectPreviousImage() {
        slo.activate();
        slo.setDirectionForward(false);
        slo.activate();
        assertTrue(s1.getImage() == img1);
    }
}
