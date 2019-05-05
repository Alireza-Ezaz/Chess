import java.lang.Math;
import java.util.ArrayList;

public class King extends ChessMan {

    public King(String color) {
        super(color);
        //s is shah
        setName("S");
    }


    boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        boolean b = false;
        if (sameColorCheck(currentx, currenty, desx, desy, obj))
            if (Math.abs(desx - currentx) <= 1 && Math.abs(desy - currenty) <= 1)
                b = true;


        // if (b == false)
        //System.out.println("Illegal move");
        return b;
    }

    void realMove(int currentx, int currenty, int desx, int desy, Object[][] obj, ArrayList w, ArrayList b) {
        if (sameColorCheck(currentx, currenty, desx, desy, obj)) {
            Object o = obj[desx][desy];
            if (w.contains(o))
                w.remove(o);
            if (b.contains(o))
                b.remove(o);
            obj[desx][desy] = (King) obj[currentx][currenty];
            setCurrentx(desx);
            setCurrenty(desy);
            obj[currentx][currenty] = "  ";
        }
    }


}
