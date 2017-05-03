package yatzy.gui.listeners.end;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Roni
 */
public class EndListener implements ActionListener {

    public EndListener() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
}
