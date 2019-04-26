import java.util.ArrayList;

public class Court {
    private String[][] board;
    private ArrayList<Pawn> whitePawns;
    private ArrayList<Knight> whiteKnights;
    private ArrayList<Bishop> whiteBishops;
    private ArrayList<Rook> whiteRooks;
    private Queen whiteQueen;
    private King whiteKing;

    private ArrayList<Pawn> blackPawns;
    private ArrayList<Knight> blackKnights;
    private ArrayList<Bishop> blackBishops;
    private ArrayList<Rook> blackRooks;
    private Queen blackQueen;
    private King blackKing;

    public Court() {
        board = new String[8][8];
        whitePawns = new ArrayList<>();
        whiteKnights = new ArrayList<>();
        whiteBishops = new ArrayList<>();
        whiteRooks = new ArrayList<>();
        whiteQueen = new Queen("W");
        whiteKing = new King("W");

        blackPawns = new ArrayList<>();
        blackKnights = new ArrayList<>();
        blackBishops = new ArrayList<>();
        blackRooks = new ArrayList<>();
        blackQueen = new Queen("B");
        blackKing = new King("B");

        //creating all Pawns
        for (int i = 0; i < 8; i++) {
            Pawn tempWhitePawn = new Pawn("W");
            whitePawns.add(tempWhitePawn);
            Pawn tempBlackPawn = new Pawn("B");
            blackPawns.add(tempBlackPawn);
        }

        //creating all Knights
        for (int i = 0; i < 2; i++) {
            Knight tempWhiteKnight = new Knight("W");
            whiteKnights.add(tempWhiteKnight);
            Knight tempBlackNight = new Knight("B");
            blackKnights.add(tempBlackNight);
        }

        //creating all Bishops
        for (int i = 0; i < 2; i++) {
            Bishop tempWhiteBishop = new Bishop("W");
            whiteBishops.add(tempWhiteBishop);
            Bishop tempBlackBishop = new Bishop("B");
            blackBishops.add(tempBlackBishop);
        }

        //creating all Rooks

        for (int i = 0; i < 2; i++) {
            Rook tempWhiteRook = new Rook("W");
            whiteRooks.add(tempWhiteRook);
            Rook tempBlackRook = new Rook("B");
            blackRooks.add(tempBlackRook);
        }

        placingChessmen();
        

    }

    //placing chessman in the board
    private void placingChessmen() {
        //Pawns............................
        for (Pawn pawn : whitePawns) {
            int i = 0;
            pawn.setCurrenty(6);
            pawn.setCurrentx(i);
            board[6][i] = pawn.getColor() + pawn.getName();
            i++;
        }
        for (Pawn pawn : blackPawns) {
            int i = 0;
            pawn.setCurrenty(1);
            pawn.setCurrentx(i);
            board[6][i] = pawn.getColor() + pawn.getName();
            i++;
        }
        //Rooks..............................
        for (Rook rook : whiteRooks) {
            int i = 0;
            rook.setCurrenty(7);
            rook.setCurrentx(i);
            board[7][i] = rook.getColor() + rook.getName();
            i += 7;
        }

        for (Rook rook : blackRooks) {
            int i = 0;
            rook.setCurrenty(0);
            rook.setCurrentx(i);
            board[0][i] = rook.getColor() + rook.getName();
            i += 7;
        }
        //Knights...........................
        for (Knight knight : whiteKnights) {
            int i = 1;
            knight.setCurrenty(7);
            knight.setCurrentx(i);
            board[7][i] = knight.getColor() + knight.getName();
            i += 5;
        }
        for (Knight knight : blackKnights) {
            int i = 1;
            knight.setCurrenty(0);
            knight.setCurrentx(i);
            board[0][i] = knight.getColor() + knight.getName();
            i += 5;
        }
        //Bisop..............................
        for (Bishop bishop : whiteBishops) {
            int i = 2;
            bishop.setCurrenty(7);
            bishop.setCurrentx(i);
            board[7][i] = bishop.getColor() + bishop.getName();
            i += 3;
        }
        for (Bishop bishop : blackBishops) {
            int i = 2;
            bishop.setCurrenty(0);
            bishop.setCurrentx(i);
            board[0][i] = bishop.getColor() + bishop.getName();
            i += 3;
        }
        whiteQueen.setCurrenty(7);
        whiteQueen.setCurrentx(3);
        board[3][7] = whiteQueen.getColor() + whiteQueen.getName();
        whiteKing.setCurrenty(7);
        whiteKing.setCurrentx(4);
        board[4][7] = whiteKing.getColor() + whiteKing.getName();

        blackQueen.setCurrenty(0);
        blackQueen.setCurrentx(3);
        board[3][0] = blackQueen.getColor() + blackQueen.getName();
        blackKing.setCurrenty(0);
        blackKing.setCurrentx(4);
        board[4][0] = blackKing.getColor() + blackKing.getName();

    }

    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++)
                System.out.print(board[i][j] + " | ");
            System.out.println();
        }
    }


}
