import java.util.*;

public class Rodcuttingdp {
    // Tabulation O(n*w)
    public static int rodcutting(int length[], int price[], int totrod) {
        int n = price.length;
        int dp[][] = new int[n + 1][totrod + 1];
        for (int i = 0; i < n + 1; i++) {// 0th col
            for (int j = 0; j < totrod + 1; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totrod + 1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]] , dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[n][totrod];
    }

    public static void print(int dp[][]) {
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int length[] = { 2, 5, 3, 6 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totrod = 8;
        System.out.println(rodcutting(length, price, totrod));
    }
}