import java.util.*;

public class StairClimbVariableJumps {
    //10
    //3 3 0 2 1 2 4 2 0 0
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(1);
        }
        int arr[] = new int[n], dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Input "+Arrays.toString(arr)+", n = "+arr.length);
        System.out.println(climbStairsTabulation(arr, n));
        System.out.println(climbStairsMemoized(arr, dp, n));
        System.out.println(climbStairsRecursive(arr, n));
    }

    private static int climbStairsTabulation(int arr[], int n) {
        if (n == 0) return 1;

        int dp[] = new int[n+1];
        dp[0] = 1;
        for (int i=0; i<n; i++) {
            for (int j = i+1; j <= i + arr[i]; j++) {
                if (j > n) break;
                dp[j] += dp[i];
            }
        }
        return dp[n];
    }

    private static int climbStairsMemoized(int arr[], int dp[], int n) {
        if (n == 0) return 1;
        if (dp[n] != -1) return dp[n];
        int ans = 0;
        for (int j = n-1; j >= 0; j--) {
            if (j+arr[j]>= n) {
                ans += climbStairsMemoized(arr, dp, j);
            }
        }
        return dp[n] = ans;
    }

    private static int climbStairsRecursive(int arr[], int n) {
        if (n == 0) return 1;
        int ans = 0;
        for (int j = n-1; j>= 0; j--) {
            if (j+arr[j]>= n) {
                ans += climbStairsRecursive(arr, j);
            }
        }
        return ans;
    }
}