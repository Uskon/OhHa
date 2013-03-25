/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import xmp.objects.ClickableObject;

/**
 *
 * @author Uskon
 */
public class GraphicsPanel extends JPanel{
    private ArrayList<ClickableObject> objectList;
    
    public GraphicsPanel() {
        super.setBackground(Color.WHITE);
    }
    
    public ArrayList<ClickableObject> getObjectList() {
        return this.objectList;
    }
    
    public void setObjectList(ArrayList<ClickableObject> list) {
        this.objectList = list;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (ClickableObject object : objectList) {
            object.drawTestGraphics(graphics);
        }
    }
}
