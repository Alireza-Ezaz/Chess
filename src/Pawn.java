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
                if (getCurrentx() - 1 == desx)
                    b = true;
                if (firstTime == true)
                    if (getCurrentx() - 1 == desx || getCurrentx() - 2 == desx) {
                        b = true;
                        firstTime = false;
                    }
            }

        }
        if (getColor().equals("B")) {
            if (getCurrenty() == desy) {
                if (getCurrentx() == desx - 1)
                    b = true;
                if (firstTime == true)
                    if (getCurrentx() == desx - 1 || getCurrentx() == desx - 2) {
                        b = true;
                        firstTime = false;
                    }
            }
        }

        Queen q;

        if (b == true) {
            if (!(obj[desx][desy] instanceof String)) {
                System.out.println("Illegal move");
                return false;
            }

            //chenge the Pawn if in the last Row.......
            if (getColor().equals("W") && desx == 0) {
                q = new Queen("W");
                obj[desx][desy] = q;
                obj[currentx][currenty] = "  ";
                return false;
            }
            if (getColor().equals("B") && desx == 7) {
                q = new Queen("B");
                obj[desx][desy] = q;
                obj[currentx][currenty] = "  ";
                return false;
            }

            obj[desx][desy] = (Pawn) obj[currentx][currenty];
            setCurrentx(desx);
            setCurrenty(desy);
            obj[currentx][currenty] = "  ";
        }
        if (b == false)
            System.out.println("Illegal move");
        return b;
    }


    //only Pawn has capture method
    public boolean capture(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        boolean b = false;
        //System.out.println(getColor());

        if (getColor().equals("B"))
            if (currentx + 1 == desx)
                if (currenty + 1 == desy || currenty - 1 == desy)
                    b = true;

        if (getColor().equals("W"))
            if (currentx - 1 == desx)
                if (currenty + 1 == desy || currenty - 1 == desy)
                    b = true;

        Queen q;


        if (b == true) {

            if (!(obj[desx][desy] instanceof String)) {
                if (getColor().equals("W") && desx == 0) {
                    q = new Queen("W");
                    obj[desx][desy] = q;
                    obj[currentx][currenty] = "  ";
                    return false;
                }
                if (getColor().equals("B") && desx == 7) {
                    q = new Queen("B");
                    obj[desx][desy] = q;
                    obj[currentx][currenty] = "  ";
                    return false;
                }


                if (sameColorCheck(currentx, currenty, desx, desy, obj)){
                obj[desx][desy] = (Pawn) obj[currentx][currenty];
                setCurrentx(desx);
                setCurrenty(desy);
                obj[currentx][currenty] = "  ";}
            }
        }

        //       if (b == false)
        //          System.out.println("Illegal move");
        return b;
    }
}

