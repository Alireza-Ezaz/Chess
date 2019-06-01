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
    private Court chessBoard;

    public ChessGraph() {
        myFrame = new JFrame("Chess Game");
        chessBoard = new Court();
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setLayout(new BorderLayout());
        JButton button = new JButton("Chess Game");
        myFrame.add(button, BorderLayout.PAGE_START);
        button.setPreferredSize(new Dimension(10, 250));
        button.setFont(new Font("Arial", Font.PLAIN, 100));

        JPanel board = new JPanel(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = new JButton();
                b.addActionListener(new MyListener(buttons,chessBoard));
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
                if (i == 1 && j>= 0 && j <8) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("PB.jpg"));
                        b.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }
                if (i == 6 && j>= 0 && j <8) {
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

        JPanel leftPanel = new JPanel(new GridLayout(3, 1));
        for (int i = 0; i < 3; i++)
            leftPanel.add(new Button());
        leftPanel.setPreferredSize(new Dimension(800, 80));

        myFrame.getContentPane().add(leftPanel, BorderLayout.LINE_START);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        myFrame.setMaximumSize(dimension);
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setVisible(true);


    }


    public Court getChessBoard() {
        return chessBoard;
    }


}
