/** 풀이 정리
 *  - 일단 5킬로그램 봉지를 최대한 많이 가지고 가야 하므로, N을 5로 나눈 나머지를 구한다.
 *  - 그 나머지가 3이면 베스트(5로 나눴을때 3으로 나눠떨어지는 나머지는 3밖에 나올 수 없음)
 *  - 아니라면, 나올 수 있는 나머지는
 *  	- 나머지가 1일때, 5를 한번 빼서 6으로 만들 수 있음
 *  	- 나머지가 2일때, 5를 2번 빼서 12로 만들 수 있음
 *  	- 나머지가 4일때, 5를 1번 빼서 9로 만들 수 있음.
 *  - 이렇게 3가지 경우밖에 없다.
 *  - 그렇다면, 이 4가지 경우가 가능한지 보고, 안되면 3과 5로 안나눠지는 거다.
 *  - 나눠진다면, 각각의 개수를 구해서 더해서 출력하면 된다.
 */

package study;
import java.util.Scanner;

public class SugarDeliver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = n/5;
		int rem = n%5;
		switch(rem) {
		case 1: 
			count -=1;
			count +=2;
			break;
		case 2:
			if(count >=2) {
				count -=2;
				count +=4;
			}
			else {
				count = -1;
			}
			break;
		case 3:
			count +=1;
			break;
		case 4:
			if(count >= 1) {
				count -=1;
				count +=3;
			}
			else {
				count -=1;
			}
			break;
		}
		System.out.println(count);
	}

}
