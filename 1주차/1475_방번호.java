package study;
import java.util.Scanner;

public class RoomNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int[] rNum = new int[N.length()] ;
		for(int i = 0 ; i <N.length() ; i++) {
			rNum[i] = N.charAt(i)-'0';
		}
		
		int[] nSet = new int[10];
		for(int n : rNum ) {
			nSet[n]++;
		}
		
		int dup = nSet[6] + nSet[9];
		if(dup % 2 == 1) {
			nSet[6] = dup/2 +1;
			nSet[9] = dup/2 +1;
		}
		else {
			nSet[6] = dup/2;
			nSet[9] = dup/2;
		}
		
		int max = 0;
		for(int i = 0 ; i < 10 ; i++) {
			if(nSet[i] >= max) {
				max = nSet[i];
			}
		}
		
		System.out.println(max);
		

	}

}
