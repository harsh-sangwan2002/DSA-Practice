import java.util.Scanner;

public class printMultiples {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int count = 1;

        while (count <= n) {
            System.out.println(count + " ");
            count += 4;
        }

        scn.close();
    }
}