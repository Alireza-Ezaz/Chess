public class Knight extends ChessMan {

    public Knight(String color) {
        super(color);
        setName("K");
    }


    boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        boolean b = false;

        if (currentx - 2 == desx && (currenty + 1 == desy || currenty - 1 == desy))
            b = true;
        if (currentx + 2 == desx && (currenty + 1 == desy || currenty - 1 == desy))
            b = true;
        if (currenty + 2 == desy && (currentx + 1 == desx || currentx - 1 == desx))
            b = true;
        if (currenty - 2 == desy && (currentx + 1 == desx || currentx - 1 == desx))
            b = true;
//

        if (b == true) {
            if (sameColorCheck(currentx, currenty, desx, desy, obj)) {

                obj[desx][desy] = (Knight) obj[currentx][currenty];
                setCurrentx(desx);
                setCurrenty(desy);
                obj[currentx][currenty] = "  ";
            }
        }

        if (b == false)
            System.out.println("Illigal move!!");
        return false;
    }


}

