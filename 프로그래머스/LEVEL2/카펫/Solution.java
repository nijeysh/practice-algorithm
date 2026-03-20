class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown+yellow;
        for (int i = 1; i <= yellow/i; i++) {
            if (yellow % i == 0) {
                int d = yellow / i; // 가로 d, 세로 i
                int count = 4 + (d*2) + (i*2);  // 대각선 + (가로*2) + (세로*2)
                if (count == brown) {
                    answer[0] = d+2;
                    answer[1] = i+2;
                    break;
                }
            }
        }

        return answer;
    }
}