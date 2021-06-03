package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int k = scan.nextInt();
        int[] BK = BKCreator(k);
        Game(BK, k);
    }

    public static void Game(int[] BkM, int k) {
        Scanner scan = new Scanner(System.in);
        String S;
        String[] S1;
        int[] S2 = new int[k];
        for (;;) {
            System.out.println("Enter " + k + " numbers");
            S = scan.nextLine();
            S1 = S.split(" ");
            for (int i = 0; i < S1.length; i++) {
                S2[i] = Integer.parseInt(S1[i]);
            }
            String[] res = new String[k];
            for (int i = 0; i < k; i++) {
                res[i] = "0";
            }
            int a = 0;
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (BkM[i] == S2[j]) {
                        if (i == j) {
                            res[j] = "B";
                            a++;
                        } else {
                            res[j] = "K";
                        }
                    }
                }
            }
            for (int i = 0; i < k; i++) {
                System.out.print(res[i]);
            }
            System.out.println();
            if (a == k) {
                break;
            }
        }
    }

    public static int[] BKCreator(int k) {
        Random rand = new Random();
        int[] BkM = new int[k];
        boolean Tru = true;
        for (int i = 0; i < k; i++) {
            BkM[i] = rand.nextInt(9) + 1;
            Tru = true;
            for (;Tru;) {
                int j;
                for (j = 0; j < i; j++) {
                    if (BkM[j] == BkM[i]) {
                        break;
                    }
                }
                    if (j == i) {
                        Tru = false;
                    } else {
                        BkM[i] = rand.nextInt(9) + 1;
                    }
            }
        }
        return BkM;
    }

}
