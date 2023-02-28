import java.util.*;

public class Climbingstairs {
    // Method1 - recursion. (2^n)
    public static int countways(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countways(n - 1) + countways(n - 2);
    }

    // Method2 - Memoization. (O(n))
    public static int countways(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countways(n - 1, ways) + countways(n - 2, ways);
        return ways[n];
    }

    // Tabulation method
    public static int countwaysTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println(countways(n));
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(countways(n, ways));
        System.out.println(countwaysTabulation(n));
    }
}
