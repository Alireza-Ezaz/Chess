import java.util.ArrayList;

public class Knight extends ChessMan {

    public Knight(String color) {
        super(color);
        setName("K");
    }


    boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        boolean b = false;
        if (!(obj[desx][desy] instanceof String)) {
            ChessMan ch = (ChessMan) obj[desx][desy];
            if (! ch.sameColorCheck(desx, desy, currentx, currenty, obj))
                return false;
        }

        if (currentx - 2 == desx && (currenty + 1 == desy || currenty - 1 == desy))
            b = true;
        if (currentx + 2 == desx && (currenty + 1 == desy || currenty - 1 == desy))
            b = true;
        if (currenty + 2 == desy && (currentx + 1 == desx || currentx - 1 == desx))
            b = true;
        if (currenty - 2 == desy && (currentx + 1 == desx || currentx - 1 == desx))
            b = true;
//


        // if (b == false)
        //  System.out.println("Illigal move!!");
        return b;
    }

    void realMove(int currentx, int currenty, int desx, int desy, Object[][] obj, ArrayList w, ArrayList b) {
        if (sameColorCheck(currentx, currenty, desx, desy, obj)) {
            Object o = obj[desx][desy];
            if (w.contains(o))
                w.remove(o);
            if (b.contains(o))
                b.remove(o);
            obj[desx][desy] = (Knight) obj[currentx][currenty];
            setCurrentx(desx);
            setCurrenty(desy);
            obj[currentx][currenty] = "  ";
        }
    }


}

