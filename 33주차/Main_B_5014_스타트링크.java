package algo1001;

import java.util.*;
import java.io.*;

public class Main_B_5014_스타트링크 {

	static int F; // 건물의 총 층수
	static int S; // 현재 위치
	static int G; // 스타트링크 층
	static int U; // 위로 올라가는 버튼
	static int D; // 아래로 내려가는 버튼
	static int[] building; // 빌딩의 해당 층에 가는데 얼마나 걸리는지 체크하는 함수
	static boolean[] isChecked; // 방문체크 배열 
	static Deque<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		building = new int[F+1];
		isChecked = new boolean[F+1]; // 건물의 총 층수만큼 방문배열 생성
		
		int cnt = bfs();
		
		if(cnt == -1) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(cnt);
		}
	}

	private static int bfs() {
		int[] deltas = {U, -D}; // 상 우 하 좌
		
		q.offer(S);
		isChecked[S] = true;
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			if(cur == G) return building[cur];
			for(int d = 0 ; d < 2; d++) { // 위, 아래 탐색
				int nr = cur + deltas[d];
				if(nr < 1 || nr > F) continue; // 경계체크
				if(isChecked[nr]) continue; // 방문체크
				isChecked[nr] = true;
				building[nr] = building[cur] + 1;
				q.offer(nr);
			}
		}
		return -1;
	}
}