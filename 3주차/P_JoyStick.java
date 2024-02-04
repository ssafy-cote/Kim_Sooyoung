package study;

import java.util.Arrays;
import java.util.Scanner;

public class P_JoyStick {
	
	static char[] name;
	static int move = 0;
	static int dupA = 0;
	static int index = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		name = str.toCharArray();
		
		updown(name);
		leftRight(name);
		
		System.out.println(move);

	}
	
	// A를 다른 문자로 바꾸는 함수
	private static void updown(char[] name) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int index = 0;
		for(char n : name) {
			index = alphabet.indexOf(n);
			// 13보다 같거나 작을 때는 하나씩 늘려가는게 더 빠름
			if( index <= 13) move += index;
			// 13보다 클때는 뒤로 탐색하는게 더 빠름.
			else if(index > 13) move += (25 - index +1);
		}
	}
	
	// 최적의 이동 경로를 찾아서 move에 더해주는 함수
	private static void leftRight(char[] name) {
		for(int i = 0; i < name.length; i++){
            index = i + 1;
            // 연속되는 A 갯수 확인
            while(index < name.length && Arrays.asList(name).indexOf("A")==1){
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move += Math.min(move, i * 2 + name.length - index);
            // 처음부터 뒷부분을 먼저 탐색하는 것이 더 빠른 경우.
            move += Math.min(move, (name.length - index) * 2 + i);
        }
	}

}
