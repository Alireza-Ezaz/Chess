import java.util.ArrayList;

public abstract class ChessMan {
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


    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentx(int currentx) {
        this.currentx = currentx;
    }

    public void setCurrenty(int currenty) {
        this.currenty = currenty;
    }

    public int getCurrentx() {
        return currentx;
    }

    public int getCurrenty() {
        return currenty;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    abstract boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj);

    public boolean sameColorCheck(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        //checking not to capture same color
        //1
        if (obj[desx][desy] instanceof Pawn) {
            Pawn pp = (Pawn) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
                System.out.println("Illegal move");
                return false;
            }
        }
        //2
        if (obj[desx][desy] instanceof Knight) {
            Knight pp = (Knight) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
                System.out.println("Illegal move");
                return false;
            }
        }
        //3
        if (obj[desx][desy] instanceof Bishop) {
            Bishop pp = (Bishop) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
                System.out.println("Illegal move");
                return false;
            }
        }
        //4
        if (obj[desx][desy] instanceof Rook) {
            Rook pp = (Rook) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
                System.out.println("Illegal move");
                return false;
            }
        }
        //5
        if (obj[desx][desy] instanceof Queen) {
            Queen pp = (Queen) obj[desx][desy];
            if (pp.getColor().equals(getColor())) {
                System.out.println("Illegal move");
                return false;
            }
        }
        return true;
    }
    abstract void realMove(int currentx, int currenty, int desx, int desy, Object[][] obj, ArrayList w,ArrayList b);




}
