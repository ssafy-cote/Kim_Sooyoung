package study;
import java.util.Scanner;

public class ContinuousSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 연속합을 계산하기 위한 dp 배열을 초기화
        int[] dp = new int[n];
        dp[0] = arr[0];

        // 연속합의 최대값을 계산
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }

        // dp 배열에서 최대값을 찾아 출력
        int maxSum = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        System.out.println(maxSum);

        sc.close();
    }
}
