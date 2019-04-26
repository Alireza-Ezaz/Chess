public class Pawn extends ChessMan {
    boolean firstTime = true;

    public Pawn(String color) {
        super(color);
        setName("P");

    }

    public boolean move(int x, int y) {
        boolean b = false;
        if (getColor().equals("W")) {
            //System.out.println("enterd");
            if (getCurrenty() == y) {
                if (getCurrentx() - 1 == x)
                    b = true;
                if (firstTime == true)
                    if (getCurrentx() - 1 == x || getCurrentx() - 2 == x)
                        b = true;
            }
        }
        if (getColor().equals("B")) {
            System.out.println("enterd");
            if (getCurrenty() == y) {
                if (getCurrentx() == x - 1)
                    b = true;
                if (firstTime == true)
                    if (getCurrentx() == x - 1 || getCurrentx() == x - 2)
                        b = true;
            }
        }
        return b;
    }


    public void capture() {
    }
}
