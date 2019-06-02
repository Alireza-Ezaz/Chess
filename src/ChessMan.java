import javax.swing.*;
import java.util.ArrayList;

/**
 * This is the ChessMan class
 * @version 1.0
 * @author S.Alireza Ezaz
 */
public abstract class ChessMan extends  JButton {
    private String color;
    private String name = "";
    private int currentx;
    private int currenty;


    public ChessMan(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name + color;

    }

    /**
     * sets the name of ChessMan
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the x dimension of each ChessMan
     * @param currentx
     */
    public void setCurrentx(int currentx) {
        this.currentx = currentx;
    }

    /**
     * sets the Y dimension of each ChessMan
     * @param currenty
     */
    public void setCurrenty(int currenty) {
        this.currenty = currenty;
    }

    /**
     * @return x dimension of each ChessMan
     */
    public int getCurrentx() {
        return currentx;
    }

    /**
     * @return y dimension of each ChessMan
     */
    public int getCurrenty() {
        return currenty;
    }

    /**
     * @return the color of ChessMan
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the name of ChessMan
     */
    public String getName() {
        return name;
    }

    /**
     * check weather the requested move is possible or not
     * @param desx x of destination
     * @param desy y of destination
     * @param obj This is the board of the Game in Array form
     * @return true if move is possible for the chessMan
     */
    abstract boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj);

    /**
     * check what the color of the chessMan is
     * @param desx x of destination
     * @param desy y of destination
     * @param obj This is the board of the Game in Array form
     * @return true if destination field and current field are in the same color
     */
    public boolean sameColorCheck(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        //checking not to capture same color
        //1
        if (obj[desx][desy] instanceof Pawn) {
            Pawn pp = (Pawn) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
               // System.out.println("Illegal move");
                return false;
            }
        }
        //2
        if (obj[desx][desy] instanceof Knight) {
            Knight pp = (Knight) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
               // System.out.println("Illegal move");
                return false;
            }
        }
        //3
        if (obj[desx][desy] instanceof Bishop) {
            Bishop pp = (Bishop) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
               // System.out.println("Illegal move");
                return false;
            }
        }
        //4
        if (obj[desx][desy] instanceof Rook) {
            Rook pp = (Rook) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
               // System.out.println("Illegal move");
                return false;
            }
        }
        //5
        if (obj[desx][desy] instanceof Queen) {
            Queen pp = (Queen) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
                //System.out.println("Illegal move");
                return false;
            }
        }
        return true;
    }

    /**
     * Really does the moving Action
     * @param currentx
     * @param currenty
     * @param desx x of destination
     * @param desy y of destination
     * @param obj This is the board of the Game in Array form
     */
    abstract void realMove(int currentx, int currenty, int desx, int desy, Object[][] obj, ArrayList w, ArrayList b);





}
