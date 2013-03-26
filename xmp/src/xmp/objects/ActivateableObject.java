package xmp.objects;

import xmp.activateableTriggers.Trigger;

public class ActivateableObject extends ClickableObject{
    private Trigger trigger = null;
    
    public ActivateableObject(int x, int y, int w, int h) {
        super(x, y, w, h);
    }
    
    public void activateObject() {
    }
    
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
}
