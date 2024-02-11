package algo0210;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B_1759_암호만들기 {
	    static int L, C; // 암호의 길이, 주어진 문자의 개수
	    static char[] chars; // 주어진 문자 저장
	    static StringBuilder sb = new StringBuilder(); // 암호 담을 문자열
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        L = sc.nextInt();
	        C = sc.nextInt();
	        sc.nextLine(); // 개행 문자 제거
	        chars = new char[C];
	        String[] input = sc.nextLine().split(" ");
	        for (int i = 0; i < C; i++) {
	            chars[i] = input[i].charAt(0);
	        }
	        Arrays.sort(chars); // 정렬
	        
	        combination(0, 0);
	        
	        sc.close();
	    }
	    
	    // 주어진 문자들의 조합 생성
	    static void combination(int start, int depth) {
	    	// 암호의 길이와 같다면
	        if (depth == L) {
	        	// check 함수 호출해서 조건 확인
	            if (check()) {
	                System.out.println(sb.toString());
	            }
	            return;
	        }
	        // 문자 배열 순회하며 조합 생성
	        for (int i = start; i < C; i++) {
	            sb.append(chars[i]); 
	            combination(i + 1, depth + 1);
	            sb.setLength(sb.length() - 1);
	        }
	    }
	    
	    static boolean check() {
	        int vowels = 0; // 모음 개수
	        int consonants = 0; // 자음 개수
	        for (int i = 0; i < sb.length(); i++) {
	            char ch = sb.charAt(i);
	            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	                vowels++;
	            } else {
	                consonants++;
	            }
	        }
	        // 모음이 1개, 자음이 2개 이상이면 true 반환
	        return vowels >= 1 && consonants >= 2;
	    }
	}

