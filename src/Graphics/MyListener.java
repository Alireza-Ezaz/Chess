import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyListener implements ActionListener {
    private JButton[][] myArr;

    public MyListener(JButton[][] myArr) {
        this.myArr = myArr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton tmp= ((JButton)e.getSource());
       for (int i = 0; i < 8; i++){
           for (int j = 0; j < 8; j++){
               if (myArr[i][j] == tmp && myArr[i][j] instanceof ChessMan){
                   for (int k =i; k >= 0; k--)
                       myArr[k][j].setBackground(Color.magenta);
               }
           }
       }
    }
}
