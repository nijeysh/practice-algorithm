import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        // 아래 대각선으로만 이동이 가능하다
        int[][] dp = new int[500][500];
        dp[0][0] = triangle[0][0];
        // dp[1][0] = 7+3, dp[1][1] = 7+8
        // dp[2][0] = 7+3+8, dp[2][1] = 7+3+1 or 7+8+1, dp[2][2] = 7+8+0
        // dp[3][0] = 7+3+8+2, dp[3][1] = 7+3+8+7 or 7+3+1+7 or 7+8+1+7, dp[3][2] = 7+3+1+4 or 7+8+1+4 or 7+8+0+4

        int answer = dp[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 다음위치에 자기껄 저장한다 -> 이어온 경로가 핵심!
                if (j==0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }

                answer = Math.max(answer, dp[i][j]);
                // System.out.println(dp[i][j]);
            }
        }

        return answer;
    }
}