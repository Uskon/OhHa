/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import xmp.objects.ClickableObject;
import xmp.objects.SwappableObject;
import xmp.utilities.SwappableObjectMemorizer;

/**
 *
 * @author Uskon
 */
public class GraphicsPanelListener implements MouseListener {

    private GraphicsPanel gpanel;
    private SwappableObjectMemorizer smemo = new SwappableObjectMemorizer();

    public GraphicsPanelListener(GraphicsPanel gp) {
        this.gpanel = gp;
    }

    public int mouseX(MouseEvent e) {
        return e.getX() - 3;
    }

    public int mouseY(MouseEvent e) {
        return e.getY() - 25;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (ClickableObject object : gpanel.getObjectList()) {
            if ((mouseX(e) >= object.getX() && mouseX(e) <= object.getX() + object.getW()) && (mouseY(e) >= object.getY() && mouseY(e) <= object.getY() + object.getH())) {
                System.out.println(e.getX() + " " + e.getY());
                if (object.getClass().getName().equals("xmp.objects.SwappableObject")) {
                        smemo.manageSwappables((SwappableObject) object);
                        gpanel.repaint();
                }
            }
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
