import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // h번이 일정 수 이상, 일정 수 이하 인용
        int answer = 0;

        // n번 이상 인용된 논문 n개 이상 (n의 최대값)
        // used[0] = 0번 인용됨 => X
        // used[1] = 1번 인용됨 => 1번 인용된 논문 1개
        // used[2] = 3번 인용됨 => 3번 인용된 논문 1개
        // used[3] = 5번 인용됨 => 5번 인용된 논문 1개
        // used[4] = 6번 인용됨 => 6번 인용된 논문 1개

        // 횟수를 담은 배열
        int[] used = new int[10001];
        for (int i = 0; i < citations.length; i++) {
            // 인용된 횟수
            int count = citations[i];
            used[count]++;
        }

        // 횟수 기준으로 누적
        for (int i = 10000; i > 0; i--) {
            used[i-1] += used[i];
            // 인용된 횟수가 i개 이상임
            if (used[i] >= i) {
                answer = i;
                break;
            }
        }

        // System.out.println(Arrays.toString(citations));
        // System.out.println(Arrays.toString(used));

        return answer;
    }
}