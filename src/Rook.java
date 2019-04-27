public class Rook extends  ChessMan {

    public Rook(String color){
        super(color);
        setName("R");
    }


    boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        boolean b = false;
        if(desx == currentx){
            int yy = desy - currenty;
            if(yy > 0){
                for (int i = 1; i < yy; i++)
                    if (!(obj[currentx][currenty + i] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }
            if(yy < 0){
                for (int i = 1; i < -yy; i++)
                    if (!(obj[currentx][currenty - i] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }

        }
        if(currenty == desy){
            int xx = desx - currentx;
            if(xx > 0){
                for (int i = 1; i < xx; i++)
                    if (!(obj[currentx + i][currenty] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }
            int yy = desy - currenty;
            if(xx < 0){
                for (int i = 1; i < -xx; i++)
                    if (!(obj[currentx - i][currenty] instanceof String)) {
                        System.out.println("Illigal move");
                        return false;
                    }
                b = true;
            }

        }
        if (b == true){
            obj[desx][desy] = (Rook) obj[currentx][currenty];
            setCurrentx(desx);
            setCurrenty(desy);
            obj[currentx][currenty] = "  ";
        }
        if(b == false)
            System.out.println("Illigal move");
        return false;
    }



}
