package yatzy.gui.listeners.info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Roni
 */
public class InfoListener implements ActionListener {

    public JFrame frame;
    
    public InfoListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.dispose();
    }
}