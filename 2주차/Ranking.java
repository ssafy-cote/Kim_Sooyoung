package study;

import java.util.Scanner;

public class Ranking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Eugene = sc.nextInt();
        int p = sc.nextInt();

        if (n == 0) {
            System.out.println(1);
        } else {
            int[] ranking = new int[n];
            for (int i = 0; i < n; i++) {
                ranking[i] = sc.nextInt();
            }

            if (n == p && ranking[n - 1] >= Eugene) {
                System.out.println(-1);
            } else {
                int rank = n + 1;
                for (int i = 0; i < n; i++) {
                    if (ranking[i] <= Eugene) {
                        rank = i + 1;
                        break;
                    }
                }
                System.out.println(rank);
            }
        }
        sc.close();
    }
}

