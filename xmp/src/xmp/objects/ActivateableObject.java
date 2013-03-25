package xmp.objects;

import xmp.activateableTriggers.Trigger;

public class ActivateableObject extends ClickableObject{
    private Trigger trigger;
    
    public ActivateableObject(int x, int y, int w, int h) {
        super(x, y, w, h);
    }
    
    public void activateObject() {
        
    }
}
