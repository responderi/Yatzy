package yatzy.gui.listeners.dice;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import yatzy.logic.dice.Dice;
import yatzy.logic.game.*;

/**
 *
 * @author Roni
 */
public class RerollListener implements ActionListener {

    private JButton rerollButton;
    private JButton die1;
    private JButton die2;
    private JButton die3;
    private JButton die4;
    private JButton die5;
    private JButton doneRolling;
    public JTable jTable1;
    
    public RerollListener(JButton button, JButton die1, JButton die2, JButton die3, JButton die4, JButton die5, JButton doneRolling, JTable jTable1){
        this.rerollButton = button;
        this.die1 = die1;
        this.die2 = die2;
        this.die3 = die3;
        this.die4 = die4;
        this.die5 = die5;
        this.doneRolling = doneRolling;
        this.jTable1 = jTable1;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        rerollButton.setEnabled(false);
        die1.setEnabled(true);
        die2.setEnabled(true);
        die3.setEnabled(true);
        die4.setEnabled(true);
        die5.setEnabled(true);
        doneRolling.setEnabled(true);
    }
}