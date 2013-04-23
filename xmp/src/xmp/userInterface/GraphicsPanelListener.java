/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp.userInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import xmp.objects.ActivateableObject;
import xmp.objects.ClickableObject;
import xmp.objects.MoveableObject;
import xmp.objects.StaticLinkedObject;
import xmp.objects.SwappableObject;
import xmp.utilities.ObjectTriggerer;
import xmp.utilities.SwappableObjectMemorizer;

/**
 * GraphicsPanelin kuuntelija, joka on vastuussa ClickableObjectien
 * käsittelystä, lisää toiminnallisuutta tulossa.
 *
 * @see xmp.objects.ClickableObject
 */
public class GraphicsPanelListener implements MouseListener {

    /**
     * GraphicsPanel, johon kuuntelija on asetettu.
     *
     * @see xmp.userInterface.GraphicsPanel
     */
    private GraphicsPanel gpanel;
    /**
     * SwappableObjectien käsittelijä.
     *
     * @see xmp.utilities.SwappableObjectMemorizer
     */
    private SwappableObjectMemorizer smemo;
    /**
     * ActivateableObjectien käsittelijä.
     *
     * @see xmp.utilities.ObjectTriggerer
     */
    private ObjectTriggerer otrig = new ObjectTriggerer();

    public GraphicsPanelListener(GraphicsPanel gp, SwappableObjectMemorizer smemo) {
        this.gpanel = gp;
        this.smemo = smemo;
    }

    /**
     * Määrittää hiiren suhteellisen x-koordinaatin framen sisällä, parempi
     * metodi tulossa, tämä voi aiheuttaa ongelmia eri käyttöjärjestelmillä ja
     * eri kokoisilla ikkunoilla!.
     *
     * @param e
     * @return Hiiren suhteellisen x-koordinaatti
     */
    public int mouseX(MouseEvent e) {
        return e.getX() - 3;
    }

    /**
     * Määrittää hiiren suhteellisen y-koordinaatin framen sisällä, parempi
     * metodi tulossa. Tämä voi aiheuttaa ongelmia eri käyttöjärjestelmillä ja
     * eri kokoisilla ikkunoilla!
     *
     * @param e
     * @return Hiiren suhteellinen y-koordinaatti
     */
    public int mouseY(MouseEvent e) {
        return e.getY() - 25;
    }

    /**
     * Tarkistaa onko klikatussa kohdassa jokin ClickableObject, ja jos on niin
     * suorittaa sopivan metodin.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        for (ClickableObject object : gpanel.getPuzzle().getObjectList()) {
            if ((mouseX(e) >= object.getX() && mouseX(e) <= object.getX() + object.getW()) && (mouseY(e) >= object.getY() && mouseY(e) <= object.getY() + object.getH())) {
                if (object.getClass().getName().equals("xmp.objects.SwappableObject")) {
                    manageSwappables((SwappableObject) object);
                    return;
                }
                if (object.getClass().getName().equals("xmp.objects.ActivateableObject")) {
                    manageActivateables((ActivateableObject) object);
                }
            }
            gpanel.repaint();
        }
        checkPuzzleClearStatus();
    }

    /**
     * Suorittaa SwappableObjectien paikkojen vaihtamisen
     * SwappableObjectMemorizerin kautta.
     *
     * @param object
     */
    public void manageSwappables(SwappableObject object) {
        smemo.manageSwappables(object);
        gpanel.repaint();
        checkPuzzleClearStatus();
    }

    /**
     * Suorittaa ActivateableObjectien aktivoinnin ObjectTriggererin avulla.
     *
     * @param object
     */
    public void manageActivateables(ActivateableObject object) {
        otrig.triggerObject((ActivateableObject) object);
    }
    
    public void manageMoveables(MoveableObject object, int x, int y) {
    }

    public void manageStatics(StaticLinkedObject slo) {
        slo.activate();
    }

    /**
     * Tarkistaa puzzlen suoritustilanteen, ja ilmoittaa onnistumisesta jos
     * tarpeen.
     */
    public void checkPuzzleClearStatus() {
        gpanel.getPuzzle().clearCheck();
        if (gpanel.getPuzzle().isCleared()) {
            this.gpanel.getUIC().getStatustext().setText("Puzzle cleared (Test version)");
            this.gpanel.getUIC().refresh();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
