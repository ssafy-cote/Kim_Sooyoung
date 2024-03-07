package algo0307;

import java.util.Scanner;

public class Main_B_1904_01타일_김수영 {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dp = new int[N+1]; // 동적 계획법 사용
		
		System.out.println(fib(N));
	}
	
	// 피보나치...와 비슷한 방식의 함수
	private static int fib(int N) {
		if(N == 1) return 1;
		if(N == 2) return 2;
		if(dp[N] > 0) return dp[N]; // 이미 값이 있으면 반환. -> 시간 단축
		return dp[N] = (fib(N-1) + fib(N-2))%15746; // 여기서 나눠줘야 overflow가 안난다.
	}

}
