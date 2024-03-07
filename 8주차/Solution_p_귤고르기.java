package algo0307;

import java.util.Arrays;

public class Solution_p_귤고르기 {
	
	// k와 tanverine을 main의 매개변수로 받기 떄문에 테스트 할 떄는 여기에 고정
	static int k = 2;
	static int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
	
	public static void main(String[] args) {
		int[] count = new int[10_000_001]; // 같은 크기 개수 세는 배열, 최대 10,000,000까지 담을 것이다.
		int num = 0; // 고른 귤 수
		
		// 같은 크기 개수 세기
		for(int i : tangerine) {
			count[i]++; 
		}
		
		// count 오름차순 정렬
		Arrays.sort(count);
		
		// count 내림차순으로 변경
		for(int i = 0 ; i< count.length/2 ; i++) {
			int temp = count[i];
			count[i] = count[count.length - 1 - i];
			count[count.length - 1 - i] = temp;
		}
		
		int idx = 0; // 서로 다른 크기의 개수 
		while(num < k) { // k개 또는 k개보다 많이 고르면 멈춘다.
			num += count[idx];
			idx++; 
		}
		
		System.out.println(idx);
	}

}
