/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmp;

/**
 *
 * @author Uskon
 */

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UI implements Runnable {

    private JFrame frame;
    private GraphicsPanel graphicsPanel;

    public UI(GraphicsPanel gpanel) {
        this.graphicsPanel = gpanel;
    }

    @Override
    public void run() {
        frame = new JFrame("xmP");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.add(graphicsPanel);
        frame.addMouseListener(new GraphicsPanelListener(graphicsPanel));
    }

    public JFrame getFrame() {
        return frame;
    }
}
