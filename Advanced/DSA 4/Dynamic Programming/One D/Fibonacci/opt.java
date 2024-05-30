package Fibonacci;

import java.util.*;

public class opt {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int a = 0, b = 1, c = 0;

        for (int i = 1; i <= n; i++) {
            c = a + b;
            b = a;
            a = c;
        }

        System.out.print(a);

        scn.close();
    }
}