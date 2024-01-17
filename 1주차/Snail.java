package snail;
import java.util.Scanner;

public class Snail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int ln = n*(n+1) / 2; //배열 길이
		int dir = 1; // 값 넣는 방향
		int r = -1;
		int c = 0; // i, j를 위치로 사용할 수가 없으므로
		int num = 1;
		
		for(int i=n ; i > 0 ; i--) {
			switch(dir) {
				case 1:
					r++;
					for(int j=0 ; j < i ; j++) {
						arr[r][c] = num;
						num++;
						r++;
					}
					r--;
					dir = 2;
					break;
				case 2:
					c++;
					for(int j=0 ; j < i ; j++) {
						arr[r][c] = num;
						num++;
						c++;
					}
					c--;
					dir = 3;
					break;
				case 3:
					r--;
					c--;
					for(int j=0 ; j < i ; j++) {
						arr[r][c] = num;
						num++;
						r--; 
						c--;
					}
					r++;
					c++;
					dir = 1;
					break;
			}
		}
		
		int[] answer = new int[ln];
		int k = 0;
		
		for(int i=0 ; i <n ; i++) {
			for(int j = 0 ; j<n ;j++) {
				if(arr[i][j] ==0 )continue;
				answer[k] = arr[i][j];
				k++;
			}
		}
		
		//return answer;
        
    }
}
