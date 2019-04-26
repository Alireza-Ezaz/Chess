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
                    Pawn p =(Pawn)board[currentx][currenty];
                    System.out.println(p.getColor()+" "+p.getCurrentx()+" "+p.getCurrenty());
                    if(p.move(desx,desy)||p.capture(desx,desy))
                    {
                        board[desx][desy] = p;
                        p.setCurrentx(desx);
                        p.setCurrenty(desy);

                        board[currentx][currenty] ="  ";
                    }
                    else
                        System.out.println("Illegal move");

                }


            }


        }
    }

}
