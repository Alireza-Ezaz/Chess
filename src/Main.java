import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        Court court = new Court();
        //court.displayBoard();
        Object[][] board = court.getBoard();

        while (true) {
            court.displayBoard();
            System.out.println("Enter x and y for the chess man you want to move");
            int currentx = scan.nextInt();
            int currenty = scan.nextInt();
            System.out.println("Enter x and y of destination");
            int desx = scan.nextInt();
            int desy = scan.nextInt();
            switch (board[currentx][currenty].toString()) {
                case "PB":
                case "PW": {
                    Queen q;
                    Pawn p = (Pawn) board[currentx][currenty];
                    System.out.println(p.getColor() + " " + p.getCurrentx() + " " + p.getCurrenty());
                    if (p.move(desx, desy)) {
                        if (!(board[desx][desy] instanceof String)) {
                            System.out.println("Illegal move");
                            continue;
                        }

                        //chenge the Pawn if in the last Row.......
                        if (p.getColor().equals("W") && desx == 0) {
                            q = new Queen("W");
                            board[desx][desy] = q;
                            board[currentx][currenty] = "  ";
                            continue;
                        }
                        if (p.getColor().equals("B") && desx == 7) {
                            q = new Queen("B");
                            board[desx][desy] = q;
                            board[currentx][currenty] = "  ";
                            continue;
                        }
                        board[desx][desy] = p;
                        p.setCurrentx(desx);
                        p.setCurrenty(desy);
                        board[currentx][currenty] = "  ";
                    } else if (p.capture(desx, desy)) {
                            if(!(board[desx][desy] instanceof String)){
                                if (p.getColor().equals("W") && desx == 0) {
                                    //alaki
                                    int b;
                                    q = new Queen("W");
                                    board[desx][desy] = q;
                                    board[currentx][currenty] = "  ";
                                    continue;
                                }
                                if (p.getColor().equals("B") && desx == 7) {
                                    //alaki
                                    int a;
                                    q = new Queen("B");
                                    board[desx][desy] = q;
                                    board[currentx][currenty] = "  ";
                                    continue;
                                }
                                board[desx][desy] = p;
                                p.setCurrentx(desx);
                                p.setCurrenty(desy);
                                board[currentx][currenty] = "  ";
                            }
                    } else
                        System.out.println("Illegal move");

                }


            }


        }
    }

}
