

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyListener implements ActionListener {
    private JButton[][] buttons;

    public MyListener(JButton[][] buttons) {
        this.buttons = buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        JButton tmp = ((JButton) e.getSource());
        tmp.setBackground(Color.red);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (buttons[i][j] == tmp && buttons[i][j] instanceof Pawn) {
                    for (int k = i; k >= 0; k--)
                        buttons[k][j].setBackground(Color.magenta);
                }
            }
        }
    }
}
