import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        // 연속된 숫자는 제거
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            // System.out.println(arr[i]);
            if (queue.isEmpty()) {
                queue.add(arr[i]);
            } else {
                int n = queue.peekLast();
                // System.out.println(n);
                if (n != arr[i]) {
                    queue.add(arr[i]);
                }
            }
        }

        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            int n = queue.pop();
            answer[i] = n;
        }

        // System.out.println(queue);

        return answer;
    }
}