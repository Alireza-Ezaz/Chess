

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MyListener implements ActionListener {
    private JButton[][] buttons;
    private JButton[][] outWhites;
    private JButton[][] outBlacks;
    private Object[][] board;
    private ArrayList<ChessMan> whiteChessmen;
    private ArrayList<ChessMan> blackChessmen;
    private static boolean turn = false;//false is white turn
    private JButton turnButton;


    public MyListener(JButton[][] buttons, JButton[][] outWhites, JButton[][] outBlacks, JButton turnButton, Court board) {
        this.buttons = buttons;
        this.board = board.getBoard();
        this.outWhites = outWhites;
        this.outBlacks = outBlacks;
        this.turnButton = turnButton;
        whiteChessmen = board.getWhiteChessMen();
        blackChessmen = board.getBlackChessMen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton tmp = ((JButton) e.getSource());
        if (tmp.getBackground() == Color.red) {
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
            return;
        }
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
                        if (chessMan.getColor().equals("B") && turn == false)
                            return;
                        if (chessMan.getColor().equals("W") && turn == true)
                            return;
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
                        if (board[i][j] instanceof ChessMan) {
                            ChessMan tempChessman = (ChessMan) board[i][j];
                            Icon icon = buttons[i][j].getIcon();

                            if (tempChessman.getColor().equals("B")) {
                                for (int a = 0; a < 2; a++) {
                                    boolean bool = false;
                                    for (int b = 0; b < 8; b++)
                                        if (outBlacks[a][b].getIcon() == null) {
                                            outBlacks[a][b].setIcon(icon);
                                            int z;//dup
                                            bool = true;
                                            break;
                                        }
                                    if (bool == true)
                                        break;
                                }
                            }

                            if (tempChessman.getColor().equals("W")) {
                                for (int a = 0; a < 2; a++) {
                                    boolean bool = false;
                                    for (int b = 0; b < 8; b++)
                                        if (outWhites[a][b].getIcon() == null) {
                                            outWhites[a][b].setIcon(icon);
                                            bool = true;
                                            break;
                                        }
                                    if (bool == true)
                                        break;
                                }
                            }
                        }
                        chessMan.realMove(currentx, currenty, i, j, board, whiteChessmen, blackChessmen);
                        if (turn == false) {
                            turn = true;
                            turnButton.setText("Black turn");
                        } else {
                            turn = false;
                            turnButton.setText("White turn");
                        }

                        if (chessMan instanceof Pawn && chessMan.getColor().equals("W") && i == 0) {
                            try {
                                buttons[i][j].setIcon(new ImageIcon(ImageIO.read(getClass().getResource("QW.jpg"))));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else if (chessMan instanceof Pawn && chessMan.getColor().equals("B") && i == 7) {
                            try {
                                buttons[i][j].setIcon(new ImageIcon(ImageIO.read(getClass().getResource("QB.jpg"))));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else
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

