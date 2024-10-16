package algo1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_2512_예산_김수영_이분탐색 {
	
	static int N;
	static int[] request;
	static int budget;
	static int total;
	static int maxVal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		request = new int[N];
		maxVal = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N ; i++) {
			int num = Integer.parseInt(st.nextToken());
			request[i] = num;
			total += num;
			maxVal = Math.max(maxVal, num);
		}
		
		st = new StringTokenizer(br.readLine());
		budget = Integer.parseInt(st.nextToken());
		
		int amount = maxVal;
		
		// 다 더한 값이 예산보다 큰경우
		if(total > budget) {
			amount = change();
		}
		
		System.out.println(amount);
	}

	private static int change() {
		int average = budget/N;
		int goodValue = 0;
		
		for(int i = maxVal ; i >= average ; i--) {
			int sum = 0;
			for(int j = 0 ; j < N ; j++) {
				if(request[j] <= i) sum += request[j];
				else sum += i;
			}
			if(sum <= budget) {
				goodValue = i;
				break;
			}
		}
		
		return goodValue;
		
	}

}
