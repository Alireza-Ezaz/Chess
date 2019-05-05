import java.util.Scanner;
import java.lang.Thread;

/**
 * @author S.AlirezaEzaz
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Scanner scan = new Scanner(System.in);
        Court court = new Court();
        //court.displayBoard();
        Object[][] board = court.getBoard();
        Boolean turn = false;

        while (true) {
            if(!court.getWhiteChessMen().contains(court.getWhiteKing())){
                System.out.println("BLACK WON THE GAME!!!!!!");
                System.exit(-1);}
            if(!court.getBlackChessMen().contains(court.getBlackKing())){
                System.out.println("WHITE WON THE GAME!!!!!!");
                System.exit(-1);}
            if (turn) {
                System.out.println("black turn");
                turn = false;
            } else {
                System.out.println("White turn");
                turn = true;
            }
            court.checkKing();
            Thread.sleep(1000);
            // court.checkKing();
            court.displayBoard();

            System.out.println("Enter x and y for the chessman you want to move");
            int currentx = scan.nextInt();
            int currenty = scan.nextInt();
            System.out.println("Enter x and y of destination");
            int desx = scan.nextInt();
            int desy = scan.nextInt();
            switch (board[currentx][currenty].toString()) {
                case "PB":
                case "PW": {
                    Pawn p = (Pawn) board[currentx][currenty];
                    //System.out.println(p.getColor() + " " + p.getCurrentx() + " " + p.getCurrenty());


                    if (p.move(currentx, currenty, desx, desy, board) == true) {
                        p.realMove(currentx, currenty, desx, desy, board, court.getWhiteChessMen(), court.getBlackChessMen());
                        continue;
                    }
                    if (p.capture(currentx, currenty, desx, desy, board)) {
                        p.realCapture(currentx, currenty, desx, desy, board, court.getWhiteChessMen(), court.getBlackChessMen());
                        continue;
                    }
                    break;
                }


                case "KW":
                case "KB": {
                    Knight k = (Knight) board[currentx][currenty];
                    if (k.move(currentx, currenty, desx, desy, board) == true) {

                        k.realMove(currentx, currenty, desx, desy, board, court.getWhiteChessMen(), court.getBlackChessMen());
                        continue;
                    }
                    break;
                }
                case "BW":
                case "BB": {
                    Bishop b = (Bishop) board[currentx][currenty];
                    if (b.move(currentx, currenty, desx, desy, board)) {
                        b.realMove(currentx, currenty, desx, desy, board, court.getWhiteChessMen(), court.getBlackChessMen());
                        continue;
                    }
                    break;
                }
                case "RW":
                case "RB": {
                    Rook r = (Rook) board[currentx][currenty];
                    if (r.move(currentx, currenty, desx, desy, board) == true) {
                        r.realMove(currentx, currenty, desx, desy, board, court.getWhiteChessMen(), court.getBlackChessMen());
                        continue;
                    }
                    break;

                }
                case "QW":
                case "QB": {
                    Queen q = (Queen) board[currentx][currenty];
                    if (q.move(currentx, currenty, desx, desy, board)) {
                        q.realMove(currentx, currenty, desx, desy, board, court.getWhiteChessMen(), court.getBlackChessMen());
                        continue;
                    }
                    break;

                }
                case "SW":
                case "SB": {
                    King k = (King) board[currentx][currenty];
                    if (k.move(currentx, currenty, desx, desy, board) == true) {
                        k.realMove(currentx, currenty, desx, desy, board, court.getWhiteChessMen(), court.getBlackChessMen());
                        continue;
                    }
                    break;

                }
            }


        }


    }
}


