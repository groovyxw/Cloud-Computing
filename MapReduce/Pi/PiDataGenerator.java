import java.util.Scanner;

public class PiDataGenerator {
        public static void main(String[] args) {
                int RandomNumCount = Integer.parseInt(args[0]);
                int radius = Integer.parseInt(args[1]);
                //System.out.println(RandomNumCount + " random numbers will be generated!");
                //System.out.println("The radius number is " + radius);

                int diameter = radius * 2;

                int xvalue = 0;
                int yvalue = 0;
                int inside = 0;
                int outside = 0;
                for(int i=0;i<RandomNumCount;i++){
                    xvalue = (int)(Math.random()*diameter);
                    yvalue = (int)(Math.random()*diameter);

                    System.out.println("(" + xvalue + "," + yvalue + ")");
                    //System.out.println("" + xvalue + " " + yvalue + " ");

                    double check = Math.sqrt(Math.pow((radius-xvalue), 2) +
                                        Math.pow((radius-yvalue), 2));

                        if (check < radius) {
                                inside++;
                        } else {
                                outside++;
                        }
                }
                //System.out.println("");
                System.out.println("inside value " + inside);
                System.out.println("outside value " + outside);

                double possibility = (double)inside / (double)(inside + outside);
                System.out.println("p:" + possibility);
                double piValue = 4 * possibility;
                System.out.println("Pi value is " + piValue);

        }
}