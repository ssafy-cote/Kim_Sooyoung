package algo0211;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_S_게임맵최단거리 {

	public static int main(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		int[][] deltas = {{1,0}, {0,1}, {-1, 0}, {0,-1}}; // 하, 좌, 상, 우 순으로 탐색
		
		Queue<int[]> q = new ArrayDeque<>(){};
		
		q.add(new int[] {0,0,1});// 시작 위치를 먼저 저장
		
		while(!q.isEmpty()) { // queue가 빌 때까지 반복
			int[] loc = q.poll();
			int cx = loc[0];
			int cy = loc[1];
			int move = loc[2];
			
			if(cx == n-1 && cy == m-1) return move;
			
			for(int[] delta : deltas) {
				int nx = cx + delta[0];
				int ny = cy + delta[1];
				// 경계 검사
				if(nx < 0 || nx >= n || ny <0 || ny >= m || maps[nx][ny] == 0) continue;
				if(maps[nx][ny] == 1) {
					// 이동한 위치를 queue에 추가
					// 이동 거리를 1 증가시켜서 호출
					q.add(new int[] {nx, ny, move+1});
					maps[nx][ny] = 0;
				}
				
			}
		}
		return -1; // 도착지에 도달할 수 없을 경우
	}
}
