package algo0318;

/**
 * 메모리: 102448 KB
 * 시간: 580 ms
 * 
 * ### 문제 해결 프로세스(레벨별 bfs)

- 처음 1인 곳들을 모두 q에 넣는다.(좌표들)
- 안익은거 세놓는다.
- q가 빌때까지 반복한다.
    - 날짜 1더한다.
    - q의 길이만큼 반복한다.
        - q에서 하나 빼서 사방탐색 하고, 가능하면 q에 넣는다.
        - true로 체크해 놓는다.
        - 안익은거 개수 1개 뺀다.
    - 개수가 0이면 날짜 return 한다.
- -1 return 한다.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_B_7576_토마토_김수영_레벨별BFS {
	static int N;
	static int M; // 상자의 행, 열
	static int[][] box; // 토마토가 들어가는 상자
	static boolean[][] isRipe; // 안 익었다가 익은 토마토 표시하기 위해
	static int numOfUnripe = 0;
	static Deque<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		isRipe = new boolean[N][M];
		
		// 박스에 토마토의 값 담기
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 0) numOfUnripe +=1; // 익지 않은 토마토 체크
				if(input == 1) {
					isRipe[i][j] = true;
					q.offer(new int[] {i, j});
				}
				box[i][j] = input; 
			}
		}
		
		int days = 0;
		if(numOfUnripe != 0) {
			 days = bfs();
		}
		
		System.out.println(days);
	}

	private static int bfs() {
		int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상 우 하 좌
		int days = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0 ; i < size ; i++) {
				int[] cur = q.poll();
				int cx = cur[0];
				int cy = cur[1];
				for(int d = 0 ; d < 4; d++) { // 사방 탐색
					int nr = cx + deltas[d][0];
					int nc = cy + deltas[d][1];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 경계체크
					if(box[nr][nc] != 0 || isRipe[nr][nc]) continue; // 0이 아니거나, 이미 익은 상태인지 체크
					isRipe[nr][nc] = true;
					numOfUnripe -= 1;
					q.offer(new int[]{nr,nc});
				}
			}
			days++;
			if(numOfUnripe == 0) return days;
		}
		return -1;
	}
}
