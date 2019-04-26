public class Pawn extends ChessMan {
    boolean firstTime = true;

    public Pawn(String color) {
        super(color);
        setName("P");

    }

    public boolean move(int x, int y) {
        boolean b = false;

        if (getColor().equals("W")) {
            if (getCurrenty() == y) {
                if (getCurrentx() - 1 == x)
                    b = true;
                if (firstTime == true)
                    if (getCurrentx() - 1 == x || getCurrentx() - 2 == x) {
                        b = true;
                        firstTime = false;
                    }
            }




        }
        if (getColor().equals("B")) {
            if (getCurrenty() == y) {
                if (getCurrentx() == x - 1)
                    b = true;
                if (firstTime == true)
                    if (getCurrentx() == x - 1 || getCurrentx() == x - 2) {
                        b = true;
                        firstTime = false;
                    }
            }
        }
        return b;
    }

//only Pawn has capture method
    public boolean capture(int x, int y) {
        boolean b =false;
        if(getColor().equals("B"))
            if(getCurrentx() + 1 == x)
                if(getCurrenty() + 1 == y || getCurrenty() - 1 == y)
                    b = true;

        if(getColor().equals("W"))
            if(getCurrentx() - 1 == x)
                if(getCurrenty() + 1 == y || getCurrenty() - 1 == y)
                    b = true;


        return  b;
    }
}
