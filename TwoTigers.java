import java.util.Scanner;

public class TwoTigers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight1 = sc.nextInt();
        int weight2 = sc.nextInt();
        boolean b = weight1 == weight2 ? true : false;

        System.out.println("b:" + b);
    }
}
