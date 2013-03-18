package xmp.activateableTriggers;

public class Trigger {
    private boolean isActivated = false;
    
    public void activateTrigger() {
        this.isActivated = true;
    }
    
    public void deactivateTrigger() {
        this.isActivated = false;
    }
    
    public boolean checkStatus() {
        return this.isActivated;
    }
    
}
