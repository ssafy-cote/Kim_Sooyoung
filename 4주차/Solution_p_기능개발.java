package algo0212;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_p_기능개발 {

	public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answerL = new ArrayList<>();

        // 각 작업의 배포일 계산
        for (int i = progresses.length - 1; i >= 0; i--) {
        	// 남은 진행도 구하기
            int remain = 100 - progresses[i];
            // 남은 진행도를 작업속도로 나눠서 날짜 구하기
            int days = remain / speeds[i];
            // 0으로 나눠떨어지지 않는다면 하루 더 해야 하므로 1 더하기.
            if (remain % speeds[i] != 0)
                days++;
            stack.push(days);
        }

        // 같은 날짜에 배포되는 기능 개수 계산
        while (!stack.isEmpty()) {
            int count = 1;
            int top = stack.pop();
            // 현재 작업보다 앞에 있는 작업 중에서 배포 가능한 작업 계산
            while (!stack.isEmpty() && stack.peek() <= top) {
                stack.pop();
                count++;
            }
            answerL.add(count);
        }

        // List를 배열로 변환
        int[] answer = new int[answerL.size()];
        for (int i = 0; i < answerL.size(); i++) {
            answer[i] = answerL.get(i);
        }

        return answer;
    }

}
