import java.util.*;

class Solution {
    
    static int maxSize; // 최대 돌 수 있는 횟수
    static int cnt; // 최소 횟수
    
    public int solution(int[] queue1, int[] queue2) {
        
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        int size = queue1.length;
        maxSize = size*2*2;
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0 ; i < size ; i++ ){
            sum1 += queue1[i];
            q1.offer(queue1[i]);
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }
        
        int depth = 0;
        
        
        int answer = checkSum(q1, q2, sum1, sum2, depth);
        return answer;
    }
    
    private int checkSum(ArrayDeque<Integer> q1, ArrayDeque<Integer> q2, long sum1, long sum2, int depth){
        while(q1 != q2){
            if(depth > maxSize){
                return -1;
            }
            else if(sum1 == sum2){
                return depth;
            }
            else if(sum1 > sum2){
                int popNum = q1.poll();
                q2.offer(popNum);
                sum1 -= popNum;
                sum2 += popNum;
            }
            else if(sum1 < sum2){
                int popNum = q2.poll();
                q1.offer(popNum);
                sum2 -= popNum;
                sum1 += popNum;
            }
            depth ++;
        }
        return depth;
    }
}