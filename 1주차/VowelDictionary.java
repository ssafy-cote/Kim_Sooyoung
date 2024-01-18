package study;
import java.util.Scanner;

public class VowelDictionary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String vowels = sc.next();
		char[] vArr = vowels.toCharArray();
		int[] prev = {781, 156, 31, 6, 1};
		
		int index = 0;
		
		for(int i = 0 ; i < vArr.length ; i++) {
			switch (i) {
			case 0: {
				switch(vArr[i]) {
				case 'A':
					break;
				case 'E':
					index += prev[i];
					break;
				case 'I':
					index += prev[i] *2;
					break;
				case 'O':
					index += prev[i] *3;
					break;
				case 'U':
					index += prev[i] *4;
					break;
				}
				break;
			}
			case 1: {
				switch(vArr[i]) {
				case 'A':
					index += 1;
					break;
				case 'E':
					index += prev[i] + 1;
					break;
				case 'I':
					index += prev[i] *2 + 1;
					break;
				case 'O':
					index += prev[i] *3 + 1;
					break;
				case 'U':
					index += prev[i] *4 + 1;
					break;
				}			
							
				break;
			}
			case 2: {
				switch(vArr[i]) {
				case 'A':
					index += 1;
					break;
				case 'E':
					index += prev[i] + 1;
					break;
				case 'I':
					index += prev[i] *2 + 1;
					break;
				case 'O':
					index += prev[i] *3 + 1;
					break;
				case 'U':
					index += prev[i] *4 + 1;
					break;
				}
				
				break;
			}
			case 3: {
				switch(vArr[i]) {
				case 'A':
					index += 1;
					break;
				case 'E':
					index += prev[i] + 1;
					break;
				case 'I':
					index += prev[i] *2 + 1;
					break;
				case 'O':
					index += prev[i] *3 + 1;
					break;
				case 'U':
					index += prev[i] *4 + 1;
					break;
				}
				
				break;
			}
			case 4: {
				switch(vArr[i]) {
				case 'A':
					index += 1;
					break;
				case 'E':
					index += prev[i] + 1;
					break;
				case 'I':
					index += prev[i] *2 + 1;
					break;
				case 'O':
					index += prev[i] *3 + 1;
					break;
				case 'U':
					index += prev[i] *4 + 1;
					break;
				}
				
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + i);
			}
		}
		index++;
		System.out.println(index);

	}

}
