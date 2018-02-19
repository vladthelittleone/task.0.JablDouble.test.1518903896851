import java.util.ArrayList;

public class CheckedClass {
    public static int wight,height;

    public CheckedClass(int wight, int height) {
        this.wight = wight;
        this.height = height;
    }

    public static int checkLifeLine(int i, int k, int row, int column) {
        if (i < wight || i < (wight*height) && i > (wight*height)-wight || (i%wight) == 0 || i%wight == 29) {
            //In this cycle, we check the special cases of our galaxies.
            // As an example: the corner of the table, because she only has 3 neighbors, instead of 8.
            if (i == 0){
                //checked left corner
                k+=checkGalaxy(i + 1);
                k+=checkGalaxy(i + wight);
                k+=checkGalaxy(i + wight+1);
                return k;
            }
            if (i == wight - 1){
                //checked right corner
                k+=checkGalaxy(i - 1);
                k+=checkGalaxy(i + wight);
                k+=checkGalaxy(i + wight-1);
                return k;
            }
            if (i == (wight * height) - 1){
                //check the bottom right corner
                k+=checkGalaxy(i - 1);
                k+=checkGalaxy(i - wight);
                k+=checkGalaxy(i - wight-1);
                return k;
            }
            if ( i == (wight * height) - wight){
                //check the bottom left corner
                k+=checkGalaxy(i + 1);
                k+=checkGalaxy(i - wight);
                k+=checkGalaxy(i - wight+1);
                return k;
            }
            if (i > 0 && i < (wight - 1)) {
                //check the top line (1,2,3,4 ... element)
                k+=checkGalaxy(i + wight - 1);
                k+=checkGalaxy(i + wight+1);
                k+=checkGalaxy(i + wight);
                k+=checkGalaxy(i - 1);
                k+=checkGalaxy(i + 1);
                return k;
            }
            if ((i > (wight*height)-wight  && i < (wight*height))) {
                //check the bottom line (91,92,93,94 ... element)
                k+=checkGalaxy(i - wight - 1);
                k+=checkGalaxy(i - wight+1);
                k+=checkGalaxy(i - wight);
                k+=checkGalaxy(i - 1);
                k+=checkGalaxy(i + 1);
                return k;
            }
            if ((i%wight) == 0 && i != 0 && i != (wight * height) - wight) {
                //check the left line(10,20,30,40,50...element)
                k+=checkGalaxy(i - wight);
                k+=checkGalaxy(i - wight+1);
                k+=checkGalaxy(i + 1);
                k+=checkGalaxy(i + wight+1);
                k+=checkGalaxy(i + wight);
                return k;
            }//i%wight == 29
            if (i%wight == 29) {
                //check the right line(19,29,39,49..element)
                k+=checkGalaxy(i - wight);
                k+=checkGalaxy(i - wight-1);
                k+=checkGalaxy(i - 1);
                k+=checkGalaxy(i + wight-1);
                k+=checkGalaxy(i + wight);
                return k;
            }
        }
        else {
            //If the point does not fall under a particular condition, then it is in the center
            k+=checkGalaxy(i - 1);
            k+=checkGalaxy(i + 1);
            k+=checkGalaxy(i - wight - 1);
            k+=checkGalaxy(i - wight);
            k+=checkGalaxy(i -wight + 1);
            k+=checkGalaxy(i + wight - 1);
            k+=checkGalaxy(i + wight);
            k+=checkGalaxy(i + wight + 1);
            //we check all neighbors in turn
            return k;
        }
        return 0;
    }


    public static int checkGalaxy(int g){
        int k = 0;
        if (Game.getGalaxy().get(g).isLive() == true)
            k++;
        return k;
    }
}
