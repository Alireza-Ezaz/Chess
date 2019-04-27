import java.lang.Math;

public class Bishop extends ChessMan {

    public Bishop(String color) {
        super(color);
        setName("B");
    }


    boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        boolean b = false;
        if (Math.abs(desx - currentx) == Math.abs(desy - currenty)) {
            int xx = desx - currentx;
            int yy = desy - currenty;
            if (xx > 0 && yy > 0) {
                for (int i = 1; i < xx; i++)
                    if (!(obj[currentx + i][currenty + i] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }
            if (xx > 0 && yy < 0) {
                for (int i = 1; i < xx; i++)
                    if (!(obj[currentx + i][currenty - i] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }

            if (xx < 0 && yy > 0) {
                for (int i = 1; i < yy; i++)
                    if (!(obj[currentx - i][currenty + i] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }

            if (xx < 0 && yy < 0) {
                for (int i = 1; i < -xx; i++)
                    if (!(obj[currentx - i][currenty - i] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }

        }
        if (b == true) {
            obj[desx][desy] = (Bishop) obj[currentx][currenty];
            setCurrentx(desx);
            setCurrenty(desy);
            obj[currentx][currenty] = "  ";
        }
        if (b == false)
            System.out.println("Illigal move");

        return false;
    }


}

