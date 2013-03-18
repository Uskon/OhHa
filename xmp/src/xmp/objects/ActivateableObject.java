package xmp.objects;

import xmp.activateableTriggers.Trigger;

public class ActivateableObject extends ClickableObject{
    private Trigger trigger;
    
    public ActivateableObject(int x, int y) {
        super(x, y);
    }
    
    public void activateObject() {
        
    }
}
