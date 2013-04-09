package xmp.objects;

import java.awt.Color;
import java.awt.Graphics;
import xmp.activateableTriggers.Trigger;

/**
 * ClickableObject johon on mahdollista/tarkoitus liittää Trigger-olio.
 * @see xmp.objects.ClickableObject
 * @see xmp.activateableTriggers.Trigger
 */
public class ActivateableObject extends ClickableObject{
    /**
     * Objektiin liittyvä Trigger.
     * @see xmp.activateableTriggers.Trigger
     */
    private Trigger trigger = null;
    
    public ActivateableObject(int x, int y, int w, int h) {
        super(x, y, w, h);
    }
    
    public void activateObject() {
    }
    
    /**
     * Jos Trigger on asetettu, tämä metodi yrittää aktivoida sen
     * @see xmp.activateableTriggers.Trigger#activateTrigger() 
     */
    public void triggerObject() {
        if (trigger != null) {
            trigger.activateTrigger();
        }
    }
    
    public void setTrigger(Trigger t) {
        this.trigger = t;
    }
    
    public Trigger getTrigger() {
        return this.trigger;
    }
    
    
    /**
     * Piirtää testausgrafiikan objektille, myöhemmin lisätään oikean grafiikan piirtävä metodi.
     * @param graphics 
     */
    @Override
    public void drawTestGraphics(Graphics graphics) {
        if (getTrigger().checkStatus()==true) {
            graphics.setColor(Color.green);
            graphics.fillOval(coordinateX, coordinateY, width, height);
            graphics.setColor(Color.black);
        }  else {
            graphics.setColor(Color.black);
            graphics.fillOval(coordinateX, coordinateY, width, height);
        }
    }
}
