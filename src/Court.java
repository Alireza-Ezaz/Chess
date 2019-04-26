import java.util.ArrayList;

public class Court {
    private Object[][] board;
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
        board = new Object[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                board[i][j] = "  ";
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
        int i = 0;
        //Pawns............................
        for (Pawn pawn : whitePawns) {

            pawn.setCurrenty(i);
            pawn.setCurrentx(6);
            board[6][i] = pawn;
            i++;
        }
        i = 0;
        for (Pawn pawn : blackPawns) {

            pawn.setCurrenty(i);
            pawn.setCurrentx(1);
            board[1][i] = pawn;
            i++;
        }
        //Rooks..............................
        i = 0;
        for (Rook rook : whiteRooks) {

            rook.setCurrenty(i);
            rook.setCurrentx(7);
            board[7][i] = rook;
            i += 7;
        }
        i = 0;
        for (Rook rook : blackRooks) {
            rook.setCurrenty(i);
            rook.setCurrentx(0);
            board[0][i] = rook;
            i += 7;
        }
        //Knights...........................
        i = 1;
        for (Knight knight : whiteKnights) {
            knight.setCurrenty(i);
            knight.setCurrentx(7);
            board[7][i] = knight;
            i += 5;
        }
        i = 1;
        for (Knight knight : blackKnights) {
            knight.setCurrenty(i);
            knight.setCurrentx(0);
            board[0][i] = knight;
            i += 5;
        }
        //Bisop..............................
        i = 2;
        for (Bishop bishop : whiteBishops) {
            bishop.setCurrenty(i);
            bishop.setCurrentx(7);
            board[7][i] = bishop;
            i += 3;
        }
        i = 2;
        for (Bishop bishop : blackBishops) {
            bishop.setCurrenty(i);
            bishop.setCurrentx(0);
            board[0][i] = bishop;
            i += 3;
        }
        whiteQueen.setCurrenty(7);
        whiteQueen.setCurrentx(3);
        board[7][3] = whiteQueen;
        whiteKing.setCurrenty(7);
        whiteKing.setCurrentx(4);
        board[7][4] = whiteKing;

        blackQueen.setCurrenty(0);
        blackQueen.setCurrentx(3);
        board[0][3] = blackQueen;
        blackKing.setCurrenty(0);
        blackKing.setCurrentx(4);
        board[0][4] = blackKing;

    }

    public void displayBoard() {
        System.out.print("   ");
        for (int j = 0; j < 8; j++)
            System.out.print("[" + j + "]  ");
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print("[" + i + "] ");

            for (int j = 0; j < 8; j++)
                System.out.print(board[i][j].toString() + " | ");
            System.out.println();
        }
    }

    //Different kinds of chessmen have access to this method
    public void setBoardField(String s, int x, int y) {
        board[x][y] = s;
    }

    public Object[][] getBoard() {
        return board;
    }
}
