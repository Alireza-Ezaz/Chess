import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.*;

/**
 * @author S.Alireza Ezaz Haeri
 * @version 1.0
 */
public class ChessGraph extends JButton {
    JFrame myFrame;
    private JButton[][] buttons = new JButton[8][8];
    private JButton[][] outWhites = new JButton[2][8];
    private JButton[][] outblacks = new JButton[2][8];
    private Court chessBoard;


    public ChessGraph() {
        myFrame = new JFrame("Chess Game");
        chessBoard = new Court();
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setLayout(new BorderLayout());
        JButton button = new JButton("Chess Game");
        button.setBackground(Color.lightGray);
        myFrame.add(button, BorderLayout.PAGE_START);
        button.setPreferredSize(new Dimension(10, 250));
        button.setFont(new Font("Arial", Font.PLAIN, 100));
        JPanel board = new JPanel(new GridLayout(8, 8));

        JPanel leftPanel = new JPanel(new GridLayout(3, 1));
        JPanel leftChessPanelBlack = new JPanel(new GridLayout(2, 8));
        JPanel leftChessPanelWhite = new JPanel(new GridLayout(2, 8));

        Dimension dim = new Dimension(50, 50);
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 8; j++) {
                JButton jButton1 = new JButton();
                jButton1.setPreferredSize(dim);
                jButton1.setBackground(Color.lightGray);
                JButton jButton2 = new JButton();
                jButton2.setPreferredSize(dim);
                jButton2.setBackground(Color.lightGray);
                outblacks[i][j] = jButton1;
                outWhites[i][j] = jButton2;
                leftChessPanelBlack.add(jButton1);
                leftChessPanelWhite.add(jButton2);
            }
        leftPanel.add(leftChessPanelBlack);
        JButton turnButton = new JButton("White turn");
        turnButton.setBackground(Color.pink);
        turnButton.setFont(new Font("Arial", Font.PLAIN, 100));
        turnButton.setForeground(Color.red);
        leftPanel.add(turnButton);
        leftPanel.add(leftChessPanelWhite);
        leftPanel.setPreferredSize(new Dimension(1500, 30));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = new JButton();
                b.addActionListener(new MyListener(buttons, outWhites, outblacks,turnButton, chessBoard));
                buttons[i][j] = b;

                if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("HB.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("HW.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("RB.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if ((i == 7 && j == 0) || (i == 7 && j == 7)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("RW.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("BB.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("BW.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if ((i == 0 && j == 4)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("kB.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if ((i == 7 && j == 4)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("kW.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if ((i == 0 && j == 3)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("QB.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if ((i == 7 && j == 3)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("QW.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if (i == 1 && j >= 0 && j < 8) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("PB.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if (i == 6 && j >= 0 && j < 8) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("PW.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }


                if (i % 2 == 1)
                    if (j % 2 == 0) {
                        b.setBackground(Color.WHITE);
                    } else
                        b.setBackground(Color.BLACK);
                else {
                    if (j % 2 == 0)
                        b.setBackground(Color.BLACK);
                    else
                        b.setBackground(Color.WHITE);
                }


                board.add(b);
            }
        }

        myFrame.getContentPane().add(board, BorderLayout.CENTER);


        myFrame.add(leftPanel, BorderLayout.WEST);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        myFrame.setMaximumSize(dimension);
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setVisible(true);


    }


    public Court getChessBoard() {
        return chessBoard;
    }


}
