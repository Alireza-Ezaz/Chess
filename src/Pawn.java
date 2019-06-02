import java.util.ArrayList;

public class Pawn extends ChessMan {
    boolean firstTime = true;

    public Pawn(String color) {
        super(color);
        setName("P");

    }

    public boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        boolean b = false;

        if (getColor().equals("W")) {
            if (getCurrenty() == desy) {
                if (getCurrentx() - 1 == desx && obj[desx][desy] instanceof String)
                    b = true;
                if (firstTime == true)
                    if ((getCurrentx() - 1 == desx || getCurrentx() - 2 == desx) && obj[desx][desy] instanceof String) {
                        b = true;
                        // firstTime = false;
                    }
            }

        }
        if (getColor().equals("B")) {
            if (getCurrenty() == desy) {
                if (getCurrentx() == desx - 1  && obj[desx][desy] instanceof String)
                    b = true;
                if (firstTime == true)
                    if ((getCurrentx() == desx - 1 || getCurrentx() == desx - 2) && obj[desx][desy] instanceof String) {
                        b = true;
                        //firstTime = false;
                    }
            }
        }

        if (getColor().equals("B"))
            if (currentx + 1 == desx)
                if ((currenty + 1 == desy || currenty - 1 == desy) && !(obj[desx][desy]instanceof String) && sameColorCheck(currentx,currenty,desx,desy,obj))
                    b = true;

        if (getColor().equals("W"))
            if (currentx - 1 == desx)
                if ((currenty + 1 == desy || currenty - 1 == desy)&& !(obj[desx][desy]instanceof String) && sameColorCheck(currentx,currenty,desx,desy,obj))
                    b = true;


        //if (b == false)
        //  System.out.println("Illegal move");
        return b;
    }

    void realMove(int currentx, int currenty, int desx, int desy, Object[][] obj, ArrayList w, ArrayList b) {
        Queen q;


        //chenge the Pawn if in the last Row.......
        if (getColor().equals("W") && desx == 0) {
            q = new Queen("W");
            obj[desx][desy] = q;
            obj[currentx][currenty] = "  ";
            return;
        }
        if (getColor().equals("B") && desx == 7) {
            q = new Queen("B");
            obj[desx][desy] = q;
            obj[currentx][currenty] = "  ";
            return;
        }

        if (sameColorCheck(currentx, currenty, desx, desy, obj)) {
            Object o = obj[desx][desy];
            if (w.contains(o))
                w.remove(o);
            if (b.contains(o))
                b.remove(o);
            firstTime = false;
            obj[desx][desy] = (Pawn) obj[currentx][currenty];
            setCurrentx(desx);
            setCurrenty(desy);
            obj[currentx][currenty] = "  ";
        }
    }





}

