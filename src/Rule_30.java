
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jessa
 */
public class Rule_30 {

    public static void main(String[] args) {
        Rule_30 r30 = new Rule_30();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of generations: ");
        int gen = scan.nextInt();

        int[] current = new int[51];
        int[] next;
        //initializing first gen
        for (int i = 0; i < current.length; i++) {
            current[i] = 0;
        }
        current[current.length / 2] = 1;

        for (int i = 0; i < gen; i++) {
            next = new int[current.length];
            for (int j = 1; j < current.length - 1; j++) {
                next[j] = r30.newCell(current[j - 1], current[j], current[j + 1]);
                //    System.out.println("current j: " + j + " - " + current[j - 1] + " " + current[j] + " " + current[j + 1] + " = " + next[j]);
            }
            current = next;
            r30.display(current);
        }
        System.out.println("");
    }

    private int newCell(int left, int middle, int right) {
        //    int[] ruleset = {0, 0, 0, 1, 1, 1, 1, 0};
        //  System.out.println(left + " " + middle + " " + right + " = ");
        if (left == 1 && middle == 1 && right == 1) {
            return 0;
        } else if (left == 1 && middle == 1 && right == 0) {
            return 0;
        } else if (left == 1 && middle == 0 && right == 1) {
            return 0;
        } else if (left == 1 && middle == 0 && right == 0) {
            return 1;
        } else if (left == 0 && middle == 1 && right == 1) {
            return 1;
        } else if (left == 0 && middle == 1 && right == 0) {
            return 1;
        } else if (left == 0 && middle == 0 && right == 1) {
            return 1;
        } else if (left == 0 && middle == 0 && right == 0) {
            return 0;
        }
        return 0;
    }

    private void display(int[] current) {
        for (int i = 0; i < current.length; i++) {
            //   System.out.print(current[i]);
            if (current[i] == 1) {
                System.out.print("-");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

}
