

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyListener implements ActionListener {
    private JButton[][] buttons;
    private Object[][] board;
    private ArrayList<ChessMan> whiteChessmen;
    private ArrayList<ChessMan> blackChessmen;


    public MyListener(JButton[][] buttons, Court board) {
        this.buttons = buttons;
        this.board = board.getBoard();
        whiteChessmen = board.getWhiteChessMen();
        blackChessmen = board.getBlackChessMen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton tmp = ((JButton) e.getSource());
        // if black or white.....
        // look for red and return if found
        if (tmp.getBackground() == Color.WHITE || tmp.getBackground() == Color.BLACK) {

            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++)
                    if (buttons[i][j].getBackground() == Color.red)
                        return;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttons[i][j] == tmp && !(board[i][j] instanceof String)) {
                        ChessMan chessMan;
                        chessMan = (ChessMan) board[i][j];
                        for (int k = 0; k < 8; k++)
                            for (int z = 0; z < 8; z++)
                                if (chessMan.move(i, j, k, z, board)) {
                                    buttons[k][z].setBackground(Color.cyan);
                                    //loop for not being red...
                                    for (int a = 0; a < 8; a++)
                                        for (int b = 0; b < 8; b++)
                                            if (!(buttons[a][b].getBackground() == Color.red))
                                                buttons[i][j].setBackground(Color.red);
                                }

                    }
                }
            }
        }

        //if green find red and save the position set icon
        if (tmp.getBackground() == Color.cyan) {
            int currentx = 0;
            int currenty = 0;
            for (int a = 0; a < 8; a++)
                for (int b = 0; b < 8; b++)
                    if (buttons[a][b].getBackground() == Color.red) {
                        currentx = a;
                        currenty = b;
                    }

            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++)
                    if (buttons[i][j] == tmp) {
                        ChessMan chessMan;
                        chessMan = (ChessMan) board[currentx][currenty];
                        chessMan.realMove(currentx, currenty, i, j, board, whiteChessmen, blackChessmen);
                        buttons[i][j].setIcon(buttons[currentx][currenty].getIcon());
                        buttons[currentx][currenty].setIcon(null);
                    }


            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i % 2 == 1)
                        if (j % 2 == 0) {
                            buttons[i][j].setBackground(Color.WHITE);
                        } else
                            buttons[i][j].setBackground(Color.BLACK);
                    else {
                        if (j % 2 == 0)
                            buttons[i][j].setBackground(Color.BLACK);
                        else
                            buttons[i][j].setBackground(Color.WHITE);
                    }
                }
            }
        }
    }


}

