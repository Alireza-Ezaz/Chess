import java.lang.Math;

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
        if (b == true) {
            obj[desx][desy] = (King) obj[currentx][currenty];
            setCurrentx(desx);
            setCurrenty(desy);
            obj[currentx][currenty] = "  ";
        }

        if (b == false)
            System.out.println("Illegal move");
        return b;
    }


}
