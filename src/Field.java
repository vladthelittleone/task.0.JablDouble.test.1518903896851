import java.util.ArrayList;
import java.util.stream.Stream;

public class Field {

    public static void drawTable(ArrayList<Point> arrayList,int height,int width){
        int line = 0;//the variable that will be responsible for the row
        System.out.print("  ");
        for(int i = 0; i < width;i++){
            System.out.print(i+"  ");
        }

        System.out.println();

        for(int i = 0; i < width*3+3; i++) {
            if(i == 1 || i == width*3+2)
                System.out.print("+");
            System.out.print("-");
            if(i==10) {
                for(int j = 0; j < (width-10);j++) {
                    System.out.print("-");
                }
            }
        } // create the border, for example: --+-----------+--

        for(int i = 0; i < height*width; i+=width) {
            System.out.println();
            for (int j = 0; j < width; j++){
                if(j == 0)
                    System.out.print(line+"|");
                if(j>10)
                    System.out.print(arrayList.get(i+j) + "   ");
                if(j<=10)
                    System.out.print(arrayList.get(i+j)+"  ");
                if(j==10)
                    System.out.print(" ");
            }
            if(line < 10)
                System.out.print(" |");
            if (line >= 10)
                System.out.print("|");
            line++;
            //display the main table where the galaxies will be displayed
        }

        System.out.println();

        for(int i = 0; i < width*3+3; i++) {
            if(i == 1 || i == width*3+2)
                System.out.print("+");
            System.out.print("-");
            if(i==10) {
                for(int j = 0; j < (width-10);j++) {
                    System.out.print("-");
                }
            }
        }//repeat the creation of the border
        //end of the function, go to main()
    }

    public static void clearScreen(){
        for(int i = 0; i < 20; i ++){
            System.out.println();
        }
    }
}
