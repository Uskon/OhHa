package xmp.activateableTriggers;
 /**
  * Olio jonka tehtävänä on säilyttää tilansa totuusarvona.
  * 
  */
public class Trigger {
    /**
     * Triggerin tilanne.
     */
    private boolean isActivated = false;
    /**
     * Sekvenssi johon triggeri kuuluu.
     */
    private TriggerSequence tseq;
    
    /**
     * Yrittää aktivoida triggerin siinä sekvenssissä mihin se on laitettu.
     */
    public void activateTrigger() {
        tseq.activateInCorrectOrder(this);
    }
    
    /**
     * Asettaa triggerin tilan aktiiviseksi, siis isActivated-booleanille arvon true.
     */
    public void forceActivate() {
        this.isActivated = true;
    }
    
    /**
     * Deaktivoi triggerin, eli asettaa isActivatedin falseksi.
     */
    public void deactivateTrigger() {
        this.isActivated = false;
    }
    
    /**
     * Palauttaa triggerin tilanteen.
     */
    public boolean checkStatus() {
        return this.isActivated;
    }
    
    /**
     * Kertoo triggerille mihin sekvenssiin se kuuluu.
     * @param tseq Triggerin sisältävä TriggerSequence.
     */
    public void setTSeq(TriggerSequence tseq) {
        this.tseq = tseq;
    }
}
