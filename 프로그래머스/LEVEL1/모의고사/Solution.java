import java.util.*;

class Solution {
    public List solution(int[] answers) {
        // 3명
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        int a_len = a.length;
        int b_len = b.length;
        int c_len = c.length;

        int a_answer = 0;
        int b_answer = 0;
        int c_answer = 0;

        int[] answer = new int[3];
        for (int i = 0; i < answers.length; i++) {
            int a_index = i % a_len;
            int b_index = i % b_len;
            int c_index = i % c_len;

            if (a[a_index] == answers[i]) {
                answer[0]++;
            }
            if (b[b_index] == answers[i]) {
                answer[1]++;
            }
            if (c[c_index] == answers[i]) {
                answer[2]++;
            }
        }

        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            if (answer[i] == max) {
                list.add(i+1);
            }
        }


        return list;
    }
}