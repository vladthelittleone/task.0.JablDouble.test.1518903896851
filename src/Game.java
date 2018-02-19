import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    static List<Point> galaxy = new ArrayList<>();
    private static int height,wight;

    public Game(){
        height = 30;
        wight = 30;
        for(int i = 0; i < (wight*height);i++)
            galaxy.add(new Point());
        //set the size of the field, after creating an array and enter our "galaxies"
        // (according to the formula width * height).

        Field.drawTable((ArrayList<Point>) galaxy,height,wight);
        //pass our array and field sizes to the function drawTable
    }

    public static void firstGalaxy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nВведите клетки где будет поселенно первое поколение. (Формат ввода x,y)");
        while (sc.hasNextInt()) {
            int w = Integer.parseInt(sc.next());
            int h = Integer.parseInt(sc.next());
            //create two variables that we enter in order to mark the points
            // where there will be the first "galaxy".
            //enter coordinates until you type any word

                if (h < height && w < wight && h >= 0 && w >= 0) {
                    galaxy.get(w + (wight * h)).setLive(true);
                    Field.clearScreen();
                    Field.drawTable((ArrayList<Point>) galaxy, height, wight);
                    //at the entered point we put that it "alive",
                    // we clear the screen, after we deduce our table again.
                    System.out.println();
                    System.out.println("\nВведите клетки где будет поселенно первое поколение. (Формат ввода x,y)");
                    System.out.println("Для того, чтобы закончить ввод, введите любое слово");
            }
            else
                System.out.println("Ошибка! Вы ввели числа выходящие за границы таблицы.");
        }
        //When the word is entered, the cycle will end and the game will start. Go to main ()
    }

    public static void startGame() {
        System.out.println("START GAME!");
        while (true) {
            for (int i = 0; i < height * wight; i++) {
                int column, row, life = 0;// life - variable that will count how many "living" galaxies are nearby.
                column = i / 10;
                row = (i % 10);
                //in a cycle we learn the row and column of each point

                CheckedClass checkedClass = new CheckedClass(wight,height);
                life = checkedClass.checkLifeLine(i, life, row, column);
                //with the help of the function checkLifeLine - check how many "live" galaxies near the point.
                //function will return a number

                if (life > 3 || life < 2) {
                    galaxy.get(i).setLive(false);
                }
                if (life == 2 || life == 3) {
                    galaxy.get(i).setLive(true);
                }
            }
            Field.clearScreen();
            Field.drawTable((ArrayList<Point>) galaxy, height, wight);
            try {
                Thread.sleep(2000);//create a sleep so that the screen is updated every 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static List<Point> getGalaxy() {
        return galaxy;
    }

    public static int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }
}
