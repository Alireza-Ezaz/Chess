public class Queen extends ChessMan {

    public Queen(String color) {
        super(color);
        setName("Q");
    }


    boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        boolean b = false;
        if (desx == currentx) {
            int yy = desy - currenty;
            if (yy > 0) {
                for (int i = 1; i < yy; i++)
                    if (!(obj[currentx][currenty + i] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }
            if (yy < 0) {
                for (int i = 1; i < -yy; i++)
                    if (!(obj[currentx][currenty - i] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }

        }
        if (currenty == desy) {
            int xx = desx - currentx;
            if (xx > 0) {
                for (int i = 1; i < xx; i++)
                    if (!(obj[currentx + i][currenty] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }
            int yy = desy - currenty;
            if (xx < 0) {
                for (int i = 1; i < -xx; i++)
                    if (!(obj[currentx - i][currenty] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }

        }
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
            if (sameColorCheck(currentx, currenty, desx, desy, obj)) {
                obj[desx][desy] = (Queen) obj[currentx][currenty];
                setCurrentx(desx);
                setCurrenty(desy);
                obj[currentx][currenty] = "  ";
            }
        }


        if (b == false)
            System.out.println("Illigal move");
        return false;

    }


}
