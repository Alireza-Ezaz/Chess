import java.util.ArrayList;

public class Rook extends ChessMan {


    public Rook(String color) {
        super(color);
        setName("R");
    }


    boolean move(int currentx, int currenty, int desx, int desy, Object[][] obj) {
        boolean b = false;
        if(obj[desx][desy] instanceof King)
            return false;
        if (desx == currentx) {
            int yy = desy - currenty;
            if (yy > 0) {
                for (int i = 1; i < yy + 1; i++) {
                    if ((obj[currentx][currenty + i] instanceof String)) {
                        for (int j = currenty + 1; j <= desy - 1; j++)
                            if (!(obj[currentx][j] instanceof String)) {
                                // System.out.println("fog");
                                return false;
                            }
                    }

                    if (!(obj[currentx][currenty + i] instanceof String)) {
                        for (int j = currenty + 1; j <= desy - 1; j++)
                            if (!(obj[currentx][j] instanceof String)) {
                                // System.out.println("fog");
                                return false;
                            }
                        if (sameColorCheck(currentx, currenty, currentx, currenty + i, obj))
                            return true;

                        //System.out.println("Illigal move");

                        return false;
                    }


                }

                b = true;
            }
            if (yy < 0) {
                for (int i = 1; i < -yy + 1; i++) {
                    if ((obj[currentx][currenty - i] instanceof String)) {
                        for (int j = currenty - 1; j >= desy + 1; j--)
                            if (!(obj[currentx][j] instanceof String)) {
                                // System.out.println("fog");
                                return false;
                            }
                    }


                    if (!(obj[currentx][currenty - i] instanceof String)) {
                        for (int j = currenty - 1; j >= desy + 1; j--)
                            if (!(obj[currentx][j] instanceof String)) {
                                // System.out.println("fog");
                                return false;
                            }
                        if (sameColorCheck(currentx, currenty, currentx, currenty - i, obj))
                            return true;

                        return false;
                    }
                }
                b = true;
            }

        }
        if (currenty == desy) {
            int xx = desx - currentx;
            if (xx > 0) {
                for (int i = 1; i < xx + 1; i++) {
                    if ((obj[currentx + i][currenty] instanceof String)) {
                        for (int j = currentx + 1; j <= desx - 1; j++)
                            if (!(obj[j][currenty] instanceof String)) {
                                // System.out.println("fog");
                                return false;
                            }
                    }
                    if (!(obj[currentx + i][currenty] instanceof String)) {
                        for (int j = currentx + 1; j <= desx - 1; j++)
                            if (!(obj[j][currenty] instanceof String)) {
                                // System.out.println("fog");
                                return false;
                            }

                        if (sameColorCheck(currentx, currenty, currentx + i, currenty, obj))
                            return true;
                        //System.out.println("Illigal move");
                        return false;
                    }
                }
                b = true;
            }
            int yy = desy - currenty;
            if (xx < 0) {
                for (int i = 1; i < -xx + 1; i++) {
                    if ((obj[currentx - i][currenty] instanceof String)) {
                        for (int j = currentx - 1; j >= desx + 1; j--)
                            if (!(obj[j][currenty] instanceof String)) {
                                // System.out.println("fog");
                                return false;
                            }
                    }
                    if (!(obj[currentx - i][currenty] instanceof String)) {
                        for (int j = currentx - 1; j >= desx + 1; j--)
                            if (!(obj[j][currenty] instanceof String)) {
                                // System.out.println("fog");
                                return false;
                            }
                        //System.out.println("Illigal move");
                        if (sameColorCheck(currentx, currenty, currentx - i, currenty, obj))
                            return true;
                        return false;

                    }
                    b = true;
                }
            }

        }

        // if (b == false)
        // System.out.println("Illigal move");
        return b;
    }

    void realMove(int currentx, int currenty, int desx, int desy, Object[][] obj, ArrayList w, ArrayList b) {
        if (sameColorCheck(currentx, currenty, desx, desy, obj)) {
            Object o = obj[desx][desy];
            if (w.contains(o))
                w.remove(o);
            if (b.contains(o))
                b.remove(o);

            obj[desx][desy] = (Rook) obj[currentx][currenty];
            setCurrentx(desx);
            setCurrenty(desy);
            obj[currentx][currenty] = "  ";
        }
    }


}
