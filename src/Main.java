import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] graf={{1,2}, {2,3}, {1,3}, {2,4}, {1,4}, {3,4}, {4,1}, {4,3}, {3,3}, {3,1}, {5,5}};
        Scanner in=new Scanner(System.in);
        int point=in.nextInt();

        Graphs graph=new Graphs();
        graph.widthBypass(graf, point);
        graph.heightBypass(graf, point);
    }
}
