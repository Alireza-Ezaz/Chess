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
        whiteBishops= new ArrayList<>();
        whiteRooks = new ArrayList<>();
        whiteQueen = new Queen("White");
        whiteKing = new King("White");

        blackPawns = new ArrayList<>();
        blackKnights = new ArrayList<>();
        blackBishops= new ArrayList<>();
        blackRooks = new ArrayList<>();
        blackQueen = new Queen("Black");
        blackKing = new King("Black");

        //creating all Pawns
        for(int i = 0 ;i<8;i++){
            Pawn tempWhitePawn = new Pawn("white");
            whitePawns.add(tempWhitePawn);
            Pawn tempBlackPawn = new Pawn("Black");
            blackPawns.add(tempBlackPawn);
        }

        //creating all Knights
        for(int i = 0;i<2;i++){
            Knight tempWhiteKnight = new Knight("White");
            whiteKnights.add(tempWhiteKnight);
            Knight tempBlackNight = new Knight("Black");
            blackKnights.add(tempBlackNight);
        }

        //creating all Bishops
        for(int i = 0;i<2;i++){
            Bishop tempWhiteBishop = new Bishop("White");
            whiteBishops.add(tempWhiteBishop);
            Bishop tempBlackBishop = new Bishop("Black");
            blackBishops.add(tempBlackBishop);
        }

        //creating all Rooks

        for(int i = 0;i<2;i++){
            Rook tempWhiteRook = new Rook("White");
            whiteRooks.add(tempWhiteRook);
            Rook tempBlackRook = new Rook("Black");
            blackRooks.add(tempBlackRook);
        }




    }
    




}
